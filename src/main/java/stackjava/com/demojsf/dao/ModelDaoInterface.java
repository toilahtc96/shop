package stackjava.com.demojsf.dao;

import java.util.List;

public interface ModelDaoInterface<E> {
	public E getById(int id);

	public List<E> getAll();

	public int removeById(int id);

	public int update(int id, E e);

	public int add(E e);

}
