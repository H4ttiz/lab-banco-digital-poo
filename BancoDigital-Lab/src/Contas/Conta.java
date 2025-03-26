package Contas;

import Cliente.Cliente;
import OperacoesBancarias.OperacoesBancarias;

public abstract class Conta implements OperacoesBancarias {
    protected String agencia;
    protected int numeroConta;
    protected double saldo;
    protected Cliente titular;
    private static final String AGENCIA_PADRAO = "2375";
    private static int SEQUENCIAL = 1;

    public Conta(Cliente titular) {
        this.titular = titular;
        this.numeroConta = SEQUENCIAL++;
        this.agencia = AGENCIA_PADRAO;
        this.saldo = 0;
    }

    public Cliente getTitular() {
        return titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void deposito(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public void saque(double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void transferencia(double valor, OperacoesBancarias contaDestino) {
        if (valor > 0 && saldo >= valor) {
            this.saque(valor);
            contaDestino.deposito(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente ou valor inválido.");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}