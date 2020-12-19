package io.kimmking.dubbo.demo.provider;

import io.kimmking.dubbo.demo.api.Account;
import io.kimmking.dubbo.demo.api.FreezeService;
import io.kimmking.dubbo.demo.provider.mapper.FreezeMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class FreezeServiceImpl implements FreezeService {
    @Autowired
    private FreezeMapper freezeMapper;

    @Override
    public void freeze(Account accountA, Account accountB) {

        freezeMapper.freeze(accountA);
        freezeMapper.freeze(accountB);
    }

    @Override
    public void unfreeze(Account accountA, Account accountB) {
        freezeMapper.unfreeze(accountA);
        freezeMapper.unfreeze(accountB);
    }
}
