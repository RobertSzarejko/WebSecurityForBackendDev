package pl.itdonat.demo.wsfbd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import pl.itdonat.demo.wsfbd.authentication.AdminRole;
import pl.itdonat.demo.wsfbd.authentication.UserRole;
import pl.itdonat.demo.wsfbd.card.CreditCardData;
import pl.itdonat.demo.wsfbd.card.CreditCardService;
import pl.itdonat.demo.wsfbd.user.UserData;
import pl.itdonat.demo.wsfbd.user.UserService;

import java.util.List;

/**
 * Created by Robert on 2017-03-05.
 */
@Controller
@RequestMapping("/")
public class MainController {

    private final UserService userService;
    private final CreditCardService creditCardService;

    @Autowired
    public MainController(UserService userService, CreditCardService creditCardService) {
        this.userService = userService;
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public String get(Model model){

        SecurityExpressionRoot securityExpressionRoot = userService.securityExpressionRoot();
        if(securityExpressionRoot.isRememberMe()){
            return "redirect:/info";
        }

        UserData currentUserData = userService.getCurrentUserData().orElse(UserData.builder().build());
        List<CreditCardData> creditCards = creditCardService.userCreditCards(currentUserData.getLogin());
        List<CreditCardData> allCreditCards = creditCardService.allCreditCards();

        model.addAttribute("userName", currentUserData.getFullName());
        model.addAttribute("creditCards", creditCards);
        model.addAttribute("allCreditCards", allCreditCards);
        return "main";
    }

    @Secured(value = "ROLE_ADMIN")
    @PostMapping(path = "/delete")
    public String deletePost(@RequestParam("cardId") Long id){
        creditCardService.removeCreditCardWithId(id);
        return "redirect:/";
    }

    @Secured(value = "ROLE_ADMIN")
    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        creditCardService.removeCreditCardWithId(id);
        return "redirect:/";
    }

}
