package com.company;

public interface Conta {
    String aceitar(Visitor visitor, Conta conta, float valor);

    float getSaldo();
    void setSaldo(float saldo);
}
