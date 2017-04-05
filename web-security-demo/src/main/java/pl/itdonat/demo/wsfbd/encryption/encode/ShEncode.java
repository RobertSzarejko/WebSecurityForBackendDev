package pl.itdonat.demo.wsfbd.encryption.encode;

import lombok.extern.log4j.Log4j;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
@Log4j
public abstract class ShEncode implements Encode {

    private final static String SALT = null;

    abstract int getStrength();
    abstract Algorithm getAlgorithm();

    @Override
    public String encode(String plainText) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(getStrength());
        return encoder.encodePassword(plainText, SALT);
    }

    @Override
    public boolean isCorrectAlgorithm(Algorithm algorithm) {
        return getAlgorithm().equals(algorithm);
    }
}
