import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double num1 = getNumber(scanner, "Enter the first number: ");
    double num2 = getNumber(scanner, "Enter the second number: ");
    char operator = getOperator(scanner);

    double result;

    switch (operator) {
      case '+':
        result = num1 + num2;
        break;
      case '-':
        result = num1 - num2;
        break;
      case '*':
        result = num1 * num2;
        break;
      case '/':
        if (num2 == 0) {
          System.out.println("Division by zero is not allowed");
          return;
        }
        result = num1 / num2;
        break;
      default:
        System.out.println("Invalid operator");
        return;
    }

    System.out.println("The result is: " + result);
  }

  private static double getNumber(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      if (scanner.hasNextDouble()) {
        return scanner.nextDouble();
      } else {
        System.out.println("Invalid number");
        scanner.next();
      }
    }
  }

  private static char getOperator(Scanner scanner) {
    while (true) {
      System.out.print("Enter the operator (+, -, *, /): ");
      String input = scanner.next();
      if (input.length() == 1) {
        char c = input.charAt(0);
        if (c == '+' || c == '-' || c == '*' || c == '/') {
          return c;
        }
      }
      System.out.println("Invalid operator");
    }
  }
}