package pl.itdonat.demo.wsfbd.encryption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Controller
@RequestMapping("/bruteForce")
public class BruteForceController {

    @GetMapping("/{algorithm}/{hash}")
    public String get(Model model, @PathVariable("algorithm") Algorithm algorithm, @PathVariable("hash") String hash){
        BruteForceData bruteForceData = BruteForceData.builder().algorithm(algorithm).hash(hash).build();
        model.addAttribute("bruteForceData", bruteForceData);
        return "bruteForce";
    }

}
