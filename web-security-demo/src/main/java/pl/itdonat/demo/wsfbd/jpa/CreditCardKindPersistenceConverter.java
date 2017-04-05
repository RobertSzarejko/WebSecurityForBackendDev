package pl.itdonat.demo.wsfbd.jpa;

import com.google.common.base.Strings;
import pl.itdonat.demo.wsfbd.card.CreditCardKind;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class CreditCardKindPersistenceConverter implements AttributeConverter<CreditCardKind, String> {

    @Override
    public String convertToDatabaseColumn(CreditCardKind entityValue) {
        if (entityValue != null) {
            return entityValue.getDb();
        }
        return null;
    }

    @Override
    public CreditCardKind convertToEntityAttribute(String databaseValue) {
        if (Strings.isNullOrEmpty(databaseValue)){
            return null;
        }
        return Arrays.stream(CreditCardKind.values())
                .filter(creditCardKind -> databaseValue.equalsIgnoreCase(creditCardKind.getDb()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unknown CreditCard kind: "+databaseValue));
    }
}