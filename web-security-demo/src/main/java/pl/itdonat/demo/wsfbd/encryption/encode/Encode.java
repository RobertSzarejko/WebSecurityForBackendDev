package pl.itdonat.demo.wsfbd.encryption.encode;

import pl.itdonat.demo.wsfbd.encryption.Algorithm;

import java.math.BigDecimal;

/**
 * Created by r.szarejko on 2017-03-22.
 */
public interface Encode {

    String encode(String plainText);
    boolean isCorrectAlgorithm(Algorithm algorithm);

    default EncodeData encodeData(Algorithm algorithm, String plainText){
        long start = System.nanoTime();
        //IntStream.range(1,10).forEach(i -> encode(plainText));
        String encode = encode(plainText);
        long stop = System.nanoTime();

        double duration = BigDecimal.valueOf(stop-start).divide(BigDecimal.valueOf(1000000), 3, BigDecimal.ROUND_HALF_DOWN).doubleValue();

        return EncodeData.builder()
                .algorithm(algorithm)
                .encode(encode)
                .duration(duration)
                .build();
    }

}
