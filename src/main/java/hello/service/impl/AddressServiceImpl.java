package hello.service.impl;

import dk.lessismore.nojpa.db.methodquery.MQL;
import dk.lessismore.nojpa.db.methodquery.NList;
import dk.lessismore.nojpa.db.methodquery.NQL;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectSearchService;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectService;
import hello.model.Address;
import hello.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DK on 11/3/14.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Override
    public Address create(String country, String city, String streetAndHouse, String zipCode) {

        Address mAddress = ModelObjectService.create(Address.class);
        mAddress.setCountry(country);
        mAddress.setCity(city);
        mAddress.setStreetAndHouse(streetAndHouse);
        mAddress.setZipCode(zipCode);

        ModelObjectService.save(mAddress);
        ModelObjectSearchService.put(mAddress);

        return mAddress;
    }

    @Override
    public List<Address> getAll() {
        Address mAddress = MQL.mock(Address.class);
        return MQL.select(mAddress).orderBy(mAddress.getCreationDate(), MQL.Order.DESC).getList();
    }

    @Override
    public NList<Address> search(String searchText) {
        Address address = NQL.mock(Address.class);
        return NQL.search(address).search(NQL.has(address.getCity(), NQL.Comp.LIKE, searchText)).limit(Integer.MAX_VALUE).getList();
    }

}
