package io.kimmking.dubbo.demo.provider.mapper;

import io.kimmking.dubbo.demo.api.Account;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    @Update("update account set balance = balance - #{amount}," +
            " update_time = now()" +
            " where user_id =#{userId}  and  balance > 0  ")
    int update(Account account);

    @Update("update account set status=1 where user_id =#{userId}  and ready=0 ")
    int confirm(Account account);

    @Update("update account set total = total + #{amount} where user_id =#{userId} and status=0")
    int cancel(Account account);
}
