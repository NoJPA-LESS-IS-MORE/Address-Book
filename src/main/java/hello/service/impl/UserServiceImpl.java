package hello.service.impl;

import dk.lessismore.nojpa.reflection.db.model.ModelObjectSearchService;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectService;
import hello.model.Address;
import hello.model.User;

/**
 * Created by DK on 3/5/15.
 */
public class UserServiceImpl {

    public User create(String name, String lastName, String address) {

        User user = ModelObjectService.create(User.class);
        user.setName(name);
        user.setLastName(lastName);
        user.setAddress(address);

        ModelObjectService.save(user);
        ModelObjectSearchService.put(user);

        return user;
    }

}
