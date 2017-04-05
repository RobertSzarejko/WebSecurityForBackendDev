package pl.itdonat.demo.wsfbd.encryption.encode;

import org.junit.Test;

/**
 * Created by r.szarejko on 2017-03-22.
 */
public class Sh256EncodeTest {

    @Test
    public void should(){

        //given
        Sh256Encode encode = new Sh256Encode();
        Sh1Encode encode1 = new Sh1Encode();
        String password = "password";

        //when
        String encrypt = encode.encode(password);
        String encrypt2 = encode1.encode(password);

        //then
        System.out.println(encrypt);
        System.out.println(encrypt2);

    }


}