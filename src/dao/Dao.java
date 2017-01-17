package dao;

import connexion.Connexion;

import java.sql.Connection;

public abstract class Dao<T> implements IDao<T> {
	protected Connection connection = Connexion.getInstance().getConnection();
}
