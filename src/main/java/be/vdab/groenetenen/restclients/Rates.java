package be.vdab.groenetenen.restclients;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonAutoDetect
class Rates {
    @JsonProperty("USD")
    private BigDecimal usd;

    //GETTERS
    public BigDecimal getUSD() {
        return usd;
    }
}
