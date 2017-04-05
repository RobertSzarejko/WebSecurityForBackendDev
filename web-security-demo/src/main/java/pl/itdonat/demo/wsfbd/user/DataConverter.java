package pl.itdonat.demo.wsfbd.user;

/**
 * Created by Robert on 2017-03-11.
 */
public interface DataConverter<E, D> {

    D convertToData(E entity);
    void updateEntity(E entity, D data);

}
