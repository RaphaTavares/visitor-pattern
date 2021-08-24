package com.company.tests;

import com.company.Conta;
import com.company.ContaCorrente;
import com.company.ContaPoupanca;
import com.company.ContaVisitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaVisitorTest {

    @Test
    void deveFazerPixPoupancaPoupanca(){
        Conta contaOrigem = new ContaPoupanca(500, "Raphael");
        Conta contaDestino = new ContaPoupanca(600, "Marco");

        ContaVisitor visitor = new ContaVisitor();
        assertEquals("pix realizado com sucesso", visitor.pix(contaOrigem, contaDestino, 300));
        assertEquals(200, contaOrigem.getSaldo());
        assertEquals(900, contaDestino.getSaldo());
    }

    @Test
    void deveFazerPixPoupancaCorrente(){
        Conta contaOrigem = new ContaPoupanca(200, "Raphael");
        Conta contaDestino = new ContaCorrente(300, "Marco");

        ContaVisitor visitor = new ContaVisitor();
        assertEquals("pix realizado com sucesso", visitor.pix(contaOrigem, contaDestino, 150));
        assertEquals(50, contaOrigem.getSaldo());
        assertEquals(450, contaDestino.getSaldo());
    }

    @Test
    void deveFazerPixCorrenteCorrente(){
        Conta contaOrigem = new ContaCorrente(400, "Raphael");
        Conta contaDestino = new ContaCorrente(400, "Marco");

        ContaVisitor visitor = new ContaVisitor();
        assertEquals("pix realizado com sucesso", visitor.pix(contaOrigem, contaDestino, 300));
        assertEquals(100, contaOrigem.getSaldo());
        assertEquals(700, contaDestino.getSaldo());
    }

    @Test
    void deveFazerPixCorrentePoupanca(){
        Conta contaOrigem = new ContaCorrente(1500, "Raphael");
        Conta contaDestino = new ContaPoupanca(9000, "Marco");

        ContaVisitor visitor = new ContaVisitor();
        assertEquals("pix realizado com sucesso", visitor.pix(contaOrigem, contaDestino, 1500));
        assertEquals(0, contaOrigem.getSaldo());
        assertEquals(10500, contaDestino.getSaldo());
    }
}
