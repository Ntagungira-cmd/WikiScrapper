package com.stormtech.wikiscrapper.controllers;

import com.stormtech.wikiscrapper.Entities.CovidDataDto;
import com.stormtech.wikiscrapper.utilities.ScrapeCovidData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidDataController {
    ScrapeCovidData scrapeCovidData = new ScrapeCovidData();
    @GetMapping("/data")
    public ResponseEntity<List<CovidDataDto>> getCovidData() throws IOException {
        List<CovidDataDto> covidData = scrapeCovidData.scrapeCovidData();
        return ResponseEntity.ok(covidData);
    }
}
