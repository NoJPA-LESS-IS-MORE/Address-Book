package hello.service;

import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;
import hello.model.User;

/**
 * Created by DK on 3/5/15.
 */
public interface UserService extends ModelObjectInterface {
    User create(String name, String lastName, String address);
}


