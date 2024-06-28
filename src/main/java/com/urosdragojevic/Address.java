package com.urosdragojevic;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    public String domicileAddressCountry;
    public String domicileAddressPostalCode;
    public String domicileAddressCity;
    public String domicileAddressStreet;
    public String domicileAddressNumber;
    public String domicileAddressAdditionalInfo;
}
