package com.wsb.junitdemo.exchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    private final CurrencyService currencyService;
    private final MoneyService moneyService;

    public ExchangeController(CurrencyService currencyService, MoneyService moneyService) {
        this.currencyService = currencyService;
        this.moneyService = moneyService;
    }

    @GetMapping("/rate")
    public Float rate(@RequestParam(value = "typeCash") String cash) {
        return currencyService.getRate(cash);
    }

    @GetMapping("/inPLN")
    public Float inPLN(@RequestParam(value = "amount") Float amount, @RequestParam(value = "typeCash") String type) {
        return moneyService.getInPLN(amount, type);
    }

    @GetMapping("/exchange")
    public Exchange exchange(@RequestParam(value = "amount") Float amount, @RequestParam(value = "typeCash") String type) {
        return new Exchange(amount, moneyService.getInPLN(amount,type));
    }
}
