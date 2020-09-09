package com.redbash;

import java.util.Scanner;

public class Values {
    private static Scanner scanner = new Scanner(System.in);
    public  double value;
    private  double min;
    private  double max;
    private  String prompt;

    public Values(String prompt, double min, double max){
        setPrompt(prompt);
        setMax(max);
        setMin(min);
    }

    public  double readNumber(){
            while (true) {
                System.out.print(prompt);
                setValue(scanner.nextFloat());
                if (getValue() >= min && getValue() <= max)
                    break;
                else
                    System.out.println("Enter a value between " + min + " and " + max);
            }
            return getValue();
    }

    public  double getValue() {
        return value;
    }

    public  void setValue(double value) {
        this.value = value;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
