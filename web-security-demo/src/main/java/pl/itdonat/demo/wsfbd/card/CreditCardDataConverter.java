package pl.itdonat.demo.wsfbd.card;

import org.springframework.stereotype.Service;
import pl.itdonat.demo.wsfbd.user.DataConverter;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
class CreditCardDataConverter implements DataConverter<CreditCard, CreditCardData> {

    @Override
    public CreditCardData convertToData(CreditCard entity) {

        checkNotNull(entity, "Unable to convert null entity.");
        return CreditCardData.builder()
            .login(entity.getUser().getLogin())
            .id(entity.getId())
            .kind(entity.getKind())
            .number(entity.getNumber())
            .expiredDate(entity.getExpiredDate())
            .cvv(entity.getCvv())
        .build();
    }

    @Override
    public void updateEntity(CreditCard entity, CreditCardData data) {
        //unable to modify credit card data
    }
}
