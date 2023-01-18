package com.visualnuts.exercise.two.service;

import com.visualnuts.exercise.two.model.Country;

import java.util.*;
import java.util.stream.Collectors;


public class CountryService {

    public Integer getNumberOfCountries(List<Country> countries){
        return countries.size();
    }

    public List<Country> findCountriesByOfficialLanguage(String language, List<Country> countries){

        List<Country> countryList = countries.stream()
                .filter(c -> c.getLanguagues().contains(language))
                .collect(Collectors.toList());

        return countryList;
    }

    public Integer countAllOfficialLanguages(List<Country> countries){
        Integer count = 0;

        for(Country c : countries){
            count = count + c.getLanguagues().size();
        }

        return count;
    }

    public Country highestNumberOfOfficialLanguage(List<Country> countries){

        Country country = countries.stream()
                .max(Comparator.comparingInt(language -> language.getLanguagues().size())).get();

        return country;
    }

    public List<String> mostCommonOfficialLanguage(List<Country> countries){

        Set<String> languages = new HashSet<>();
        for(Country c : countries){
            languages.addAll(c.getLanguagues());
        }

        Map<String, List<Country>> mapLanguagesToCountries = new HashMap<>();
        for(String language: languages){
            mapLanguagesToCountries.put(language, findCountriesByOfficialLanguage(language, countries));
        }

        List<String> mostCommonLanguages = new ArrayList<>();
        int count = 0;
        for(Map.Entry<String, List<Country>> entry : mapLanguagesToCountries.entrySet()){
            if(entry.getValue().size() >= count){
                count = entry.getValue().size();
                mostCommonLanguages.add(entry.getKey());
            }
        }

        return mostCommonLanguages;
    }
}
