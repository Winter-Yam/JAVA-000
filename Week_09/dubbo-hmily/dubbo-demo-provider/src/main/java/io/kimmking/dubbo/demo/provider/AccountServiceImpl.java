package io.kimmking.dubbo.demo.provider;

import io.kimmking.dubbo.demo.api.Account;
import io.kimmking.dubbo.demo.api.AccountService;
import io.kimmking.dubbo.demo.api.FreezeService;
import io.kimmking.dubbo.demo.provider.mapper.AccountMapper;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private FreezeService freezeService;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void exchange() {

        Account accountA = new Account();
        Account accountB = new Account();
        accountA.setUserId(1L);
        accountA.setTotal(new BigDecimal(7));

        accountA.setUserId(2L);
        accountA.setTotal(new BigDecimal(1));

        freezeService.freeze(accountA, accountB);
        accountMapper.update(accountA);
        accountMapper.update(accountB);
        freezeService.unfreeze(accountA, accountB);

    }

    @Transactional(rollbackFor = Exception.class)
    public void confirm(Account account) {
        if (account != null) {
            accountMapper.confirm(account);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancel(Account account) {
        if (account != null) {
            accountMapper.cancel(account);
        }
    }
}
