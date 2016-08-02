package SupermercadoEconomizaP2;
/*
 * 115111596 - Thais Nicoly Araujo Toscano: LAB 3 - Turma 01
 */

import java.util.Scanner;
 
public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
         
        System.out.println("= = = = Bem vindo(a) ao EconomizaP2 = = = =");
        Supermercado supermercado = new Supermercado();
  
        do{
            System.out.println("Digite a opção desejada: \n 1 - Cadastrar um Produto \n 2 - Vender um Produto \n 3 - Imprimir Balanço \n 4 - Sair \n Opção: ");
            opcao = sc.nextInt();
  
            switch(opcao){
            case 1: 
                supermercado.cadastro();  
                break;
            case 2:
                supermercado.vendaDeProdutos();
                break;
            case 3:
                supermercado.imprimirBalanco();
                break;
            case 4:
                break;
            }   
            } while(opcao != 4);
                              
        System.out.println("-- Fim da execucao --");
        sc.close();
        }
    }   