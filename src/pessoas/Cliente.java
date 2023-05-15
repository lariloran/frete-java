package pessoas;

public class Cliente extends Pessoa {
private String endereco;
private String telefone;
private String cpf;
private static int _numero;


public Cliente(String nome, String endereco, String telefone, String cpf) {
	super(nome);
	this.endereco = endereco;
	this.telefone = telefone;
	this.cpf = cpf;
	this._numero++;
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


}
