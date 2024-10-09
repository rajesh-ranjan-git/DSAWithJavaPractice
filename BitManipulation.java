public class BitManipulation {
    public static void main(String[] args) {
        // printBits(65);
        // System.out.println(isBitSet(20, 4));;
        // findOddEven(20);
        // printBits(findIthBit(20, 4));
        // printBits(setIthBit(32, 2));
        // printBits(toggleBit(33, 4));
        // printBits(unSetBit(89, 3));
        // isPowerOf2(42);
        // printBits(unSetRightMostBit(48));
        // noOfSetBits(67);
        // printBits(clearLSB(53, 4));
        // printBits(clearMSB(53, 4));
        // printBits(clearLSBExclusive(53, 4));
        // printBits(clearMSBExclusive(53, 4));
        // System.out.println((char)(convertToLowerCase('A')));
        // System.out.println((char)(convertToUpperCase('a')));
        // System.out.println((char)(convertToLowerCaseWithSpace('A')));
        // System.out.println((char)(convertToUpperCaseWithSpace('a')));
        // System.out.println((char)(convertToUpperCaseWithUnderscore('a')));
        // swapNumbers(8, 99);
        // int arr[] = {2, 4, 2, 6, 3, 3 , 1, 1, 6};
        // printUniqueElement(arr);
        // int arr2[] = {7, 2, 4, 2, 6, 3, 3 , 1, 1, 6};
        // printTwoUniqueElement(arr2);
    }

    static void printBits(int num) {
        for (int i = 7; i >= 0; i--) {
            System.out.print((num >> i) & 1);
        }
        System.out.println();
    }

    static boolean isBitSet(int num, int bit) {
        int res = num & (1 << bit);
        return (res == 0) ? false : true;
    }

    static void findOddEven(int num) {
        if ((num & 1) == 1) {
            System.out.println(num + " is Odd.");
        } else {
            System.out.println(num + " is Even.");
        }
    }

    static int findIthBit(int num, int bit) {
        return ((num >> bit) & 1);
    }

    static int setIthBit(int num, int bit) {
        return (num | (1 << bit));
    }

    static int toggleBit(int num, int bit) {
        return (num ^ (1 << bit));
    }

    static int unSetBit(int num, int bit) {
        return (num & (~(1 << bit)));
    }

    static void isPowerOf2(int num) {
        if ((num & (num - 1)) == 0) {
            System.out.println(num + " is power of 2.");
        } else {
            System.out.println(num + " is not a power of 2.");
        }
    }

    static int unSetRightMostBit(int num) {
        return (num & (num - 1));
    }

    static void noOfSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num = unSetRightMostBit(num);
            count++;
        }
        System.out.println(count);
    }

    static int clearLSB(int num, int bit) {
        return (num & (~ ((1 << (bit + 1)) - 1)));
    }

    static int clearLSBExclusive(int num, int bit) {
        return (num & (~ ((1 << bit) - 1)));
    }

    static int clearMSB(int num, int bit) {
        return (num & ((1 << bit) - 1));
    }

    static int clearMSBExclusive(int num, int bit) {
        return (num & ((1 << (bit + 1)) - 1));
    }

    static int convertToLowerCase(int num) {
        return (num | (1 << 5));
    }

    static int convertToUpperCase(int num) {
        return (num & (~(1 << 5)));
    }

    static int convertToLowerCaseWithSpace(int num) {
        return (num | (' '));
    }

    static int convertToUpperCaseWithSpace(int num) {
        return (num & (~(' ')));
    }

    static int convertToUpperCaseWithUnderscore(int num) {
        return (num & ('_'));
    }

    static void swapNumbers(int num1, int num2) {
        System.out.println("Num1 : " + num1 + " and Num2 is : " + num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("Num1 : " + num1 + " and Num2 is : " + num2);
    }

    static void printUniqueElement(int arr[]) {
        int l = arr.length;
        int res = 0;
        for (int i = 0; i < l; i++) {
            res = res ^ arr[i];
        }
        System.out.println(res);
    }

    static void printTwoUniqueElement(int arr[]) {
        int l = arr.length;
        int res = 0;
        for (int i = 0; i < l; i++) {
            res = res ^ arr[i];
        }

        int setBitPos = 0;
        int bit = 0;
        while (res != 0) {
            if (((res >> bit) & 1) != 0) {
                setBitPos = bit;
                break;
            }
            bit++;
        }

        int res1 = 0;
        for (int i = 0; i < l; i++) {
            if (((arr[i] >> setBitPos) & 1) != 0) {
                res1 = res1 ^ arr[i];
            }
        }

        int num1 = res ^ res1;
        int num2 = res ^ num1;

        System.out.println("Num1 : " + num1 + " and Num2 is : " + num2);
    }
}
