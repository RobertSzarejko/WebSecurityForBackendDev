package pl.itdonat.demo.wsfbd.card;

import lombok.Builder;
import lombok.Value;
import pl.itdonat.demo.wsfbd.DateUtil;
import pl.itdonat.demo.wsfbd.user.UserData;

import java.time.LocalDate;
import java.util.Date;

@Value
@Builder
public class CreditCardData {

    private Long id;
    private String login;
    private CreditCardKind kind;
    private String number;
    private LocalDate expiredDate;
    private String cvv;

    public boolean isActive(){
        return expiredDate !=null && expiredDate.isAfter(LocalDate.now());
    }
    public Date expiredDate(){
        return DateUtil.localDateToDate(expiredDate);
    }

}
