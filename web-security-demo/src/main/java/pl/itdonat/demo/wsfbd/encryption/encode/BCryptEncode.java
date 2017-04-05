package pl.itdonat.demo.wsfbd.encryption.encode;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
public class BCryptEncode implements Encode {

    @Override
    public String encode(String plainText) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(plainText);
    }

    @Override
    public boolean isCorrectAlgorithm(Algorithm algorithm) {
        return Algorithm.BCRYPT.equals(algorithm);
    }
}
