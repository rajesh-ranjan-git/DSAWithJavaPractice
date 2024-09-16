import java.util.Scanner;

public class Calculator {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to our CLI calculator!");

        calculatorFunction();

        sc.close();
    }
    
    static void calculatorFunction() {
        do {
            System.out.print("Choose your operation ( +, -, *, % ) : ");
            String operationInput = sc.nextLine();

            double result = getOperator(operationInput);

            System.out.println(result);

            System.out.print("Want to try again? (Y/N) : ");

            tryAgain();

        } while (true);
    }

    static void endCalculator() {
        System.out.println("Thank you for choosing our calculator!");
        System.exit(0);
    }

    static double inputFunction() {
        return sc.nextDouble();
    } 

    static double getOperator(String operationInput) {
        char ch = operationInput.charAt(0);
        int operationFlagCounter = 0;
        double result = 0.0;

        while (true) {
            switch (ch) {
                case '+':
                    System.out.println("Addition :");
                    result = addition();
                    break;

                case '-':
                    System.out.println("Subtraction :");
                    result = subtraction();
                    break;

                case '*':
                    System.out.println("Multiplication :");
                    result = multiplication();
                    break;

                case '/':
                    System.out.println("Division :");
                    result = division();
                    break;

                default:
                    System.out.println("Incorrect operator provided, please try again.");
                    operationFlagCounter++;
                    break;
            }
            
            if (operationFlagCounter == 5) {
                maxAttemptReached();
            }

            break;
        }

        return result;
    }
    
    static double addition() {
        System.out.print("Enter num1 : ");
        double num1 = inputFunction();

        System.out.print("Enter num2 : ");
        double num2 = inputFunction();

        return num1 + num2;
    }

    static double subtraction() {
        System.out.print("Enter num1 : ");
        double num1 = inputFunction();

        System.out.print("Enter num2 : ");
        double num2 = inputFunction();

        return num1 - num2;
    }

    static double multiplication() {
        System.out.print("Enter num1 : ");
        double num1 = inputFunction();

        System.out.print("Enter num2 : ");
        double num2 = inputFunction();

        return num1 * num2;
    }

    static double division() {
        System.out.print("Enter num2 : ");
        double num1 = inputFunction();
        double num2;

        int divisionFlagCounter = 0;

        while (true) {
            System.out.print("Enter num2 : ");
            num2 = inputFunction();

            if (num2 != 0) {
                break;
            } else {
                divisionFlagCounter++;
                System.out.println("Zero division error : Cannot divide by 0, please provide correct input.");
            }

            if (divisionFlagCounter == 5) {
                maxAttemptReached();
            }
        }

        return num1 / num2;
    }

    static void tryAgain() {

        int tryAgainCounter = 0;

        while (true) {
            String tryAgainInput = sc.next();

            char ch = tryAgainInput.charAt(0);

            // if ((tryAgainInput == "Yes") || (tryAgainInput == "YES") || (tryAgainInput == "yes") || (tryAgainInput == "Y")
            //         || (tryAgainInput == "y")) {
            //     calculatorFunction();
            // } else if ((tryAgainInput == "No") || (tryAgainInput == "no") || (tryAgainInput == "NO") || (tryAgainInput == "N") || (tryAgainInput == "n")) {
            //     endCalculator();
            if ((ch == 'Y') || (ch == 'y')) {
                calculatorFunction();
            // } else if ((tryAgainInput == "No") || (tryAgainInput == "no") || (tryAgainInput == "NO") || (tryAgainInput == "N") || (tryAgainInput == "n")) {
            //     endCalculator();
            } else {
                System.out.print("Wrong input, please enter correct response. Want to try again? :");
                tryAgainCounter++;

                if (tryAgainCounter == 5) {
                    maxAttemptReached();
                }
            }
        }
    }
    
    static void maxAttemptReached() {
        System.out.println("Oopss! You have exceeded the maximum number of attempts.");
        endCalculator();
    }
}