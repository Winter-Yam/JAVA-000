package io.kimmking.dubbo.demo.provider.mapper;

import io.kimmking.dubbo.demo.api.Account;
import io.kimmking.dubbo.demo.api.Freeze;
import org.apache.ibatis.annotations.Update;

public interface FreezeMapper {

    @Update("update account set freeze_amount=#{freezeAmount} where user_id =#{userId}")
    void freeze(Account account);

    @Update("update account set freeze_amount=0 where user_id =#{userId}")
    void unfreeze(Account account);
}
