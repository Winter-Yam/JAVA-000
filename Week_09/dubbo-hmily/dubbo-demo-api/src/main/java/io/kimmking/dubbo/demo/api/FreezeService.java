package io.kimmking.dubbo.demo.api;


public interface FreezeService {

    void freeze(Account accountA, Account accountB);

    void unfreeze(Account accountA, Account accountB);
}
