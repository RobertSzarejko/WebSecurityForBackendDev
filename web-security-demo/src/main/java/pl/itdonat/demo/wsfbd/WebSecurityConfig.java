package pl.itdonat.demo.wsfbd;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.itdonat.demo.wsfbd.authentication.CustomAuthenticationProvider;
import pl.itdonat.demo.wsfbd.authentication.CustomUserDetailsService;

@Log4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = false, securedEnabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final CustomAuthenticationProvider authenticationProvider;
    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(CustomAuthenticationProvider authenticationProvider, CustomUserDetailsService userDetailsService) {
        this.authenticationProvider = authenticationProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers(
                    "/resources/**",
                    "/css/**",
                    "/fonts/**",
                    "/img/**",
                    "/js/**",
                    "/h2-console/**",
                    "/crypto/**",
                    "/bruteForce/**",
                    "/attack/**"
                ).permitAll()
            .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
            .httpBasic()
                .and()
            .rememberMe()
                .rememberMeCookieName("REMEMBER_ME")
                .useSecureCookie(true)
                .and()
            .csrf().disable()
            .headers()
                .defaultsDisabled()
                .xssProtection().block(false).xssProtectionEnabled(false)

        ;

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
        auth.userDetailsService(userDetailsService);
    }

}