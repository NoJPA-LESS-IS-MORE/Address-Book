package hello.service;


import dk.lessismore.nojpa.db.methodquery.NList;
import hello.model.Address;

/**
 * Created by DK on 11/3/14.
 */
public interface AddressService extends GenericService<Address> {
    Address create(String country, String city, String streetAndHouse, String zipCode);

    NList<Address> search(String word);
}
