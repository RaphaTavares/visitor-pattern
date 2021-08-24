package com.company;

public class ContaCorrente implements Conta{
    private float saldo;
    private String nome;

    public ContaCorrente(float saldo, String nome){
        this.saldo = saldo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public String aceitar(Visitor visitor, Conta conta, float valor) {
        return visitor.pix(this, conta, valor);
    }
}
