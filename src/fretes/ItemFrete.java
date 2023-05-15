package fretes;

public final class ItemFrete implements Comparable<ItemFrete> {
    private String descricao;
    private double peso;
    private Frete frete;


    public ItemFrete(String descricao, double peso, Frete frete) {
		super();
		this.descricao = descricao;
		this.peso = peso;
		this.frete = frete;
	}

	public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return this.peso;
    }

    @Override
    public int compareTo(ItemFrete outro) {
        // Compare com base no peso
        return Double.compare(this.peso, outro.peso);
    }

	@Override
	public String toString() {
		return "ItemFrete [descricao=" + descricao + ", peso=" + peso + "]";
	}


}
