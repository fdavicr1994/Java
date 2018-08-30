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
			
		String sql = "INSERT INTO usuario(login, senha, nome, telefone) values (? , ? , ? , ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		
		insert.setString(1, usuario.getLogin());
		insert.setString(2, usuario.getSenha());
		insert.setString(3, usuario.getNome());
		insert.setString(4, usuario.getTelefone());
		insert.execute();
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
	public List<Bean> listar() throws Exception{
		
		List<Bean> listar = new ArrayList<Bean>();
		
		String sql = "select * from usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			
			Bean bean = new Bean();
			bean.setId(resultSet.getLong("id"));
			bean.setLogin(resultSet.getString("login"));
			bean.setSenha(resultSet.getString("senha"));
			bean.setNome(resultSet.getString("nome"));
			bean.setTelefone(resultSet.getString("telefone"));
			
			listar.add(bean);
		}
		return listar;
	}
	
	public void delete(String id){
		
		try{
			String sql = "DELETE FROM usuario where id = '" + id + "'";
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

	public Bean consultar(String id) throws Exception{
		String sql = "select * from usuario where id = '"+ id +"'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			Bean bean = new Bean();
			bean.setId(resultSet.getLong("id"));
			bean.setLogin(resultSet.getString("login"));
			bean.setSenha(resultSet.getString("senha"));
			bean.setNome(resultSet.getString("nome"));
			bean.setTelefone(resultSet.getString("telefone"));
			
			return bean;
		}
		return null;
	}

	public boolean validarLogin(String login) throws Exception{
		String sql = "select count(1) as qtd from usuario where login = '"+ login +"'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			
			return resultSet.getInt("qtd") <= 0; /*Result true*/
		}
		return false;
	}
	
	
	public void atualizar(Bean usuario){
		
		try {
			String sql = "update usuario set login = ?, senha = ?, nome = ?, telefone = ? where id = " + usuario.getId();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getTelefone());
			preparedStatement.executeUpdate();
			connection.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
