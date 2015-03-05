package hello.service.impl;

import dk.lessismore.nojpa.reflection.db.model.ModelObjectService;
import hello.model.Person;
import hello.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * Created by DK on 11/3/14.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person create(String name, String lastName) {

        Person person = ModelObjectService.create(Person.class);
        person.setName(name);
        person.setLastName(lastName);

        ModelObjectService.save(person);

        return person;
    }


}
