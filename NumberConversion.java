public class NumberConversion {
    public static void main(String[] args) {
        decimalToAnyBase(11, 2);
        anyBaseToDecimal(1011, 2);
        findEvenOdd(14585874);
        reverseNumber(15465);
        double res = power(10, 6);
        System.out.println(res);
    }

    static double power(int num, int pow) {
        double res = 1;
        for (int i = 0; i < pow; i++) {
            res *= num;
        }
        return res;
    }
    
    static void decimalToAnyBase(int num, int base) {
        int res = 0;
        int pow = 0;
        while (num > 0) {
            res += (num % base) * (int) power(10, pow);
            num /= base;
            pow++;
        }
        System.out.println(res);
    }

    static void anyBaseToDecimal(int num, int base) {
        int pow = 0;
        int res = 0;
        while (num > 0) {
            int unitDigit = num % 10;
            res += unitDigit * (int) power(base, pow);
            num /= 10;
            pow++;
        }

        System.out.println(res);
    }
    
    static void findEvenOdd(int num) {
        if (num % 2 == 0)
            System.out.println(num + " : Even.");
        else
            System.out.println(num + " : Odd.");
    }

    static void reverseNumber(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + (num % 10);
            num /= 10;
        }

        System.out.println(res);
    }
}
