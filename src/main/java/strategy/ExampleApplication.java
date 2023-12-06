package main.java.strategy;

import java.util.Scanner;

public class ExampleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();

        while (true) {
            System.out.println("---- Menu ----");
            System.out.println("1. Adição");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Saindo...");
                break;
            }

            System.out.print("Digite o primeiro número: ");
            int num1 = scanner.nextInt();

            System.out.print("Digite o segundo número: ");
            int num2 = scanner.nextInt();

            switch (choice) {
                case 1:
                    context.setStrategy(new ConcreteStrategyAdd());
                    break;
                case 2:
                    context.setStrategy(new ConcreteStrategySubtract());
                    break;
                case 3:
                    context.setStrategy(new ConcreteStrategyMultiply());
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }

            int result = context.executeStrategy(num1, num2);
            System.out.println("Resultado: " + result);
        }

        scanner.close();
    }
}