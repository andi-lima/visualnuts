package com.visualnuts.exercise.two.model;

import java.util.List;
import java.util.Objects;

public class Country {

    private String contry;
    private List<String> languagues;

    public Country(String contry, List<String> languagues) {
        this.contry = contry;
        this.languagues = languagues;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public List<String> getLanguagues() {
        return languagues;
    }

    public void setLanguagues(List<String> languagues) {
        this.languagues = languagues;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(contry, country.contry) && Objects.equals(languagues, country.languagues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contry, languagues);
    }
}
