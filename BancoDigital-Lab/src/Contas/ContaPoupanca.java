package Contas;

import Cliente.Cliente;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente titular) {
        super(titular);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Contas.Conta Corrente ===");
        super.imprimirExtrato();
    }
}
