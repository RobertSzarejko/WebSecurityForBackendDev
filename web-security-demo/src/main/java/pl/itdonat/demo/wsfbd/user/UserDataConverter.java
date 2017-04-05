package pl.itdonat.demo.wsfbd.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Robert on 2017-03-11.
 */
@Service
public class UserDataConverter implements DataConverter<User, UserData> {

    @Override
    public UserData convertToData(User entity) {

        checkNotNull(entity, "Unable to convert null entity.");
        return UserData.builder()
            .login(entity.getLogin())
            .firstName(entity.getFirstName())
            .middleName(entity.getMiddleName())
            .surname(entity.getSurname())
            .phone(entity.getPhone())
            .email(entity.getEmail())
            .password(entity.getPassword())
            .roles(entity.getRoles())
            .status(prepareStatus(entity))
            .build();

    }

    private UserStatus prepareStatus(User entity) {

        UserStatus status;
        if(isBlocked(entity)){
            status = UserStatus.BLOCKED;
        }else if(isConfirmed(entity)){
            status = UserStatus.ACTIVE;
        }else {
            status = UserStatus.WAITING_FOR_CONFIRMATION;
        }
        return status;
    }

    private boolean isBlocked(User entity) {
        return entity.getBlockDate()!=null && entity.getBlockDate().isBefore(LocalDate.now());
    }

    private Boolean isConfirmed(User entity) {
        return entity.getConfirmedDate()!=null && entity.getConfirmedDate().isBefore(LocalDate.now());
    }

    @Override
    public void updateEntity(User entity, UserData data) {
        entity.setEmail(data.getEmail());
        entity.setPhone(data.getPhone());
        entity.setFirstName(data.getFirstName());
        entity.setMiddleName(data.getMiddleName());
        entity.setSurname(data.getSurname());
    }
}
