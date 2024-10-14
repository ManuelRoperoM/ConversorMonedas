package com.alura.conversor.main;

import com.alura.conversor.api.ExchangeApi;
import com.alura.conversor.conversion.Conversion;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String moneySelector(int option){
        String money = "";
        switch (option){
            case 1:
                money = "USD";
                break;
            case 2:
                money = "COP";
                break;
            case 3:
                money = "ARS";
                break;
            case 4:
                money = "BRL";
        }

        return money;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bienvenido al conversor mundial!!");
        Scanner keyboard = new Scanner(System.in);
        String menuMoney = """
                1) Dolar
                2) Peso Colombiano
                3) Peso Argentino
                4) Real Brasil
                """;
        while (true){
            ExchangeApi change = new ExchangeApi();
            System.out.println("Seleccione la moneda de base: ");
            System.out.println(menuMoney);
            int firstOption = keyboard.nextInt();
            String base = moneySelector(firstOption);
            System.out.println("Digite el monto: ");
            double amount = keyboard.nextDouble();
            System.out.println("Seleccione la moneda a cambiar: ");
            System.out.println(menuMoney);
            int secondOption = keyboard.nextInt();
            String cambio = moneySelector(secondOption);
            Conversion conversionData = change.changeMoney(base, cambio, amount);
            System.out.println(amount+"["+conversionData.base_code()+"] = "+conversionData.conversion_result()+"["+conversionData.target_code()+"]");
            System.out.println("Digite 1 para hacer otra conversion y 0 para salir");
            int option = keyboard.nextInt();

            if (option == 0){
                break;
            }
        }

        System.out.println("Gracias por usar nuestros servicios :)");

    }
}
