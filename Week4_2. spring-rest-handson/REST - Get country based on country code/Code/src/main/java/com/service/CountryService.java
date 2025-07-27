package com.cognizant.spring_learn.service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilderFactory;

import com.cognizant.spring_learn.model.Country;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;

import java.util.ArrayList;

@Service
public class CountryService {

    private List<Country> loadCountries() {
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("country.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            NodeList countryList = doc.getElementsByTagName("country");

            for (int i = 0; i < countryList.getLength(); i++) {
                Node node = countryList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Country country = new Country();
                    country.setCode(element.getElementsByTagName("code").item(0).getTextContent());
                    country.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    countries.add(country);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    public Country getCountry(String code) {
        List<Country> countries = loadCountries();

        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}