package com.progressSoft.demo.Controller;

import com.progressSoft.demo.Repository.CurrencyReposittory;
import com.progressSoft.demo.domain.Currency;
import com.progressSoft.demo.domain.CurrencyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@org.springframework.stereotype.Controller
@CrossOrigin(origins = "http://localhost:4200")

public class Controller {

    @Autowired
    private CurrencyReposittory currencyReposittory;
    Logger logger = LoggerFactory.getLogger(Controller.class);

    @ResponseBody
    @PostMapping("/deals")
    public ResponseEntity saveDeals(@RequestBody CurrencyDTO currency) {
        logger.info("start calling (deals)");
        Currency currency1 = new Currency(currency.getId(),
                LocalDateTime.now(),
                currency.getFromCurrencyISO(),
                currency.getToCurrencyISO(),
                currency.getAmount());
        Optional<Currency> deals = currencyReposittory.findCurrencyById(currency.getId());
        if (deals.isPresent()) {
            logger.info("the deals already saved");
            return new ResponseEntity("the deals already saved", HttpStatus.OK);
        } else {
            Currency currency2 = new
                    Currency(currency.getId(),
                    LocalDateTime.now(),
                    currency.getFromCurrencyISO(),
                    currency.getToCurrencyISO(),
                    currency.getAmount());
            logger.info("End calling (deals)");
            return new ResponseEntity(currencyReposittory.save(currency2), HttpStatus.CREATED);
        }
//   return new ResponseEntity(currencyReposittory.save(currency1), HttpStatus.CREATED);

    }

    @ResponseBody
    @GetMapping(value = "deals/{id}")
    public Currency getValue(@PathVariable Long id) {
        logger.info("start calling to get data from database");
        Optional<Currency> currency = currencyReposittory.findCurrencyById(id);

        if (currency.isPresent())
            return currency.get();
        else throw new RuntimeException("DEAL_IS_NOT_FOUND");
// return currency.get();
    }


}
//  List<Currency> currency1=new Currency(currencyReposittory.findById(currency.getId()))
//  List<Currency> currency1 =currencyReposittory
//          .findByfCurrencyISOCodeAndtCurrencyISOCodeAndAmount(currency.getAmount(),
//                  currency.getFromCurrencyISO(),currency.getToCurrencyISO());


////     Currency currency1= new
////             Currency(currency.getId(),
////             LocalDateTime.now(),
////             currency.getFromCurrencyISO(),
////             currency.getToCurrencyISO(),
////             currency.getAmount());
//  if(!currency1.isEmpty()){
//   logger.info("the deals already saved");
//   return new ResponseEntity("the deals already saved",HttpStatus.OK);
//  }else {
//        Currency currency2= new
//             Currency(currency.getId(),
//             LocalDateTime.now(),
//             currency.getFromCurrencyISO(),
//             currency.getToCurrencyISO(),
//             currency.getAmount());
//   return new ResponseEntity(currencyReposittory.save(currency2), HttpStatus.CREATED);
//
//  }
