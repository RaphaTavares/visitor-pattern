package com.company;

public class ContaPoupanca implements Conta{
    private float saldo;
    private String nome;
    private static double rendimento = 0.05;

    public ContaPoupanca(float saldo, String nome){
        this.saldo = saldo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public float getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public double getRendimento(){
        return rendimento;
    }

    @Override
    public String aceitar(Visitor visitor, Conta conta, float valor) {
        return visitor.pix(this, conta, valor);
    }
}