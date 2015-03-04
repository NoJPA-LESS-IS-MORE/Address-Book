package hello.controller;

import dk.lessismore.nojpa.db.methodquery.NList;
import hello.model.Address;
import hello.service.AddressService;
import hello.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    AddressService addressService;
    @Autowired
    PersonService personService;
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "form";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public ModelAndView results() {
        List<Address> reports = addressService.getAll();
        ModelAndView model = new ModelAndView("results");
        for (Address address : reports) {
            log.debug("My Addresses: " + address.getCity() + " " + address.getCountry() + " " + address.getZipCode() + " " + address.getStreetAndHouse());
        }
        model.addObject("reports", reports);
        return model;
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    ModelAndView createAddress(@RequestParam("streetAndHouse") String street_and_house,
                               @RequestParam("zipCode") String zip_code,
                               @RequestParam("city") String city,
                               @RequestParam("country") String country) {
        addressService.create(country, city, street_and_house, zip_code);
        return new ModelAndView("redirect:results");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    ModelAndView postSearch(@RequestParam("city") String city) {
        NList<Address> lists = addressService.search(city);
        ModelAndView model = new ModelAndView("search");
        log.debug("Size of Nlist: " + lists.size());
        for (Address address : lists) {
            log.debug("My NList: " + address.getCity() + " " + address.getCountry() + " " + address.getStreetAndHouse());
        }
        model.addObject("lists", lists);
        return model;
    }
}



