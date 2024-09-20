import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to calculator application...!");
        Scanner sc = new Scanner(System.in);
        int retryCounter = 0;
        do {
            System.out.print("Choose your operation -> +, -, *, / -> ");
            String operator = sc.next();
            if (operator.length() != 1) {
                retryCounter++;
                System.out.println("Wrong Input! Please try again.");
                if (retryCounter >= 5) {
                    System.out.println("Too many invalid attempts! Thank you for choosing Calculator application!");
                    break;
                }
            } else {
                boolean isSuccesfulOperation = getOperator(operator.charAt(0));
                if (!isSuccesfulOperation) {
                    retryCounter++;
                    if (retryCounter >= 5) {
                        System.out.println("Too many invalid attempts! Thank you for choosing Calculator application!");
                        break;
                    }
                }
            }
            boolean tryAgainFlag = tryAgain();
            if (tryAgainFlag != true || retryCounter >= 5) {
                System.out.println("Thank you for choosing Calculator application!");
                break;
            }
        } while (true);
        sc.close();
    }

    public static double getInputNum() {
        Scanner scInput = new Scanner(System.in);
        return scInput.nextDouble();
    }

    public static boolean getOperator(char ch) {
        switch (ch) {
            case '+':
                System.out.println("Addition");
                System.out.print("Enter num1 : ");
                double num1 = getInputNum();
                System.out.print("Enter num2 : ");
                double num2 = getInputNum();
                System.out.println("Result : " + (num1 + num2));
                break;
            case '-':
                System.out.println("Subtraction");
                System.out.print("Enter num1 : ");
                double num3 = getInputNum();
                System.out.print("Enter num2 : ");
                double num4 = getInputNum();
                System.out.println("Result : " + (num3 - num4));
                break;
            case '*':
                System.out.println("Multiplication ->");
                System.out.print("Enter num1 : ");
                double num5 = getInputNum();
                System.out.print("Enter num2 : ");
                double num6 = getInputNum();
                System.out.println("Result : " + (num5 * num6));
                break;
            case '/':
                System.out.println("Division");
                System.out.print("Enter num1 : ");
                double num7 = getInputNum();
                System.out.print("Enter num2 : ");
                double num8 = getInputNum();
                if (num8 == 0.0) {
                    System.out.println("Zero division error : Cannot divide by 0.");
                    break;
                }
                System.out.println("Result : " + (num7 / num8));
                break;
            case '%':
                System.out.println("Modulus");
                System.out.print("Enter num1 : ");
                double num9 = getInputNum();
                System.out.print("Enter num2 : ");
                double num10 = getInputNum();
                System.out.println("Result : " + (num9 % num10));
                break;

            default:
                System.out.println("Unknown operation!");
                return false;
        }
        return true;
    }
    
    public static boolean tryAgain() {
        int retryCounter = 0;
        boolean retryFlag = false;
        Scanner scTryAgain = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Do you want to continue ? (Y/N) -> ");
            String continueInput = scTryAgain.next();
            char ci = continueInput.charAt(0);
            if (continueInput.length() == 1 && (ci == 'N' || ci == 'n')) {
                retryFlag = false;
                break;
            } else if (continueInput.length() == 1 && (ci == 'Y' || ci == 'y')) {
                retryFlag = true;
                break;
            } else {
                retryCounter++;   
                if (retryCounter >= 5) {
                    System.out.println("Too many wrong attempts!");
                    return false;
                } 
                System.out.println("Wrong input! Please try agin.");
            }
        }    
        if (retryFlag == false) {
            System.out.println("Have a nice day!");
            return false;
        } else if (retryFlag == true) {
            return true;
        }
        return false;
    }
}
