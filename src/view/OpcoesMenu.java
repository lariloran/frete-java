package view;

public enum OpcoesMenu {

	 CADASTRAR_FRETE(1, "1 - Cadastrar Frete"),
	 PESQUISAR_FRETE_NOME_CLIENTE(2, "2 - Pesquisar Frete usando o nome do cliente"),
	 PESQUISAR_FRETE_CPF_CLIENTE(3, "3 - Pesquisar Frete usando CPF do CLiente"),
	 PESQUISAR_FRETE_CIDADE_ORIGEM_DESTINO(4, "4 - Pesquisar Frete usando cidade de origem e destino"),
	 LISTAR_FRETES(5, "5 - Listar todos os Fretes"),
	 LISTAR_CLIENTES(6, "6 - Listar todos os Clientes cadastrados"),
	 SAIR(7, "7 - Sair");

	
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


