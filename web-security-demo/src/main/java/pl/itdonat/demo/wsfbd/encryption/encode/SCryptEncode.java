package pl.itdonat.demo.wsfbd.encryption.encode;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
public class SCryptEncode implements Encode {

    @Override
    public String encode(String plainText) {
        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
        return encoder.encode(plainText);
    }

    @Override
    public boolean isCorrectAlgorithm(Algorithm algorithm) {
        return Algorithm.SCRYPT.equals(algorithm);
    }
}
