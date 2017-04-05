package pl.itdonat.demo.wsfbd.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Robert on 2017-03-11.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDataConverter userDataConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserDataConverter userDataConverter) {
        this.userRepository = userRepository;
        this.userDataConverter = userDataConverter;
    }

    UserData getUserData(User user){
        return userDataConverter.convertToData(user);
    }

    public Optional<UserData> getCurrentUserData(){
        return currentUserDetails()
            .map(userDetails -> userRepository.findOneByLogin(userDetails.getUsername()))
            .flatMap(user -> user)
            .map(this::getUserData);
    }

    public List<UserData> allUsersData(){
        return userRepository.findAll().stream()
            .map(this::getUserData)
            .collect(Collectors.toList());
    }

    public Optional<UserDetails> currentUserDetails(){
        Optional<UserDetails> details = Optional.empty();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication !=null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();
            if(principal instanceof UserDetails){
                details = Optional.of((UserDetails) principal);
            } else {
                throw new RuntimeException("Principal object mast be UserDetails");
            }
        }
        return details;
    }

    public SecurityExpressionRoot securityExpressionRoot(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
        SecurityExpressionRoot securityExpressionRoot = new SecurityExpressionRoot(authentication){};
        securityExpressionRoot.setTrustResolver(trustResolver);
        return securityExpressionRoot;
    }

    public Optional<String> currentUserLogin(){
        return currentUserDetails().map(UserDetails::getUsername);
    }


    public Optional<UserData> getUserDataByLogin(String name) {
        return userRepository.findOneByLogin(name)
                .map(this::getUserData);
    }
}
