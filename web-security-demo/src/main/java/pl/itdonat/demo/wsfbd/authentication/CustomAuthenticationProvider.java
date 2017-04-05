package pl.itdonat.demo.wsfbd.authentication;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.user.UserData;
import pl.itdonat.demo.wsfbd.user.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Robert on 2017-03-12.
 */
@Service
@Log4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserData userData = userService.getUserDataByLogin(name)
            .filter(UserData::isActive)
            .filter(ud -> hasCorrectCredentials(ud, password))
            .orElseThrow(() -> new UsernameNotFoundException("Błędna nazwa użytkownika lub hasło"));

        List<GrantedAuthority> grantedAuthorities = Arrays.stream(userData.getRoles().split(";"))
                .map(s -> new SimpleGrantedAuthority("ROLE_" + s.toUpperCase()))
                .collect(Collectors.toList());

        UserDetails userDetails = userData.buildUserDetails(grantedAuthorities);

        return new UsernamePasswordAuthenticationToken(userDetails, null, grantedAuthorities);
    }

    private boolean hasCorrectCredentials(UserData ud, String password) {
        return passwordEncoder.matches(password, ud.getPassword());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
