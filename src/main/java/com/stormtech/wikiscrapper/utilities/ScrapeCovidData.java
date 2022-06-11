package com.stormtech.wikiscrapper.utilities;

import com.stormtech.wikiscrapper.Entities.CovidDataDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ScrapeCovidData {
    //Check if String is numeric
    private static boolean isNumeric(String str){
        if(!str.matches("[0-9]+")){
            return false;
        };
        return true;
    }
    public ArrayList<CovidDataDto> scrapeCovidData() throws IOException {
        ArrayList<CovidDataDto> covidData = new ArrayList<CovidDataDto>();
        Document webPage = Jsoup
                .connect("https://en.wikipedia.org/wiki/COVID-19_pandemic_by_country_and_territory")
                .get();
        Element tbody= webPage.getElementsByTag("tbody").get(12);
        Elements rows = tbody.getElementsByTag("tr");
        rows.remove(0);
        String country=null;
        Integer cases=null;
        Integer deaths=null;
        for (Element row : rows) {
            Elements ths= row.getElementsByTag("th");
            if(ths.size()>0){
                country=ths.get(0).getElementsByTag("a").get(0).text();
            }
            Elements tds= row.getElementsByTag("td");
            if(tds.size()>1){
                if(isNumeric(tds.get(2).text().replace(",",""))){
                    deaths=Integer.parseInt(tds.get(2).text().replace(",",""));
                }
                if(isNumeric(tds.get(3).text().replace(",",""))){
                    cases=Integer.parseInt(tds.get(3).text().replace(",",""));
                }
            }
            covidData.add(new CovidDataDto(country,cases,deaths));
        }
        return covidData;
    }
}
