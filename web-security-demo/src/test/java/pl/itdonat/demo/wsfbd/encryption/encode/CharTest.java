package pl.itdonat.demo.wsfbd.encryption.encode;

import org.junit.Test;

/**
 * Created by r.szarejko on 2017-03-23.
 */
public class CharTest {

    @Test
    public void should(){

        //given
        String passwd = "Rozróba";

        //when

        Character.toString ((char) 1);

        //IntStream.range(0, passwd.length()).map(operand -> passwd.charAt(operand)).forEach(System.out::println);




        //IntStream.range(0, 256).map(operand -> new Integer(operand)).map(cnt -> (char) cnt).map(c -> Character.toString ((char) c)).forEach(System.out::println);

        String[] chars = new String[90];
        for(int i = 33; i < 123; i++){
            System.out.println(Character.toString ((char) i)+" "+i);
            chars[i-33] = Character.toString ((char) i);
        }
        //System.out.println(Character.toString ((char) 122));
        System.out.println(chars.length);
        System.out.println(chars);
/*

        int el = 0;
        for(int i1 = 0; i1 < chars.length; i1++){
            for(int i2 = 0; i2 < chars.length; i2++){
                for(int i3 = 0; i3 < chars.length; i3++){
                    for(int i4 = 0; i4 < chars.length; i4++){
                        for(int i5 = 0; i5 < chars.length; i5++){
                            for(int i6 = 0; i6 < chars.length; i6++){
                                String d = chars[i1]+chars[i2]+chars[i3]+chars[i4]+chars[i5]+chars[i6];
                                el++;
                            }
                        }
                    }
                }
                System.out.println("i2: "+i2);
                System.out.println(el);
                System.out.println(chars[i1]+chars[i2]+chars[i3]+chars[i4]+chars[i5]+chars[i6]);
            }
            System.out.println("i1: "+i1);
        }
        System.out.println(el++);
*/
    }

}
