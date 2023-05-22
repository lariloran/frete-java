package view;

public enum OpcoesMenu {

	 CADASTRAR_CLIENTE(1, "1 - Cadastrar cliente em banco de dados"),
	 PESQUISAR_CLIENTE_NOME(2, "2 - Pesquisar Cliente usando o nome"),
	 REMOVER_CLIENTE_CPF(3, "3 - Excluir cliente usando CPF"),
	 LISTAR_CLIENTES(4, "4 - Listar todos os clientes"),
	 SAIR(5, "5 - Sair");

	
	  private final int id;
	  private final String descricao;

	  OpcoesMenu(final int id,
	              final String descricao) {
	    this.id = id;
	    this.descricao = descricao;
	  }

	  public int getIdentificador() {
	    return id;
	  }

	  public String getDescricao() {
	    return descricao;
	  }
}


