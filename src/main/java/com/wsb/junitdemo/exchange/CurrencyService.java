package com.wsb.junitdemo.exchange;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Float getRate(String cash) {
        String rateJSON = getRateAsJSON(cash);
        String midNode = rateJSON.split("mid\":")[1].split("}")[0];

        return Float.parseFloat(midNode);
    }


    public String getRateAsJSON(String cash) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/"+ cash + "?format=json";
        return this.restTemplate.getForObject(url, String.class);
    }
}
