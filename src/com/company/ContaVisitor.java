package com.company;

public class ContaVisitor implements Visitor{

    @Override
    public String pix(Conta contaOrigem, Conta contaDestino, float valor) {
        if(contaOrigem.getSaldo() >= valor){
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            return "pix realizado com sucesso";
        }
        else {
            return "saldo insuficiente para o pix";
        }
    }
}
