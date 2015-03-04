package hello.service;

import hello.model.Person;

/**
 * Created by DK on 11/3/14.
 */
public interface PersonService extends GenericService<Person> {
    Person create(String name, String lastName);
}
