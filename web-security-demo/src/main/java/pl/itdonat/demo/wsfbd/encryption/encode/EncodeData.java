package pl.itdonat.demo.wsfbd.encryption.encode;

import lombok.Builder;
import lombok.Value;
import pl.itdonat.demo.wsfbd.encryption.Algorithm;

/**
 * Created by root on 3/22/17.
 */
@Value
@Builder
public class EncodeData {

    private Algorithm algorithm;
    private String encode;
    private double duration;

}
