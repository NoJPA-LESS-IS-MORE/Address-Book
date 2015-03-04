package hello.model;

import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;

import javax.validation.constraints.Size;

/**
 * Created by DK on 11/3/14.
 */
public interface Person extends ModelObjectInterface {
    @Size(min = 2, max = 30)
    String getName();

    void setName(String name);

    @Size(min = 2, max = 30)
    String getLastName();

    void setLastName(String lastName);
}
