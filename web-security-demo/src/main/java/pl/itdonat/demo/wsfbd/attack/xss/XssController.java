package pl.itdonat.demo.wsfbd.attack.xss;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

/**
 * Created by rszarejko on 4/1/17.
 */
@Controller
@RequestMapping("/attack/xss")
public class XssController {


    @GetMapping
    public String get(Model model,
              @RequestParam(name = "name", defaultValue = "Bezimienny") String name,
              @RequestParam(name = "jsClean", defaultValue = "false") boolean jsClean){

        return xssExample(model, name, jsClean);
    }

    @PostMapping
    public String post(Model model,
        @RequestParam(name = "name", defaultValue = "Bezimienny") String name,
        @RequestParam(name = "jsClean", defaultValue = "false") boolean jsClean){

        return xssExample(model, name, jsClean);
    }

    private String xssExample(Model model, String name, boolean jsClean) {
        if(jsClean){
            name = Jsoup.clean(name, Whitelist.basicWithImages());
        }

        model.addAttribute("name", name);
        return "/attack/xss";
    }


}
