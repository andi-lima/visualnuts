package com.visualnuts.exercise.two.service;

import com.visualnuts.exercise.two.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CountryServiceTest {

    private CountryService service = new CountryService();
    private static List<Country> countries = new ArrayList<>();

    @BeforeAll
    public static void setUp(){
        Country us = new Country("us", Arrays.asList("en"));
        Country be = new Country("be", Arrays.asList("nl", "fr", "de"));
        Country nl = new Country("nl", Arrays.asList("nl", "fy"));
        Country de = new Country("de", Arrays.asList("de"));
        Country es = new Country("es", Arrays.asList("es"));

        countries.add(us);
        countries.add(be);
        countries.add(nl);
        countries.add(de);
        countries.add(es);
    }

    @Test
    public void getTheNumberOfCountriesTest(){
        Integer count = service.getNumberOfCountries(countries);

        Assertions.assertEquals(5, count);
    }

    @Test
    public void findCountryByOfficialLanguageTest(){
        List<Country> actual = service.findCountriesByOfficialLanguage("es", countries);
        List<Country> expected = Arrays.asList(new Country("es", Arrays.asList("es")));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void countAllOfficialLanguagesTest(){
        Integer actual = service.countAllOfficialLanguages(countries);

        Assertions.assertEquals(8, actual);
    }

    @Test
    public void highestNumberOfOfficialLanguageTest(){
        Country actual = service.highestNumberOfOfficialLanguage(countries);
        Country expected = new Country("be", Arrays.asList("nl", "fr", "de"));

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void mostCommonOfficialLanguageTest(){
        List<String> actual = service.mostCommonOfficialLanguage(countries);
        List<String> expected = Arrays.asList("nl", "de");

        Assertions.assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
