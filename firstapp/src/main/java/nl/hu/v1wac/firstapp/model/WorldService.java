package nl.hu.v1wac.firstapp.model;

import nl.hu.v1wac.firstapp.persistence.CountryDAO;

import java.util.List;

public class WorldService {
    private CountryDAO CountryDAO = new CountryDAO();

    public List<Country> getAllCountries() {
        return CountryDAO.findAll();
    }

    public List<Country> get10LargestPopulations() { return CountryDAO.find10LargestPopulations(); }

    public List<Country> get10LargestSurfaces() { return CountryDAO.find10LargestSurfaces(); }

    public Country getCountryByCode(String code) { return CountryDAO.findByCode(code); }

    public boolean delete(Country country) { return CountryDAO.delete(country); }

    public void addCountry(Country country) { CountryDAO.save(country);}

    public void updateCountry(Country country) { CountryDAO.update(country);}
}
