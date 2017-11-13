package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.List;
import java.util.Scanner;

public class Main{

  public statick void main(String[] args) throws SaldoInsuficienteException{
    Scanner in = new Scanner(System.in);
    TicketMachine tktMachine = new TicketMachine(10);
    Troco troco;
    int menu;
    int valorDinheiro;
    
    outer:
    while(true){
      String divisor = "****************";
      
      System.out.println(divisor);
      System.out.println("Saldo Atual R$: " +tktMachine.getSaldo()+ ",00");
      System.out.println(divisor);
      
      System.out.println("MENU");
      System.out.println(separador);
      System.out.println("1 - Inserir Dinheiro");
      System.out.println(separador);
      System.out.println("2 - Solicitar Bilhete");
      System.out.println(separador);
      System.out.println("3 - Solicitar Troco");
      System.out.println(separador);
      System.out.println("4 - Sair");
      System.out.println(separador);
      
      menu = in.nextInt();
      
      switch(menu){
      case 1:
   	    System.out.println("Digite o valor que deseja inserir de dinheiro");
        valorDinheiro = in.nextInt();
        tktMachine.inserir(valorDinheiro);
      	break;
      case 2:
        tktMachine.imprimir();
        break;
      case 3:
        if(tktMachine.getSaldo() > 0) {
        System.out.println("Realizando solicitação de troco");
        System.out.println("Favor conferir troco");
        tktMachine.getTroco(tktMachine.getSaldo());
        tktMachine.zerarSaldo();
        } else {
          System.out.println("Não há troco para retirar.");
        }
        break;
      case 4:
         if (tktMachine.getSaldo() > 0) {
         System.out.println("Remova seu troco primeiro");
         break;
         } else {
           break outer;
         }
      default:
        System.out.println(separador);
        System.out.println("Opção inválida.");
   }
  }  
 }
}      
      
      
      
      
