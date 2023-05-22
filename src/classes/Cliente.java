package classes;

import java.util.List;

import dao.ClienteDAO;

public class Cliente extends Pessoa {
private int idCliente;
private String endereco;
private String telefone;
private String cpf;
private static int _numero;


public Cliente(String nome, String endereco, String telefone, String cpf) {
	super(nome);
	this.endereco = endereco;
	this.telefone = telefone;
	this.cpf = cpf;
	Cliente._numero++;
}

public Cliente(int idCliente, String nome, String endereco, String telefone, String cpf) {
	super(nome);
	this.setIdCliente(idCliente);
	this.endereco = endereco;
	this.telefone = telefone;
	this.cpf = cpf;
	Cliente._numero++;
}

public static int getTotal() {
	return _numero;
}


@Override
public String toString() {
	return super.toString() + "Cliente [endereco=" + endereco + ", telefone=" + telefone + ", cpf=" + cpf + "]";
}


public String getEndereco() {
	return endereco;
}


public void setEndereco(String endereco) {
	this.endereco = endereco;
}


public String getTelefone() {
	return telefone;
}


public void setTelefone(String telefone) {
	this.telefone = telefone;
}


public String getCpf() {
	return cpf;
}


public void setCpf(String cpf) {
	this.cpf = cpf;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

public int insert() {
	return new ClienteDAO().insert(this);
}
public static List<Cliente> listAll(){
	return new ClienteDAO().listAll();
}
public int update(){
	return new ClienteDAO().update(this);
}
public int delete(){
	return new ClienteDAO().delete(this);
}
public static Cliente findByID(int id){
	return new ClienteDAO().findByID(id);
}

public static Cliente findByName(String name){
return new ClienteDAO().findByName(name);
}

public static Cliente findByCpf(String cpf){
return new ClienteDAO().findByCpf(cpf);
}

}
