import java.util.Arrays;

public class BasicMaths {
    public static void main(String[] args) {
        // countDigits(657689);
        // countDigitsEfficient(657689);
        // findArmstrong(373);
        // checkPalindrome(121);
        // printAllDivisors(13);
        // checkPrime(37);
        // sieveOfEratosthenes(37);
        // System.out.println((int)newtonRaphsonAlgo(25));
        // gcd(0, 5);
        // euclideanGCD(24, 36);
        // System.out.println("GCD : " + efficientEuclideanGCD(24, 36));
        // lcm(24, 36);
        factorial(5);
        
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
        // int counter = (int) ((int) Math.log(num) / Math.log(10)) + 1;
        int counter = (int)Math.log10(num) + 1;
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
        for (int i = 2; i <= (int) newtonRaphsonAlgo(num); i++) {
            if (num % i == 0) {
                System.out.println(i + " : is divisor of " + num);
                int temp = num / i;
                if (temp != i) {
                    System.out.println(temp + " : is divisor of " + num);
                }
            }
        }
    }

    static void checkPrime(int num) {
        if (num == 0 || num == 1) {
            System.out.println(num + " is neither a prime nor a composite number.");
            return;
        }
        for (int i = 2; i <= (int) newtonRaphsonAlgo(num); i++) {
            if (num % i == 0) {
                System.out.println(num + " is a composite number.");
                return;
            }
        }
        System.out.println(num + " is a prime number.");
    }
    
    static void sieveOfEratosthenes(int num) {
        boolean arr[] = new boolean[num + 1];
        Arrays.fill(arr, true);
        int counter = 2;
        while (counter <= num) {
            if (arr[counter] == true) {
                for (int factor = counter + counter; factor <= num; factor += counter) {
                    arr[factor] = false;
                }
            }
            counter++;
        }
        for (int i = 2; i <= num; i++) {
            if (arr[i] == true) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("are prime numbers till " + num + ".");
    }

    static double newtonRaphsonAlgo(int num) {
        double root;
        double X = num;
        double tolerance = 0.00001;

        while (true) {
            root = 0.5 * (X + (num / X));
            double ans = X - root;
            if (ans < tolerance) {
                break;
            }
            X = root;
        }
        return X;
    }

    static void gcd(int num1, int num2) {
        int min = (num1 > num2) ? num2 : num1;
        while (min > 0) {
            if (num1 % min == 0 && num2 % min == 0) {
                System.out.println("GCD of " + num1 + " and " + num2 + " : " + min);
                return;
            }
            min--;
        }
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("GCD of " + num1 + " and " + num2 + " : " + max);
    }

    static void euclideanGCD(int num1, int num2) {
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        int res = num1;
        if (num1 == 0) {
            res = num2;
        }
        System.out.println("GCD : " + res);
    }

    static int efficientEuclideanGCD(int num1, int num2) {
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 %= num2;
            } else {
                num2 %= num1;
            }
        }
        int res = num1;
        if (num1 == 0) {
            res = num2;
        }
        return res;
    }

    static void lcm(int num1, int num2) {
        int res = (num1 * num2) / efficientEuclideanGCD(num1, num2);
        System.out.println("LCM of " + num1 + " and " + num2 + " : " + res);
    }

    static void factorial(int num) {
        long res = 1;
        while (num > 1) {
            res *= num;
            num--;
        }
        System.out.println("Factorial of num : " + res);
    }
}
