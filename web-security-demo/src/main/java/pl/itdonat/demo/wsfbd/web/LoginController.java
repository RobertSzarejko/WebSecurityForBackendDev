package pl.itdonat.demo.wsfbd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Robert on 2017-03-05.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String get(){
        return "login";
    }

}
