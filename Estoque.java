package SupermercadoEconomizaP2;
/*
 * 115111596 - Thais Nicoly Araujo Toscano: LAB 3 - Turma 01
 * Classe Estoque 
 * Onde serão armazenados os produtos cadastrados
 */
  
public class Estoque {
  
    public static Produto[] estoque;
    private int quantProdutosCadastrados;
    
    public Estoque(){
        estoque = new Produto[2];
        quantProdutosCadastrados = 0;
    }
     
    // metodo que armazena os produtos no array-estoque  
    public void armazenarProdutos(Produto produto){
    	if (quantProdutosCadastrados < estoque.length) {
    		estoque[quantProdutosCadastrados] = produto;
            quantProdutosCadastrados = quantProdutosCadastrados + 1; 
		} else {
			expandirArrayEstoque();
		}
			
	}  
    
    // metodo para o array crescer dinamicamente 
    public void expandirArrayEstoque(){
        Produto[] estoqueMaior = new Produto[estoque.length*2];
    	for (int i = 0; i < estoque.length; i++) {
			estoqueMaior[i] = estoque[i];
    	}
		estoque = estoqueMaior;
    }
     
    // metodo que verifica se o estoque esta vazio 
    public boolean verificaEstoqueVazio() {
        if (quantProdutosCadastrados == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * metodo que auxilia na varredura do array
     * ele percorre apenas as posicoes preenchidas
     * do array
     */
    public int verificaPosicoesArray(){
    	int indice = 0;
		while (Estoque.estoque[quantProdutosCadastrados] != null) {
			indice = indice + 1;
		}
    	return indice;
    }
    
    /* metodo para saber se tem ja tem o produto
     * retorna apenas True ou False
     */
    public boolean buscarProdutoPeloNome(String nome){
    	if (verificaEstoqueVazio()){
    		for (int i = 0; i < verificaPosicoesArray(); i++) {
                if(estoque[i].getNome().equals(nome)){
                    return true;
                }	
    	     } 
      }
        return false;
    }
   
    /* metodo para saber se tem ja tem o produto
     * retorna o objeto Produto
     */
    public Produto buscarṔrodutos(Produto produto){
        if (verificaEstoqueVazio()) {
            for (int i = 0; i < Estoque.estoque.length; i++) {
                if (Estoque.estoque[i].equals(produto)) {
                    return estoque[i];
                }
            }
        }
        return null;
    }
}