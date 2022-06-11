package com.stormtech.wikiscrapper.utilities;

import com.stormtech.wikiscrapper.Entities.CovidDataDto;
import lombok.val;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class ScrapeCovidData {
    public ArrayList<CovidDataDto> scrapeCovidData() throws IOException {
        ArrayList<CovidDataDto> covidData = new ArrayList<CovidDataDto>();
        val webPage = Jsoup
                .connect("https://en.wikipedia.org/wiki/COVID-19_pandemic_by_country_and_territory")
                .get();
        val tbody= webPage.getElementById("thetable").getElementsByTag("tbody").get(0);

        val rows = tbody
                .children().drop(2);// dropping the headers

        return covidData;
    }
}
