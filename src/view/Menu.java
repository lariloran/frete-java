package view;

import java.util.*;
import pessoas.*;
import fretes.*;

import util.Situacao;

import javax.swing.JOptionPane;

public class Menu {
	static TreeSet<Frete> fretes = new TreeSet<>();
	
	public static void main(String[] args) {
		while (true) {
			switch (montaMenu()) {
			case 1:// Cadastrar Frete
				cadastraFrete();
				break;
				
			case 2:// Pesquisar Frete usando o nome do cliente
			    pesquisarFreteClientePorNome();
			    break;
			    
			case 3:// Pesquisar Frete usando CPF do Cliente
				pesquisarFreteClientePorCpf();
				break;
				
			case 4:// Pesquisar Frete usando cidade de origem e destino
				pesquisarFreteClientePorCidadeOrigemDestino();
			    break;

			case 5:// Listar todos os Fretes
				listarFretes();
			    break;

			case 6:// Listar todos os clientes
				listarClientes();
				break;
				
			case 7://sair
				System.exit(0);
				break;
			}
		}
	}

	public static void cadastraFrete() {
		
		try {
		String nomeCliente = JOptionPane.showInputDialog("Informe o nome do Cliente:");
		String telefone = JOptionPane.showInputDialog("Informe o telefone do Cliente:");
		String endereco = JOptionPane.showInputDialog("Informe o endereco do Cliente:");
		String cpfCliente = JOptionPane.showInputDialog("Informe o cpf do Cliente:");
		Cliente cliente = new Cliente(nomeCliente, endereco,telefone, cpfCliente);

		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		
		double valorFrete = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do frete:"));
		String cidadeOrigem = JOptionPane.showInputDialog("Informe a cidade de Origem:");
		String cidadeDestino = JOptionPane.showInputDialog("Informe a cidade de Destino:");
		Frete frete = new Frete(valorFrete, cidadeOrigem, cidadeDestino, cliente);
		
		fretes.add(frete);
		cadastraItens(frete);
		
		} catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Erro: Valor do frete inválido. Certifique-se de inserir um número válido.");
	    } catch (NullPointerException e) {
	        JOptionPane.showMessageDialog(null, "Erro: Algum campo está vazio. Certifique-se de preencher todos os campos corretamente.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao cadastrar o frete. Por favor, tente novamente.");
	    }
			
	}
	
	public static void cadastraItens(Frete frete) {
		try {
		String descricaoItemFrete = JOptionPane.showInputDialog("Informe a descrição do item:");
		double pesoItemFrete = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do item:"));
		ItemFrete itemFrete = new ItemFrete(descricaoItemFrete,pesoItemFrete, frete);
		int retorno = frete.adicionarItem(itemFrete);
		if(retorno == 1) {
			JOptionPane.showMessageDialog(null, "ItemFrete cadastrado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Item não cadastrado.\nPeso deve estar entre 1 e 100(inclusive)!");
		}
		
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Erro: Peso do item inválido. Certifique-se de inserir um número válido.");
	    } catch (NullPointerException e) {
	        JOptionPane.showMessageDialog(null, "Erro: Algum campo está vazio. Certifique-se de preencher todos os campos corretamente.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao cadastrar o item do frete. Por favor, tente novamente.");
	    	}
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais itens? 1 - SIM, 2 - NÃO\nOpção: "));
		if(opcao == 1) {
			cadastraItens(frete);
		} else {
			montaMenu();
		}
	}
	
	
	public static void pesquisarFreteClientePorNome() {
		try {
	    String nomeClientePesquisa = JOptionPane.showInputDialog("Informe o nome do cliente para pesquisar o frete:");
	    List<Frete> fretesCliente = new ArrayList<>();
	    
	    for (Frete frete : fretes) {
	        if (frete.getCliente().getNome().equalsIgnoreCase(nomeClientePesquisa)) {
	            fretesCliente.add(frete);
	        }
	    }
	    
	    if (!fretesCliente.isEmpty()) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Fretes encontrados para o cliente ").append(nomeClientePesquisa).append(":\n");
	        for (Frete frete : fretesCliente) {
	            mensagem.append("Valor do Frete: ").append(frete.getValor()).append("\n");
	            mensagem.append("Cidade de Origem: ").append(frete.getCidadeOrigem()).append("\n");
	            mensagem.append("Cidade de Destino: ").append(frete.getCidadeDestino()).append("\n");
	            mensagem.append("Itens do Frete:\n");
	            for (ItemFrete itemFrete : frete.getItens()) {
	                mensagem.append("Descrição: ").append(itemFrete.getDescricao()).append("\n");
	                mensagem.append("Peso: ").append(itemFrete.getPeso()).append("\n");
	                mensagem.append("-----\n");
	            }
	            mensagem.append("-----\n");
	        }
	        JOptionPane.showMessageDialog(null, mensagem.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum frete encontrado para o cliente " + nomeClientePesquisa);
	    	}
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao pesquisar o frete por nome. Por favor, tente novamente.");
	    }
	}
	
	
	public static void pesquisarFreteClientePorCpf() {
		try {
		String cpfClientePesquisa = JOptionPane.showInputDialog("Informe o CPF do cliente para pesquisar o frete:");
	    List<Frete> fretesCliente = new ArrayList<>();
	    
	    for (Frete frete : fretes) {
	        if (frete.getCliente().getCpf().equals(cpfClientePesquisa)) {
	            fretesCliente.add(frete);
	        }
	    }
	    
	    if (!fretesCliente.isEmpty()) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Fretes encontrados para o cliente com CPF ").append(cpfClientePesquisa).append(":\n");
	        for (Frete frete : fretesCliente) {
	            mensagem.append("Valor do Frete: ").append(frete.getValor()).append("\n");
	            mensagem.append("Cidade de Origem: ").append(frete.getCidadeOrigem()).append("\n");
	            mensagem.append("Cidade de Destino: ").append(frete.getCidadeDestino()).append("\n");
	            mensagem.append("Itens do Frete:\n");
	            for (ItemFrete itemFrete : frete.getItens()) {
	                mensagem.append("Descrição: ").append(itemFrete.getDescricao()).append("\n");
	                mensagem.append("Peso: ").append(itemFrete.getPeso()).append("\n");
	                mensagem.append("-----\n");
	            }
	            mensagem.append("-----\n");
	        }
	        JOptionPane.showMessageDialog(null, mensagem.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum frete encontrado para o cliente com CPF " + cpfClientePesquisa);
	    }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao pesquisar o frete por CPF. Por favor, tente novamente.");
	    }
	}
	
	public static void pesquisarFreteClientePorCidadeOrigemDestino() {
	    try {
		String cidadeOrigemPesquisa = JOptionPane.showInputDialog("Informe a cidade de origem para pesquisar o frete:");
	    String cidadeDestinoPesquisa = JOptionPane.showInputDialog("Informe a cidade de destino para pesquisar o frete:");
	    List<Frete> fretesEncontrados = new ArrayList<>();
	    
	    for (Frete frete : fretes) {
	        if (frete.getCidadeOrigem().equalsIgnoreCase(cidadeOrigemPesquisa) &&
	            frete.getCidadeDestino().equalsIgnoreCase(cidadeDestinoPesquisa)) {
	            fretesEncontrados.add(frete);
	        }
	    }
	    
	    if (!fretesEncontrados.isEmpty()) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Fretes encontrados para a rota: ").append(cidadeOrigemPesquisa).append(" - ").append(cidadeDestinoPesquisa).append(":\n");
	        for (Frete frete : fretesEncontrados) {
	            mensagem.append("Valor do Frete: ").append(frete.getValor()).append("\n");
	            mensagem.append("Cliente: ").append(frete.getCliente().getNome()).append("\n");
	            mensagem.append("CPF do Cliente: ").append(frete.getCliente().getCpf()).append("\n");
	            mensagem.append("Itens do Frete:\n");
	            for (ItemFrete itemFrete : frete.getItens()) {
	                mensagem.append("Descrição: ").append(itemFrete.getDescricao()).append("\n");
	                mensagem.append("Peso: ").append(itemFrete.getPeso()).append("\n");
	                mensagem.append("-----\n");
	            }
	            mensagem.append("-----\n");
	        }
	        JOptionPane.showMessageDialog(null, mensagem.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum frete encontrado para a rota: " + cidadeOrigemPesquisa + " - " + cidadeDestinoPesquisa);
	    }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao pesquisar o frete por cidade de origem e destino. Por favor, tente novamente.");
	    }
	}
	
	public static void listarFretes() {
		try {
	    if (!fretes.isEmpty()) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Lista de todos os Fretes:\n");
	        for (Frete frete : fretes) {
	            mensagem.append("Valor do Frete: ").append(frete.getValor()).append("\n");
	            mensagem.append("Cliente: ").append(frete.getCliente().getNome()).append("\n");
	            mensagem.append("CPF do Cliente: ").append(frete.getCliente().getCpf()).append("\n");
	            mensagem.append("Peso Total: ").append(frete.getPesoTotal()).append("\n");
	            mensagem.append("Itens do Frete:\n");
	            for (ItemFrete itemFrete : frete.getItens()) {
	                mensagem.append("Descrição: ").append(itemFrete.getDescricao()).append("\n");
	                mensagem.append("Peso: ").append(itemFrete.getPeso()).append("\n");
	                mensagem.append("-----\n");
	            }
	            mensagem.append("-----\n");
	        }
	        JOptionPane.showMessageDialog(null, mensagem.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum frete cadastrado.");
	    }
		 } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao listar os fretes. Por favor, tente novamente.");
		    }
	}
	
	public static void listarClientes() {
		try {
	    if (!fretes.isEmpty()) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Lista de todos os Clientes:\n");
	        mensagem.append("Total de clientes: ").append(Cliente.getTotal()).append("\n");
	        for (Frete frete : fretes) {
	            Cliente cliente = frete.getCliente();
	            mensagem.append("Nome: ").append(cliente.getNome()).append("\n");
	            mensagem.append("CPF: ").append(cliente.getCpf()).append("\n");
	            mensagem.append("Telefone: ").append(cliente.getTelefone()).append("\n");
	            mensagem.append("Endereço: ").append(cliente.getEndereco()).append("\n");
	            mensagem.append("-----\n");
	        }
	        JOptionPane.showMessageDialog(null, mensagem.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
	    }
		} catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao listar os clientes. Por favor, tente novamente.");
	    }
	}
	
	public static int montaMenu() {
		try {
		String menu = "";
		menu += ("Escolha uma das seguintes opcoes:\n");
		for (OpcoesMenu value : OpcoesMenu.values()) {
			menu += value.getDescricao() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		} catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Erro: Opção inválida. Certifique-se de inserir um número válido.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao montar o menu. Por favor, tente novamente.");
	    }
	    return 0;
	}
		
}
