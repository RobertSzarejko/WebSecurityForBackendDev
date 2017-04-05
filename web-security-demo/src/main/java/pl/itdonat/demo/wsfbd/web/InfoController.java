package pl.itdonat.demo.wsfbd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.itdonat.demo.wsfbd.user.UserData;
import pl.itdonat.demo.wsfbd.user.UserService;

/**
 * Created by r.szarejko on 2017-03-20.
 */
@Controller
@RequestMapping("/info")
public class InfoController {

    private final UserService userService;

    public InfoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String info(Model model){
        model.addAttribute("userName", userService.getCurrentUserData().map(UserData::getFullName).orElse(""));
        return "info";
    }

}
