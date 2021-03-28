package com.wsb.junitdemo.exchange;

import org.springframework.stereotype.Service;

@Service
public class MoneyService {

    private final CurrencyService currencyService;

    public MoneyService(CurrencyService service) {
        this.currencyService = service;
    }

    /**
     * Przelicza podaną wartość do PLN.
     *
     * @param amountInUSD wartość w USD
     * @return wartość w PLN
     */
    Float getInPLN(Float amountInUSD, String cash) {
        Float rate = currencyService.getRate(cash);

        return amountInUSD * rate;
    }


}
