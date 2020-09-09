package com.redbash;

import java.text.NumberFormat;

public class Mortgage {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;
    private final NumberFormat currency;
    private int principal_income;
    private float annual_rate;
    private int period;
    private double totalMortgage;

    public  Mortgage(int principal_income, float annual_rate, int period){
        setAnnualRate(annual_rate);
        setPeriod(period);
        setPrincipal_Income(principal_income);
        currency = NumberFormat.getCurrencyInstance();
    }

    public  void calculateMortgage(){

        float monthly_ir = getMonthlyInterest();
        int number_payments = getNumberPayments();

        //mortgage = principal_income * ((annual_rate * (1 + annual_rate)^period) / ((1 + annual_rate)^period - 1)

        totalMortgage = principal_income * monthly_ir * Math.pow((1 + monthly_ir), number_payments) / (Math.pow((1 + monthly_ir), number_payments) - 1);
    }

    public  void monthPayment(){

        float monthly_ir = getMonthlyInterest();
        int number_payments = getNumberPayments();

        for (int payments_left = 0; payments_left <= number_payments; payments_left++){
            double total = principal_income * (Math.pow((1 + monthly_ir),number_payments) - Math.pow((1 + monthly_ir),payments_left))
                    /( Math.pow((1 + monthly_ir), number_payments) - 1);
            String total_string = currency.format(total);
            System.out.println(total_string);
        }
        // total = principal_income * (((1+month_interest)^number_of_payments - (1+month_interest)^number_of_payments_made))/
        //(1+month_interest)^number_of_payments - 1
    }

    public  void PrintResult() {
        String mortgage_str = currency.format(totalMortgage);
        System.out.println("MORTGAGE");
        System.out.println("-------------");
        System.out.println("Monthly Payments: " + mortgage_str);
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------");
        monthPayment();
    }

    private int getNumberPayments() {
        return period * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annual_rate / PERCENT / MONTHS_IN_YEAR;
    }

    public  void setPrincipal_Income(int principal_income) {
        this.principal_income = principal_income;
    }


    public  void setAnnualRate(float annual_rate) {
        this.annual_rate = annual_rate;
    }

    public  void setPeriod(int period) {
        this.period = period;
    }
}
