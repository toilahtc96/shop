package stackjava.com.demojsf.service;

import java.util.List;

public interface ModelServiceInterface<E> {
	public E getById(int id);

	public List<E> getAll();

	public int add(E e);

	public int update();

	public int removeById();
}
