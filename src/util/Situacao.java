package util;

public enum Situacao {
	EM_ANDAMENTO(1, "EM ANDAMENTO"),
	CANCELADO(2, "CANCELADO"),
	ENCERRADO(3, "ENCERRADO");
	
	private int id;
	private String nome;
	
	private Situacao(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
}
