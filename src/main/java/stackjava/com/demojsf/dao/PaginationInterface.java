package stackjava.com.demojsf.dao;

import java.util.List;

public interface PaginationInterface<E> {
	public long countTotalRecords();
	  
	  public List<E> getUsingSession(int position, int pageSize);
}
