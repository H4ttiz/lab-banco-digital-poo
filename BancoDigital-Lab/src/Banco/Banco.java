package Banco;

import Contas.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nomeBanco = "Bradesco S.A";
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
    }

    public void removerConta(Conta conta) {
        this.contas.remove(conta);
    }
}