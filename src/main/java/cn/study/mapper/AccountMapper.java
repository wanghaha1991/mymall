package cn.study.mapper;

import cn.study.pojo.Account;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/5 17:07
 */
public interface AccountMapper {
    /**
     * 获取所有的account
     * @return list
     */
    List<Account> getAccounts();

    /**
     * get a account
     * @param id id
     * @return account
     */
    Account queryAccountById(Integer id);

    /**
     * 修改账户信息
     * @param account instance
     */
    void updateAccount(Account account);
}
