package hello.service.impl;

import dk.lessismore.nojpa.db.methodquery.NList;
import dk.lessismore.nojpa.db.methodquery.NQL;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectSearchService;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectService;
import hello.model.Address;
import hello.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * Created by DK on 11/3/14.
 */
@Service
public class AddressServiceImpl extends GenericServiceImpl<Address> implements AddressService {

    protected AddressServiceImpl() {
        super(Address.class);
    }

    @Override
    public Address create(String country, String city, String streetAndHouse, String zipCode) {

        Address address = ModelObjectService.create(Address.class);
        address.setCountry(country);
        address.setCity(city);
        address.setStreetAndHouse(streetAndHouse);
        address.setZipCode(zipCode);

        ModelObjectService.save(address);
        ModelObjectSearchService.put(address);

        return address;

    }

//    @Override
//    public NList<Address> search(String word) {
//        Address mUser = NQL.mock(Address.class);
//        List<NQL.Constraint> constraints = new ArrayList<>();
//        constraints.add(NQL.has(mUser.getCity(), NQL.Comp.LIKE, word));
//        constraints.add(NQL.has(mUser.getCountry(), NQL.Comp.LIKE, word));
//        constraints.add(NQL.has(mUser.getZipCode(), NQL.Comp.LIKE, word));
//        constraints.add(NQL.has(mUser.getStreetAndHouse(), NQL.Comp.LIKE, word));
//        NQL.SearchQuery<Address> q = NQL.search(mUser);
//        NList<Address> addresses = q.search(NQL.all(NQL.any(constraints))).orderBy(mUser.getCountry(), NQL.Order.ASC).getList();
//        return addresses;
//    }
    @Override
    public NList<Address> search(String searchText) {
        Address address = NQL.mock(Address.class);

        return NQL.search(address).search(
                NQL.all(
                        NQL.any(
                                NQL.has(address.getCity(), NQL.Comp.LIKE, searchText)
                        )
                ))
                .limit((0) * 10, 1 * 10).getList();
    }
}
