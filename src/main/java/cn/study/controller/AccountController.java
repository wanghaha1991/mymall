package cn.study.controller;

import cn.study.pojo.Account;
import cn.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author asus
 * @date 2018/9/5 17:00
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/accounts")
    public String list(Model model) {
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);
        return "account/list";
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    private String update(@PathVariable int id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "account/update";
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    private String update(Account account) {
        accountService.updateAccount(account);
        return "redirect:/accounts";
    }
}
