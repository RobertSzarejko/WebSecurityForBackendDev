package pl.itdonat.demo.wsfbd.authentication;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.*;

/**
 * Created by rszarejko on 3/29/17.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Secured(value = "ROLE_ADMIN")
public @interface AdminRole {
}
