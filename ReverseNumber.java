import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println("Enter number : ");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int res = getReversedNumber(num);

        System.out.println("Reversed Number : " + res);

        sc.close();
    }

    static int getReversedNumber(int num) {
        int res = 0;
        
        while (num != 0) {
            res = res * 10 + (num % 10); // Extract unit digit and multiple it by 10
            num /= 10; // Remove unit digit
        }

        return res;
    }
}