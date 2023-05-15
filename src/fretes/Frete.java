package fretes;

import java.util.TreeSet;
import pessoas.Cliente;
import util.Situacao;
import util.Validador;

public class Frete implements Validador, Comparable<Frete> {
    private double valor;
    private String cidadeOrigem;
    private String cidadeDestino;
    private double pesoTotal;
    private TreeSet<ItemFrete> itens;
    private Cliente cliente;
    private Situacao situacao;

    public Frete(double valor, String cidadeOrigem, String cidadeDestino, Cliente cliente) {
        super();
        itens = new TreeSet<>();
        pesoTotal = 0;
        this.valor = valor;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.cliente = cliente;
        this.situacao = Situacao.EM_ANDAMENTO;
    }

    @Override
    public boolean validaPeso(double peso) {
        if (peso >= 1 && peso <= 100) {
        	this.pesoTotal += peso;
            return true;
        }
        return false;
    }

    public int adicionarItem(ItemFrete item) {
       if(validaPeso(item.getPeso())) {
    	   itens.add(item);
    	   return 1;
       }
       return 0;
              
    }

    @Override
    public int compareTo(Frete outroFrete) {
        // Comparar os valores dos fretes para determinar a ordem
        if (this.valor < outroFrete.valor) {
            return -1;
        } else if (this.valor > outroFrete.valor) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String itensFreteString = "";
        for (ItemFrete item : itens) {
            itensFreteString += item.toString() + "\n";
        }

        return "Frete [valor=" + valor + ", cidadeOrigem=" + cidadeOrigem + ", cidadeDestino=" + cidadeDestino
                + ", pesoTotal=" + pesoTotal + ", itens=\n" + itensFreteString + ", cliente=" + cliente + ", situacao=" + situacao
                + "]";
    }

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public TreeSet<ItemFrete> getItens() {
		return itens;
	}

	public void setItens(TreeSet<ItemFrete> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

    
}
