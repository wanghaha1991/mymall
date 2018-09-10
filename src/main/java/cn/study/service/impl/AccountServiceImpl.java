package cn.study.service.impl;

import cn.study.mapper.AccountMapper;
import cn.study.pojo.Account;
import cn.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: AccountServiceImpl
 * @ProjectName mymall
 * @Description: TODO
 * @date 2018/9/5 17:07
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public List<Account> getAccounts() {
        return accountMapper.getAccounts();
    }

    @Override
    public Account getAccountById(Integer id) {
      return  accountMapper.queryAccountById(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }
}
