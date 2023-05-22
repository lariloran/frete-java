package dao;

public enum ClienteSQLs {
	INSERT("insert into cliente(nome,endereco,telefone,cpf) values(?,?,?,?)"),
	UPDATE("update cliente set nome=?, endereco=?,telefone=?,cpf=? where idcliente=?"),
	DELETE("delete from cliente where idcliente=?"),
	LISTALL("select * from cliente"),
	FINDBYID("select * from cliente where idcliente=?"),
	FINDBYNAME("select * from cliente where nome=?"),
	FINDBYCPF("select * from cliente where cpf=?");
	
	private final String sql;
	
	ClienteSQLs(String sql){
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
