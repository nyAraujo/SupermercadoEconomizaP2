package SupermercadoEconomizaP2;
/*
 * 115111596 - Thais Nicoly Araujo Toscano: LAB 3 - Turma 01
 * Classe Produto: Define os atributos e construtor de Produto
 */

public class Produto {
	
	private String nome;
	private double preco;
	private String tipo;
	private int quantNoEstoque;
	
	public Produto(String nome, double preco, String tipo, int quantNoEstoque){
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantNoEstoque = quantNoEstoque;
	}
	
	public String getNome(){
		return nome;	
	}
	
	public double getPreco(){
		return preco;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public int getQuant(){
		return quantNoEstoque;
	}
	
	@Override 
	public String toString(){
		return "nome " + getNome() + ", (tipo)." + getTipo() + ", R$preco" + getPreco();
	
	}
	
}
