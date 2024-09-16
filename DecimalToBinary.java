import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Enter number to be converted to binary : ");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int bin = getBinary(num);
        int oct = getOctal(num);

        System.out.println("Binary conversion of " + num + " : " + bin);
        System.out.println("Octal conversion of " + num + " : " + oct);

        sc.close();
    }

    static int getBinary(int num) {
        int res = 0;

        while (num != 0) {
            res = res * 10 + (num % 2);
            num /= 2;
        }

        res = ReverseNumber.getReversedNumber(res);
        return res;
    }
    
    static int getOctal(int num) {
        int res = 0;

        while (num != 0) {
            res = res * 10 + (num % 8);
            num /= 8;
        }
        
        res = ReverseNumber.getReversedNumber(res);
        return res;
    }
}
