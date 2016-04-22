package com.springapp.mvc.Controllers;

import com.springapp.mvc.Model.Account;
import com.springapp.mvc.Service.LogInService;
import com.springapp.mvc.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping("/")
public class LogInSignInController {

    @Autowired
    private LogInService logInService;

    @Autowired
    private RegisterService registerService;


    @RequestMapping(method = RequestMethod.GET)
    public String loginForm(ModelMap model) {

        model.addAttribute("account", new Account());
        return "logIn";
    }


    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String checkAccount(
            @ModelAttribute("account")@Valid Account account,
            BindingResult result, Model model, HttpServletRequest request) throws IOException, ClassNotFoundException {

        if (result.hasErrors()) {
            return "logIn";
        }

        if(request.getParameter("login_button")!=null) {

            Long accountId = logInService.authenticate(account.getLogin(), account.getPassword());
            if (accountId != 0) {
                model.addAttribute("account_id", accountId);
                model.addAttribute("userName", account.getLogin());
                model.addAttribute("success", false);
                return "redirect:/crud";
            } else {
                model.addAttribute("error", true);
            }

        }

        if(request.getParameter("signIn_button")!=null){

            if(registerService.isUnique(account.getLogin())){
                registerService.register(account);
                model.addAttribute("success", true);
                model.addAttribute("account_id", account.getId());
                model.addAttribute("userName",account.getLogin());
                return "redirect:/crud";
            }
            else  model.addAttribute("double_login",true);

        }

        return "logIn";
    }

}
