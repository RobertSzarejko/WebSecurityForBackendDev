package pl.itdonat.demo.wsfbd.encryption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.itdonat.demo.wsfbd.encryption.encode.EncodeData;
import pl.itdonat.demo.wsfbd.encryption.encode.EncodeService;

import java.util.List;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Controller
@RequestMapping("/crypto")
public class CryptoController {

    private final EncodeService encodeService;

    public CryptoController(EncodeService encodeService) {
        this.encodeService = encodeService;
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("plainText", "");
        return "crypto";
    }

    @PostMapping
    public String post(Model model, @RequestParam String plainText){
        List<EncodeData> encodeData = encodeService.prepareEncodedValueByAlgorithmMap(plainText);
        model.addAttribute("valueList", encodeData);
        model.addAttribute("plainText", plainText);
        return "crypto";
    }

    @PostMapping("/broke")
    @ResponseBody
    public String postBroke(@RequestParam String hash, @RequestParam Algorithm algorithm){
        String bruteForce = encodeService.bruteForce(hash, algorithm);
        return bruteForce;
    }


    @GetMapping("/broke1")
    @ResponseBody
    public String postBroke(Model model){
        return "7654321";
    }


}
