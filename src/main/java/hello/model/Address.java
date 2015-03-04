package hello.model;

import dk.lessismore.nojpa.reflection.db.annotations.IndexField;
import dk.lessismore.nojpa.reflection.db.annotations.SearchField;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;

/**
 * Created by DK on 11/3/14.
 */
public interface Address extends ModelObjectInterface {

    @SearchField
    @IndexField
    String getCountry();

    void setCountry(String country);

    @SearchField
    @IndexField
    String getCity();

    void setCity(String city);

    @SearchField
    @IndexField
    String getStreetAndHouse();

    void setStreetAndHouse(String streetAndHouse);

    @SearchField
    @IndexField
    String getZipCode();

    void setZipCode(String zipCode);
}
