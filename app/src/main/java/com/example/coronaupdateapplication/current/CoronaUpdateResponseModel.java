
package com.example.coronaupdateapplication.current;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CoronaUpdateResponseModel {

    @SerializedName("updated")
    @Expose
    private long updated;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryInfo")
    @Expose
    private CountryInfo countryInfo;
    @SerializedName("cases")
    @Expose
    private long cases;
    @SerializedName("todayCases")
    @Expose
    private long todayCases;
    @SerializedName("deaths")
    @Expose
    private long deaths;
    @SerializedName("todayDeaths")
    @Expose
    private long todayDeaths;
    @SerializedName("recovered")
    @Expose
    private long recovered;
    @SerializedName("todayRecovered")
    @Expose
    private long todayRecovered;
    @SerializedName("active")
    @Expose
    private long active;
    @SerializedName("critical")
    @Expose
    private long critical;
    @SerializedName("casesPerOneMillion")
    @Expose
    private long casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    @Expose
    private long deathsPerOneMillion;
    @SerializedName("tests")
    @Expose
    private long tests;
    @SerializedName("testsPerOneMillion")
    @Expose
    private long testsPerOneMillion;
    @SerializedName("population")
    @Expose
    private long population;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("oneCasePerPeople")
    @Expose
    private long oneCasePerPeople;
    @SerializedName("oneDeathPerPeople")
    @Expose
    private long oneDeathPerPeople;
    @SerializedName("oneTestPerPeople")
    @Expose
    private long oneTestPerPeople;
    @SerializedName("activePerOneMillion")
    @Expose
    private double activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    @Expose
    private double recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    @Expose
    private double criticalPerOneMillion;

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(long todayCases) {
        this.todayCases = todayCases;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getTests() {
        return tests;
    }

    public void setTests(long tests) {
        this.tests = tests;
    }

    public long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(long oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public long getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(long oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public long getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(long oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(double activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(double recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(double criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

}
