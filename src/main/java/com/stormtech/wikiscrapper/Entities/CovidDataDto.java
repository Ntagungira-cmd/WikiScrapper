package com.stormtech.wikiscrapper.Entities;

public class CovidDataDto {
    String country;
    int cases;
    int deaths;
    int recoveries;
    public CovidDataDto() {}
    public CovidDataDto(String country, int cases, int deaths, int recoveries) {
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recoveries = recoveries;
    }
}
