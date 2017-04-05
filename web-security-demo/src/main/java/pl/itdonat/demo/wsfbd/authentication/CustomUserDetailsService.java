package pl.itdonat.demo.wsfbd.authentication;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.user.UserData;
import pl.itdonat.demo.wsfbd.user.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by r.szarejko on 2017-03-20.
 */
@Service
@Log4j
public class CustomUserDetailsService implements UserDetailsService {


    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        UserData userData = userService.getUserDataByLogin(name)
                .filter(UserData::isActive)
                .orElseThrow(() -> new UsernameNotFoundException("Błędna nazwa użytkownika"));

        List<GrantedAuthority> grantedAuthorities = Arrays.stream(userData.getRoles().split(";"))
                .map(s -> new SimpleGrantedAuthority("ROLE_" + s.toUpperCase()))
                .collect(Collectors.toList());

        return userData.buildUserDetails(grantedAuthorities);
    }

}
