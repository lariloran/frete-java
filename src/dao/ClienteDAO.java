package dao;

import java.sql.*;
import java.util.*;

import classes.Cliente;

public class ClienteDAO implements GenericDAO<Cliente> {

	@Override
	public int insert(Cliente c) {
		int chavePrimaria = -1;
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.INSERT.getSql(),
								Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getTelefone());
			stmt.setString(4, c.getCpf());

			stmt.execute();
			ResultSet chaves = stmt.getGeneratedKeys();
			if (chaves.next())  chavePrimaria= chaves.getInt(1);
		}catch(SQLException e){
			System.out.println("Excessao no codigo - Cliente insert");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Classe nao encontrada - Cliente insert!");
		}
		return chavePrimaria;
	}

	@Override
	public int update(Cliente c){
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.UPDATE.getSql())){
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getTelefone());
			stmt.setString(4, c.getCpf());
			stmt.setInt(5, c.getIdCliente());
			
			if(stmt.execute()) return 1;
		}catch(SQLException e){ System.out.println("Excessao SQL - update Cliente");
		}catch(Exception e){  System.out.println("Excessao SQL - update Cliente");
		}
		return -1;
	}

	@Override
	public int delete(Cliente obj){
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.DELETE.getSql())){
			stmt.setInt(1, obj.getIdCliente());
			if(stmt.execute()) return 1;
		}catch(SQLException e){ e.printStackTrace(); System.out.println("Excessao SQL - delete Cliente");
		}catch(Exception e){  System.out.println("Excessao SQL - delete Cliente");
		}
		return -1;
	}

	@Override
	public List<Cliente> listAll() {
		List<Cliente> lista = new LinkedList<>();

		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.LISTALL.getSql())){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idcliente = rs.getInt("idcliente");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
		
				lista.add(new Cliente(idcliente, nome, endereco, telefone,cpf));
			}
			return lista;
		}catch(SQLException e){ System.out.println("Excessao SQL - listAll Cliente");
		}catch(Exception e){  System.out.println("Excessao no codigo - listAll Cliente!");
		}
		return null;
	}

	@Override
	public Cliente findByID(int id){
		Cliente c = null;
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.FINDBYID.getSql())){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idcliente = rs.getInt("idcliente");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				c = new Cliente(idcliente, nome, endereco, telefone,cpf);
			}
		}catch(SQLException e){ System.out.println("Excessao SQL - findById Cliente");
		}catch(Exception e){  System.out.println("Excessao SQL - findById Cliente");
		}
		return c;        
	}

	@Override
	public Cliente findByName(String input) {
		Cliente c = null;
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.FINDBYNAME.getSql())){
			stmt.setString(1,input);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idcliente = rs.getInt("idcliente");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				c = new Cliente(idcliente, nome, endereco, telefone,cpf);
			}
		}catch(SQLException e){ System.out.println("Excessao SQL - findByName Cliente");
		}catch(Exception e){  System.out.println("Excessao SQL - findByName Cliente");
		}
		return c;        
	}

	@Override
	public Cliente findByCpf(String input) {
		Cliente c = null;
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ClienteSQLs.FINDBYCPF.getSql())){
			stmt.setString(1,input);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idcliente = rs.getInt("idcliente");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				c = new Cliente(idcliente, nome, endereco, telefone,cpf);
			}
		}catch(SQLException e){ System.out.println("Excessao SQL - findByCpf Cliente");
		}catch(Exception e){  System.out.println("Excessao SQL - findByCpf Cliente");
		}
		return c;   
	}

}
