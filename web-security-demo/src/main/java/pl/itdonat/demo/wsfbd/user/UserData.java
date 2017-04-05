package pl.itdonat.demo.wsfbd.user;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.itdonat.demo.wsfbd.card.CreditCardData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Predicates.not;

/**
 * Created by Robert on 2017-03-11.
 */
@Value
@Builder
public class UserData {

    private final String login;

    private final String firstName;
    private final String middleName;
    private final String surname;

    private final String email;
    private final String phone;

    private final UserStatus status;

    private final String roles;
    private final String password;

    public String getFullName(){
        return Stream.of(firstName, middleName, surname)
            .filter(not(Strings::isNullOrEmpty))
            .collect(Collectors.joining(" "));
    }

    public boolean isActive(){
        return UserStatus.ACTIVE.equals(status);
    }


    public UserDetails buildUserDetails(List<GrantedAuthority> authorities){
        return org.springframework.security.core.userdetails.User.withUsername(login)
                .accountExpired(false)
                .accountLocked(UserStatus.BLOCKED.equals(status))
                .credentialsExpired(false)
                .password(password)
                .authorities(authorities)
                .disabled(false)
                .build();
    }


}
