package mk.iwec.payments.mapper;

public interface GeneralMapper<E, D> {

    public D entityToDto(E entity);

    public E dtoToEntity(D dto);

}
