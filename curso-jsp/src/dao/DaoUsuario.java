package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Bean;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;
	
	public DaoUsuario(){
		connection = SingleConnection.getConnection();
	}
	
	public void Salvar(Bean usuario){
		
		try{
			
		String sql = "INSERT INTO usuario(login, senha) values (? , ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		
		insert.setString(1, usuario.getLogin());
		insert.setString(2, usuario.getSenha());
		insert.execute();
		connection.commit();
		
		}catch(Exception e){
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public List<Bean> listar() throws Exception{
		
		List<Bean> listar = new ArrayList<Bean>();
		
		String sql = "select * from usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			
			Bean bean = new Bean();
			bean.setLogin(resultSet.getString("login"));
			bean.setSenha(resultSet.getString("senha"));
			
			listar.add(bean);
		}
		return listar;
	}
	
	public void delete(String login){
		
		try{
			String sql = "DELETE FROM usuario where login = '" + login + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		
			connection.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
