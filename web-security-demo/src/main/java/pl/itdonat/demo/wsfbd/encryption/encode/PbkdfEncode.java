package pl.itdonat.demo.wsfbd.encryption.encode;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
public class PbkdfEncode implements Encode {

    @Override
    public String encode(String plainText) {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        return encoder.encode(plainText);
    }

    @Override
    public boolean isCorrectAlgorithm(Algorithm algorithm) {
        return Algorithm.PBKDF.equals(algorithm);
    }
}
