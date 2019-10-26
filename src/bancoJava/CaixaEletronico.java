package bancoJava;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class CaixaEletronico {

    public static Scanner teclado = new Scanner(System.in);
    

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n\n*** [Banco Java] ***");
            System.out.println("[1] - Criar conta corrente");
            System.out.println("[2] - Movimentar conta");
            System.out.println("[3] - Mostrar clientes e contas");
            System.out.println("[4] - Sair");
            System.out.print(" Opcao : ");
            opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) {
                Conta.criarConta();

            }
            if (opcao == 2) {
                if (Conta.lista.isEmpty()) {
                    System.out.println("\n\nNão há clientes cadastrados");
                } else {
                    Conta.movimentarConta();
                }
            }

            if (opcao == 3) {
                if (Conta.lista.isEmpty()) {
                    System.out.println("\n\nNão há clientes cadastrados");
                } else {
                    Conta.listaClientes();
                }
            }
        } while (opcao != 4);
    }

}
