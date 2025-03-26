package OperacoesBancarias;

public interface OperacoesBancarias {
    void deposito(double valor);
    void saque(double valor);
    void transferencia(double valor, OperacoesBancarias contaDestino);
}