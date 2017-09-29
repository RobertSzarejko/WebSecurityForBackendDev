package pl.itdonat.demo.wsfbd.encryption;

import org.springframework.http.MediaType;
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
@RequestMapping("/crypto_one")
public class CryptoOneController {

    private final EncodeService encodeService;

    public CryptoOneController(EncodeService encodeService) {
        this.encodeService = encodeService;
    }

    @GetMapping
    public String get(Model model){

        CryptoData cryptoData = new CryptoData();
        model.addAttribute("data", cryptoData);
        return "crypto_one";
    }

    @PostMapping
    public String postTheSame(Model model, @ModelAttribute(value = "data") CryptoData data){
        List<EncodeData> encodeData = encodeService.prepareEncodedValueByAlgorithm(data.getValue(), data.getAlgorithm(), 10);
        model.addAttribute("data", data);
        model.addAttribute("valueList", encodeData);
        return "crypto_one";
    }
}
