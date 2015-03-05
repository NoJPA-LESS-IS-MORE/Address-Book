package hello.model;

import dk.lessismore.nojpa.reflection.db.annotations.SearchField;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;

/**
 * Created by DK on 3/5/15.
 */
public interface User extends ModelObjectInterface {

    @SearchField
    String getName();
    void setName(String name);

    @SearchField
    String getLastName();
    void setLastName(String lastName);

    @SearchField
    String getAddress();
    void setAddress(String address);

}
