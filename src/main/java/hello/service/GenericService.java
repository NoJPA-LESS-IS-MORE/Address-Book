package hello.service;


import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aurimas on 04/04/14.
 */
@Service
public interface GenericService<T extends ModelObjectInterface> {

    T get(String id);

    List<T> getAll();

}
