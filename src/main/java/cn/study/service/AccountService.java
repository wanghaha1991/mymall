package cn.study.service;

import cn.study.pojo.Account;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/5 17:02
 */
public interface AccountService {
    /**
     * 获取所有的accounts
     * @return list
     */
    List<Account> getAccounts();

    /**
     * 回显
     * @param id account id
     * @return account
     */
    Account getAccountById(Integer id);

    /**
     * 修改账户信息
     * @param account instance
     */
    void updateAccount(Account account);
}
