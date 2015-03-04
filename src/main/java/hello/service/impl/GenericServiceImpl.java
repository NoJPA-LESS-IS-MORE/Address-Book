package hello.service.impl;

/**
 * Created by DK on 11/4/14.
 */

import dk.lessismore.nojpa.db.methodquery.MQL;
import dk.lessismore.nojpa.db.methodquery.NQL;
import dk.lessismore.nojpa.reflection.db.model.ModelObjectInterface;
import hello.service.GenericService;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Aurimas on 04/04/14.
 */
public abstract class GenericServiceImpl<T extends ModelObjectInterface> implements GenericService<T> {

    protected Class<T> modelObjectClass;

    @SuppressWarnings("unchecked")
    protected GenericServiceImpl() {
        this.modelObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected GenericServiceImpl(Class<T> modelObjectClass) {
        this.modelObjectClass = modelObjectClass;
    }

    @Override
    public List<T> getAll() {
        T modelObject = MQL.mock(this.modelObjectClass);
        return MQL.select(modelObject).orderBy(modelObject.getCreationDate(), MQL.Order.DESC).getList();
    }

    @Override
    public T get(String id) {
        if (id == null) {
            return null;
        }
        return MQL.selectByID(this.modelObjectClass, id);
    }

    protected MQL.SelectQuery<T> page(MQL.SelectQuery<T> query, Pageable p) {
        return query.limit(p.getPageNumber() * p.getPageSize(), (p.getPageNumber() + 1) * p.getPageSize());
    }

    protected NQL.SearchQuery<T> page(NQL.SearchQuery<T> query, Pageable p) {
        return query.limit(p.getPageNumber() * p.getPageSize(), (p.getPageNumber() + 1) * p.getPageSize());
    }

}
