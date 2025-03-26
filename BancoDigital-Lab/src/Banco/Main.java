package Banco;

import Contas.Conta;
import Contas.ContaPoupanca;
import Cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== MENU BANCO DIGITAL ===");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Ver extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    if (nomeCliente.trim().isEmpty()) {
                        System.out.println("Nome do cliente não pode ser vazio!");
                        break;
                    }
                    Cliente cliente = new Cliente(nomeCliente);

                    System.out.println("Escolha o tipo de conta:");
                    System.out.println("1. Conta Corrente");
                    System.out.println("2. Conta Poupança");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Conta novaConta = (tipoConta == 1) ? new ContaPoupanca(cliente) : new ContaPoupanca(cliente);
                    contas.add(novaConta);
                    System.out.println("Conta criada com sucesso! Número da conta: " + novaConta.getNumeroConta());
                    break;

                case 2:
                    Conta contaDeposito = selecionarConta(contas, scanner);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor do depósito: ");
                        double deposito = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a quebra de linha
                        contaDeposito.deposito(deposito);
                    }
                    break;

                case 3:
                    Conta contaSaque = selecionarConta(contas, scanner);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor do saque: ");
                        double saque = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a quebra de linha
                        contaSaque.saque(saque);
                    }
                    break;

                case 4:
                    System.out.println("Selecione a conta de origem:");
                    Conta contaOrigem = selecionarConta(contas, scanner);
                    if (contaOrigem != null) {
                        System.out.print("Digite o número da conta de destino: ");
                        int numContaDestino = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        Conta contaDestino = buscarContaPorNumero(contas, numContaDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor a ser transferido: ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a quebra de linha
                            contaOrigem.transferencia(valorTransferencia, contaDestino);
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    }
                    break;

                case 5:
                    Conta contaExtrato = selecionarConta(contas, scanner);
                    if (contaExtrato != null) {
                        contaExtrato.imprimirExtrato();
                    }
                    break;

                case 0:
                    System.out.println("Saindo... Obrigado por utilizar o banco digital!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static Conta selecionarConta(List<Conta> contas, Scanner scanner) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return null;
        }

        System.out.println("\nContas disponíveis:");
        for (Conta conta : contas) {
            System.out.println("Número: " + conta.getNumeroConta() + " | Titular: " + conta.getTitular().getNome());
        }

        System.out.print("\nDigite o número da conta desejada: ");
        int numConta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        return buscarContaPorNumero(contas, numConta);
    }

    private static Conta buscarContaPorNumero(List<Conta> contas, int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }
}