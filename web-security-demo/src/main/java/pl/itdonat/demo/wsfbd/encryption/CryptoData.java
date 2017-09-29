package pl.itdonat.demo.wsfbd.encryption;

import lombok.Data;

@Data
public class CryptoData {

    private String value;
    private Algorithm algorithm = Algorithm.MD5;
    private final Algorithm[] algorithmValues = Algorithm.values();

}
