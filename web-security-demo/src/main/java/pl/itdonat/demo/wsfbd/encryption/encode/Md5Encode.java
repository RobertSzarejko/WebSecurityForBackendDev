package pl.itdonat.demo.wsfbd.encryption.encode;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
public class Md5Encode implements Encode {

    private final static String SALT = null;

    @Override
    public String encode(String plainText) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(plainText, SALT);
    }

    @Override
    public boolean isCorrectAlgorithm(Algorithm algorithm) {
        return Algorithm.MD5.equals(algorithm);
    }
}
