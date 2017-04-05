package pl.itdonat.demo.wsfbd.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardDataConverter creditCardDataConverter;


    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository, CreditCardDataConverter creditCardDataConverter) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardDataConverter = creditCardDataConverter;
    }

    @PreAuthorize("isFullyAuthenticated() and #login == authentication.name")
    public List<CreditCardData> userCreditCards(@P("login") String login){
        return creditCardRepository.findListByUser_Login(login).stream()
            .map(creditCardDataConverter::convertToData)
            .collect(Collectors.toList());
    }

    @PostFilter("isFullyAuthenticated() and (hasRole('ADMIN') or filterObject.login == authentication.name)")
    public List<CreditCardData> allCreditCards(){
        return creditCardRepository.findAll().stream()
            .map(creditCardDataConverter::convertToData)
            .collect(Collectors.toList());
    }

    @PreAuthorize("isFullyAuthenticated() and " +
            "(hasRole('ADMIN') or @creditCardService.currentUserCanRemoveThisCard(#id, authentication.name))")
    public void removeCreditCardWithId(@P("id") Long id) {
        creditCardRepository.delete(id);
    }

    public boolean currentUserCanRemoveThisCard(Long id, String login){
        return creditCardRepository.findOneByIdAndUser_Login(id, login).isPresent();
    }
}
