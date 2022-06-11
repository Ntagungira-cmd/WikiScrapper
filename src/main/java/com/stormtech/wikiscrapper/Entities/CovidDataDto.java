package com.stormtech.wikiscrapper.Entities;

public class CovidDataDto {
    String country;
    Integer deaths;
    Integer cases;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public CovidDataDto(String country, Integer cases, Integer deaths) {
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
    }


}
