package com.progressSoft.demo.Repository;

import com.progressSoft.demo.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CurrencyReposittory extends JpaRepository<Currency,Long > {
    Optional<Currency> findCurrencyByAmount(Double amount);
    Optional<Currency> findCurrencyByFromCurrencyISO (String fromCurrencyISO);
    Optional<Currency> findCurrencyByToCurrencyISO (String toCurrencyISO);
    Optional<Currency> findCurrencyById (Long id);
//    List<Currency> findByfCurrencyISOCodeAndtCurrencyISOCodeAndAmount(
//            @Param("findCurrencyByAmount")  Double  amount ,
//            @Param("findCurrencyByFromCurrencyISO")  String findCurrencyByFromCurrencyISO,
//            @Param("findCurrencyByToCurrencyISO")  String findCurrencyByToCurrencyISO
//
//    );
}
