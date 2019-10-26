
package bancoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class Conta {

    public static Scanner teclado = new Scanner(System.in);
    public static Random numero = new Random(9999);

    private String Nome;
    int NumConta;
    double Saldo;
    public static List<Conta> lista = new ArrayList();

    public Conta(String Nome, int NumConta, double Saldo) {
        this.Nome = Nome;
        this.NumConta = NumConta;
        this.Saldo = Saldo;
    }

    public Conta() {
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getNumConta() {
        return NumConta;
    }

    public void setNumConta(int NumConta) {
        this.NumConta = NumConta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public static void movimentarConta() {

        int opcao2;
        int acessarConta;
        double limite = 1000;
        System.out.print("\n\nDigite a conta que deseja acessar:");
        acessarConta = Integer.parseInt(teclado.nextLine());

        for (Conta objeto : Conta.lista) {
            if (acessarConta == objeto.getNumConta()) {

                do {
                    System.out.println("\n\nConta: " + acessarConta);
                    System.out.println("\n\n***Movimentar Conta***");
                    System.out.println("[1] - Sacar");
                    System.out.println("[2] - Depositar");
                    System.out.println("[3] - Extrato");
                    System.out.println("[4] - Sair");
                    System.out.print("Opção: ");
                    opcao2 = Integer.parseInt(teclado.nextLine());

                    if (opcao2 == 1) { //sacar

                        double vlrSaque;
                        System.out.println("\n*** Opção saque ***");
                        System.out.print("\nValor do saque: ");
                        vlrSaque = Double.parseDouble(teclado.nextLine());
                        double saldo = objeto.getSaldo();
                        if (limite >= vlrSaque) {
                            if (objeto.getSaldo() >= vlrSaque) {
                                objeto.setSaldo(saldo - vlrSaque);
                                limite = limite - vlrSaque;
                                System.out.println("\nSaque no valor de: R$ " + vlrSaque + " realizado com sucesso.");
                                System.out.print("Seu saldo é: R$ " + objeto.getSaldo());
                            } else {
                                System.out.println("\nSaldo insuficiente! :: Seu saldo é: " + objeto.getSaldo());
                             
                            }
                        } else {
                            System.out.println("\nLimite diário excedido! --- Limite diário disponivel: R$ " + limite);

                        }

                    }
                    if (opcao2 == 2) { // depositar

                        double vlrDeposito, deposito;
                        double saldo = objeto.getSaldo();
                        System.out.print("\nValor do deposito: R$ ");
                        vlrDeposito = Double.parseDouble(teclado.nextLine());
                        deposito = vlrDeposito + saldo;
                        objeto.setSaldo(deposito);
                        System.out.println("\nDeposito no valor de: R$ " + vlrDeposito + " realizado com sucesso.");
                        System.out.println("Seu novo saldo é de: R$ " + objeto.getSaldo());
                    }

                    if (opcao2 == 3) { // extrato

                        System.out.print("\n\n***Extrato***");
                        System.out.println("");
                        System.out.print("Nome: " + objeto.getNome());
                        System.out.println("");
                        System.out.print("Conta: " + objeto.getNumConta());
                        System.out.println("");
                        System.out.print("Saldo: R$ " + objeto.getSaldo());
                        System.out.println("");
                        System.out.print("Limite disponivel para saque: R$ " + limite);
                    }

                } while (opcao2 != 4);
            }
        }

    }

    public static void criarConta() {
        double depositoInicial;
        Conta novaConta = new Conta();

        System.out.println("\n\n*** Cadastro de Cliente ***");
        System.out.print("Digite o nome :");
        novaConta.setNome(teclado.nextLine());
        novaConta.setNumConta(1 + numero.nextInt(9999));
        System.out.print("Digite o valor do deposito inicial: ");
        depositoInicial = Double.parseDouble(teclado.nextLine());
        novaConta.setSaldo(depositoInicial);

        //Coloca os dados digitados para dentro da lista
        Conta.lista.add(novaConta);
        System.out.println("\n\n***Novo cliente cadastrado***");
        System.out.println("Nome: " + novaConta.getNome());
        System.out.println("Número da Conta: " + novaConta.getNumConta());
        System.out.println("Saldo: R$ " + novaConta.getSaldo());

    }

    public static void listaClientes() {

        for (Conta objeto : Conta.lista) {
            
            System.out.println("");
            System.out.print("Nome: " + objeto.getNome());
            System.out.println("");
            System.out.print("Conta: " + objeto.getNumConta());
            System.out.println("");
            System.out.print("Saldo: R$ " + objeto.getSaldo());
            System.out.println("");

        }

    }

}
