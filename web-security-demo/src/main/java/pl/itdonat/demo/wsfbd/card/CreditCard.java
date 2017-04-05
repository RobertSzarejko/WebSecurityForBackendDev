package pl.itdonat.demo.wsfbd.card;

import lombok.Data;
import pl.itdonat.demo.wsfbd.jpa.CreditCardKindPersistenceConverter;
import pl.itdonat.demo.wsfbd.jpa.LocalDatePersistenceConverter;
import pl.itdonat.demo.wsfbd.user.User;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by r.szarejko on 2017-03-13.
 */
@Entity
@Data
public class CreditCard {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Convert(converter = CreditCardKindPersistenceConverter.class)
    private CreditCardKind kind;
    private String number;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate expiredDate;
    private String cvv;
}
