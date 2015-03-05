package hello.service;


import dk.lessismore.nojpa.db.methodquery.NList;
import hello.model.Address;

import java.util.List;

/**
 * Created by DK on 11/3/14.
 */
public interface AddressService {

    Address create(String country, String city, String streetAndHouse, String zipCode);

    List<Address> getAll();

    NList<Address> search(String word);
}
