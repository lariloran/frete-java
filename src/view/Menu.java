package view;

import java.util.*;

import javax.swing.JOptionPane;

import classes.Cliente;

public class Menu {

	public static void main(String[] args) {
		while (true) {
			switch (montaMenu()) {
			case 1:// Cadastrar Cliente
				cadastraCliente();
				break;
				
			case 2:// Pesquisar cliente usando nome
			    pesquisarClientePorNome();
			    break;
			    
			case 3:// Excluir Cliente usando CPF
				ExcluirClientePorCpf();
				break;
				
			case 4:// Listar Clientes
				listarClientes();
			    break;
				
			case 5://sair
				System.exit(0);
				break;
			}
		}
	}

	public static void cadastraCliente() {
		
		try {
		String nomeCliente = JOptionPane.showInputDialog("Informe o nome do Cliente:");
		String telefone = JOptionPane.showInputDialog("Informe o telefone do Cliente:");
		String endereco = JOptionPane.showInputDialog("Informe o endereco do Cliente:");
		String cpfCliente = JOptionPane.showInputDialog("Informe o cpf do Cliente:");
		Cliente cliente = new Cliente(nomeCliente, endereco,telefone, cpfCliente);
		if(cliente.insert() == -1)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
		else
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		}
		 catch (NullPointerException e) {
	        JOptionPane.showMessageDialog(null, "Erro: Algum campo está vazio. Certifique-se de preencher todos os campos corretamente.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao cadastrar o cliente. Por favor, tente novamente.");
	    }
			
	}
	
	
	public static void pesquisarClientePorNome() {
		try {
	    String nomeClientePesquisa = JOptionPane.showInputDialog("Informe o nome do cliente para pesquisar o frete:");
	    Cliente cliente = Cliente.findByName(nomeClientePesquisa);
	    
	    if (cliente != null) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Cliente encontrado ").append(nomeClientePesquisa).append(":\n");
	            mensagem.append("Nome: ").append(cliente.getNome()).append("\n");
	            mensagem.append("Endereço: ").append(cliente.getEndereco()).append("\n");
	            mensagem.append("Telefone: ").append(cliente.getTelefone()).append("\n");
	            mensagem.append("CPF: ").append(cliente.getCpf()).append("\n");
	            mensagem.append("-----\n");
	        JOptionPane.showMessageDialog(null, mensagem.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado para o nome " + nomeClientePesquisa);
	    	}
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao pesquisar o cliente por nome. Por favor, tente novamente.");
	    }
	}
	
	public static void ExcluirClientePorCpf() {
		try {
	    String cpfClientePesquisa = JOptionPane.showInputDialog("Informe o CPF do cliente que deseja excluir:");
	    Cliente cliente = Cliente.findByCpf(cpfClientePesquisa);
	    
	    if (cliente != null) {
	    	if(cliente.delete() == -1)
				JOptionPane.showMessageDialog(null, "Erro ao remover cliente!");
			else
				JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");	    	
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado para o cpf " + cpfClientePesquisa);
	    	}
		}
		catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Erro: Ocorreu um erro ao remover o cliente por cpf. Por favor, tente novamente.");
	    }
	}
	
	public static void listarClientes() {
		List<Cliente> listaClientes = Cliente.listAll();
		try {
	    if (!listaClientes.isEmpty()) {
	        StringBuilder mensagem = new StringBuilder();
	        mensagem.append("Lista de todos os Clientes:\n");
	        mensagem.append("Total de clientes: ").append(Cliente.getTotal()).append("\n");
	        for (Cliente cliente : listaClientes) {
	        	mensagem.append("ID: ").append(cliente.getIdCliente()).append("\n");
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
