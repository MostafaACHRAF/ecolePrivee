package dao;

import java.util.List;

public interface IDao<T> {

	//Methods :
	T ajouter(T obj);
	T modifier(T obj);
	boolean supprimer(int id);
	T getById(int id);
	List<T> getAll();
	boolean existe(T obj);
}
