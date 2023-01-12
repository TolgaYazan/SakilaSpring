package com.uniyaz.sakila.core.country.dto;

public class CountryCityCountDto {

    public CountryCityCountDto(String countryName, Long cityCount) {
        this.countryName = countryName;
        this.cityCount = cityCount;
    }

    private String countryName;
    private Long cityCount;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getCityCount() {
        return cityCount;
    }

    public void setCityCount(Long cityCount) {
        this.cityCount = cityCount;
    }
}
