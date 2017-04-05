package pl.itdonat.demo.wsfbd.encryption;

import lombok.Builder;
import lombok.Value;

/**
 * Created by r.szarejko on 2017-03-24.
 */
@Builder
@Value
public class BruteForceData {
    private Algorithm algorithm;
    private String hash;
    private final Algorithm[] algorithmValues = Algorithm.values();
}