package com.jeecourse.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeecourse.account.domain.Account;
import com.jeecourse.account.rest.v1.AccountRestController;
import com.jeecourse.account.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
    private static Logger logger = LoggerFactory.getLogger(AccountRestController.class);
    
    @Autowired
    private AccountService accountService;
    
    /**
     * Retrieves the "Records" page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getRecords(Model model) {
        logger.debug("Received request to show records page");
        System.out.println("**********web.root:"+ System.getProperty("web.root"));
        System.out.println("**********web.sample.root:"+ System.getProperty("web.sample.root"));
        
        // Retrieve all accounts
        List<Account> accounts = accountService.readAllAccount();
        
        // Add to model
        model.addAttribute("accounts", accounts);

        // This will resolve to /WEB-INF/jsp/records.jsp
        return "accountList";
    }    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        logger.debug("Received request to show add page");
        model.addAttribute("account", new Account());
        model.addAttribute("action", "add");
        return "accountForm";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String ceateAccount(@ModelAttribute("account") Account newAccount, RedirectAttributes redirectAttributes) {
        logger.debug("Received request to submit create action");
        
        accountService.createAccount(newAccount);
		redirectAttributes.addFlashAttribute("message", "Successfully created an account.");
        
        //set a flash message?
		return "redirect:/account/";
    }   

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editAccount(@PathVariable("id") Long id, Model model) {
        logger.debug("Received request to submit create action");
		model.addAttribute("account", accountService.readAccount(id));
		model.addAttribute("action", "edit");        
        return "accountForm";
    }     
    
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("account") Account account) {
		accountService.updateAccount(account);
		return "redirect:/account/";
	}
	
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		accountService.deleteAccount(id);
		return "redirect:/account/";
	}
}
