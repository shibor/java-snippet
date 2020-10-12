package com.github.shibor.snippet.finance;


import org.junit.Test;

public class IRRTest {

    @Test
    public void irr() {
        double[] income = {-700000, 120000, 150000, 180000, 210000, 260000};

        double irr = IRR.irr(income);
        System.out.println("irr: " + irr);
    }


    @Test
    public void npv() {
        double[] income = {-700000, 120000, 150000, 180000, 210000, 260000};
        double npv = IRR.npv(0.0866309480365222, income);
        System.out.printf("npv: %f \n", npv);
    }
}