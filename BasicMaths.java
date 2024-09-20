public class BasicMaths {
    public static void main(String[] args) {
        countDigits(657689);
        countDigitsEfficient(657689);
        findArmstrong(373);
        checkPalindrome(121);
        printAllDivisors(13);
    }

    static void countDigits(int num) {
        if (num == 0) {
            System.out.println(1);
            return;
        }
        int counter = 0;
        while (num > 0) {
            num /= 10;
            counter++;
        }

        System.out.println(counter);
    }

    static void countDigitsEfficient(int num) {
        if (num == 0) {
            System.out.println(1);
            return;
        }
        int counter = (int) ((int) Math.log(num) / Math.log(10)) + 1;
        System.out.println(counter);
    }

    static void findArmstrong(int num) {
        int res = 0;
        int copy = num;
        while (num > 0) {
            res += (int) Math.pow((num % 10), 3);
            num /= 10;
        }
        System.out.println(copy == res);
    }

    static int reverseNumber(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }

        return res;
    }

    static void checkPalindrome(int num) {
        if (reverseNumber(num) == num) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    static void printAllDivisors(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i + " : is divisor of " + num);
                int temp = num / i;
                if (temp != i) {
                    System.out.println(temp + " : is divisor of " + num);
                }
            }
        }
    }
}
