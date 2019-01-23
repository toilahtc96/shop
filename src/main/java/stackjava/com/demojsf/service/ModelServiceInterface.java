package stackjava.com.demojsf.service;

import java.util.List;

public interface ModelServiceInterface<E> {
	public E getById(int id);

	public List<E> getAll();

	public int add(E e);

	public int update(int id, E e);

	public int removeById(int id);
}
