package com.redbash;

public class Main {

    public static void main(String[] args) {
        var income = new Values("Principal Income: ", 1000, 1000000 );
        int principalIncome = (int) income.readNumber();
        var rate =  new Values("Annual Interest Rate: ", 1, 30);
        float annualRate = (float)rate.readNumber();
        var period = new Values("Period (Years): ", 1, 30);
        int years = (int)period.readNumber();

        var mortgage = new Mortgage(principalIncome, annualRate, years);

        mortgage.calculateMortgage();
        mortgage.PrintResult();

    }

}
