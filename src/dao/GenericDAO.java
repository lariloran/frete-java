package dao;

public interface GenericDAO<T> {
	
	public int insert(T obj);
	public int update(T obj);
	public int delete(T obj);
	public java.util.List<T> listAll();
	public T findByID(int id);
	public T findByName(String input);
	public T findByCpf(String input);

}
