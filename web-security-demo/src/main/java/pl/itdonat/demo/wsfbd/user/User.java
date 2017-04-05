package pl.itdonat.demo.wsfbd.user;

import lombok.Data;
import pl.itdonat.demo.wsfbd.jpa.LocalDatePersistenceConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by Robert on 2017-03-11.
 */
@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    private Long id;
    private String login;
    private String firstName;
    private String middleName;
    private String surname;
    private String email;
    private String phone;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate createDate;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate confirmedDate;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate blockDate;
    private String roles;
    private String password;

}
