package SupermercadoEconomizaP2;
/*
 * 115111596 - Thais Nicoly Araujo Toscano: LAB 3 - Turma 01
 * Classe Supermercado
 * Define o cadastro de Produto
 * Venda do Produto
 * Faz a impressao da venda dos produtos
 */

import java.util.Scanner;
 
public class Supermercado {
    public static  Scanner sc = new Scanner(System.in);
    private static Produto produto;
    private static Estoque estoque = new Estoque();
    static double totalArrecadado = 0.0; 
    static int quantidadeDeProdutos = 0;
    static int quantNoEstoque = 0;
    static int restanteProdutos = 0;
    private int cont = 0;
     
    public void cadastro(){
         
        String opcao;
        
        System.out.println("= = = = Cadastro de Produtos = = = =");
         
        do {
            String nome;
            double preco;
            String tipo;
            int quant;
                
            // Cadastrando o nome do Produto
            System.out.print("Digite o nome do produto: ");
            nome = sc.nextLine();
            
            // Cadastrando o preco do Produto
            System.out.print("Digite o preço unitário do produto: ");
            preco = sc.nextDouble();
            sc.nextLine();
            
            // Cadastrando o tipo do Produto
            System.out.print("Digite o tipo do produto: ");
            tipo = sc.nextLine();
            
            // quantidade do produto no estoque
            System.out.print("Digite a quantidade no estoque: ");
            quant = sc.nextInt();
            sc.nextLine();
			produto = new Produto(nome, preco, tipo, quant);
            estoque.armazenarProdutos(produto);
            cont = cont + 1;
 
            System.out.println(""+ quant + " " +'"'+ nome +'"'  + " cadastado(s) com sucesso.");
            quantNoEstoque = quant;
            System.out.println(" ");
            // mensagem e laco: cadastro de um novo produto
            System.out.print("Deseja cadastrar outro produto? ");
            opcao = sc.nextLine();  
            System.out.println(" ");
        }while(opcao.equalsIgnoreCase("sim"));     
    }
    
    public void vendaDeProdutos(){
        String opcao;
        String nome;
        
        System.out.print("= = = = Venda de Produtos = = = = \nDigite o nome do produto: ");
        nome = sc.nextLine();
         
        if (estoque.buscarProdutoPeloNome(nome)) { // se o produto nao tiver cadastrado
            System.out.print("==> " + nome + " nao cadastrado(a) no sistema. \n Deseja vender outro produto? ");
            opcao = sc.nextLine(); 
            System.out.println(" ");
	        if (opcao.equals("sim")) {
	            auxiliaVenda();	
	         }    
        }else { // se o produto informado pelo usuario ja estiver cadastrado
        	auxiliaVenda(); 
        }
	        // se o usuario desejar cadastrar um novo produto
	    System.out.println("Deseja vender outro produto? ");
	    opcao = sc.nextLine(); 
	    sc.nextLine();
	    
	    if (opcao.equals("sim")) {
	    	System.out.print("Digite o nome do produto: ");
	        nome = sc.nextLine();
	        auxiliaVenda();	
	    }  
    }
    
    // metodo auxiliar na venda do produto 
	public static void auxiliaVenda(){
    
        System.out.println("==> " + produto.getNome() + "(" + produto.getTipo() + ")." + "R$" + produto.getPreco());
        System.out.println(" ");
        System.out.print("Digite a quantidade que deseja vender: ");
        quantidadeDeProdutos = sc.nextInt();
        if (verificaProdutosSuficiente()) {
        	totalArrecadado = calculaTotalArrecadado(quantidadeDeProdutos);
            System.out.println("==> Total arrecadado: R$ " + totalArrecadado);
		}else {
			System.out.println("Nao eh possivel vender pois nao ha " + produto.getNome() + " suficiente.");
		}
    }
	
    // metodo que calcula o valor gasto pela compra dos produtos
    public static double calculaTotalArrecadado(int quantidade) {
		totalArrecadado = totalArrecadado + (produto.getPreco() * quantidade);
		return totalArrecadado;
    }
    
    // metodo que calcula quantos produtos restaram apos a venda
    public static double calculaRestanteVendaProduto(int quantidade){
    	if (estoque.verificaEstoqueVazio()){
    		if(quantNoEstoque > quantidadeDeProdutos){
    			restanteProdutos = restanteProdutos + (quantNoEstoque - quantidadeDeProdutos);
    		}
    	}	
    	return restanteProdutos;
    }
    
    // metodo que verifica se tem produtos suficientes para venda
    public static boolean verificaProdutosSuficiente(){
    	if (estoque.verificaEstoqueVazio()){
    		if(quantNoEstoque > quantidadeDeProdutos){
    			return true;
    		}
    	}
		return false;	
    }
    
    public void imprimirBalanco(){
        System.out.println("= = = = Impressao de Balanco = = = =");
        
		//verifica se o estoque esta vazio
		if (estoque.verificaEstoqueVazio()) {
			System.out.println("Nenhum produto cadastrado.");
		} else {
			//se nao estiver vazio ele usa o laço para imprimir os produtos
			System.out.println("Produtos Cadastrados: ");
			for (int i = 0; i < estoque.verificaPosicoesArray(); i++) {
				System.out.println("   " + (i + 1) + ") " + Estoque.estoque[i].toString() + " Restante: " + calculaRestanteVendaProduto(Estoque.estoque[i].getQuant()));
			}
		}	       
    }
}
