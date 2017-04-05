package pl.itdonat.demo.wsfbd.encryption.encode;

import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by r.szarejko on 2017-03-22.
 */
@Service
public class Sh1Encode extends ShEncode {
    private final static int STRENGTH = 1;
    public static final Algorithm ALGORITHM = Algorithm.SHA1;

    @Override
    int getStrength() {
        return STRENGTH;
    }

    @Override
    Algorithm getAlgorithm() {
        return ALGORITHM;
    }
}
