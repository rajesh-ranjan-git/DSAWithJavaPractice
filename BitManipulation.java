public class BitManipulation {
    public static void main(String[] args) {
        printBits(67);
        System.out.println(isBitSet(20, 4));;
        findOddEven(20);
        printBits(findIthBit(20, 4));
        printBits(setIthBit(32, 2));
        printBits(toggleBit(33, 4));
        printBits(unSetBit(89, 3));
        isPowerOf2(42);
        printBits(unSetRightMostBit(48));
        noOfSetBits(67);
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
}
