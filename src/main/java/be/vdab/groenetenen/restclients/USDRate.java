package be.vdab.groenetenen.restclients;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
class USDRate {
    private Rates rates;

    //GETTERS
    public Rates getRates() {
        return rates;
    }
}
