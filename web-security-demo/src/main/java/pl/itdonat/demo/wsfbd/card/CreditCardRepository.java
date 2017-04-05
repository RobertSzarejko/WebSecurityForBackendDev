package pl.itdonat.demo.wsfbd.card;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

    List<CreditCard> findListByUser_Login(String userLogin);
    Optional<CreditCard> findOneByIdAndUser_Login(Long id,String userLogin);
}
