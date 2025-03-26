package Contas;

import Cliente.Cliente;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente titular) {
        super(titular);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Contas.Conta Poupança ===");
        super.imprimirExtrato();
    }
}
