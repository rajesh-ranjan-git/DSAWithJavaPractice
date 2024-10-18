import java.util.Arrays;

public class StringProblems {
    public static void main(String[] args) {
        // printAllSubstrings("Rajesh"); // n(n + 1)/2 substring, +1 if including empty string, Time Complexity : O(n^2)
        // reverseString("Rajesh"); // Time Complexity : O(n)
        // reverseString1("Rajesh"); // Time Complexity : O(n)
        // reverseString2("Rajesh"); // Time Complexity : O(n / 2) = O(n)
        // reverseString3("Rajesh"); // Time Complexity : O(n)
        // checkPalindrome("Naman"); // Time Complexity : O(n / 2) = O(n)
        // checkPalindrome1("abcba"); // Time Complexity : O(n / 2) = O(n)
        // reverseWords("     Reverse these    words in the sentence.              ");
        // reverseWords1("     Reverse these    words in the sentence.              ");
        // reverseWords2("     Reverse these    words in the sentence.              ");
        // checkAnagrams("geeksforgeeks", "forgeeksgeeks"); // Time Complexity : O(n)
        // checkAnagrams1("geeksforgeeks", "forgeeksgeeks"); // Time Complexity : O(n)
        // reverseCharOfWordsInString_557("     Reverse characters of these    words in the sentence.              ");
        // reverseCharOfWordsInString_557("     Reverse characters of these words in the sentence.              ");
        reverseCharOfWordsInString_557_1("     Reverse characters of    these words in the sentence.              "); // Time Complexity : O(n*k)
    }
    
    static void printAllSubstrings(String str) {
        for (int startingIndex = 0; startingIndex < str.length(); startingIndex++) {
            for (int endIndex = startingIndex + 1; endIndex <= str.length(); endIndex++) {
                System.out.println(str.substring(startingIndex, endIndex));
            }
        }
    }

    static void reverseString(String str) {
        for (int i = str.length(); i > 0; i--) {
            System.out.print(str.substring(i - 1, i));
        }
    }

    static void reverseString1(String str) {
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i);
        }
        System.out.println(ans);
    }

    static void reverseString2(String str) {
        int n = str.length();
        StringBuilder ans = new StringBuilder(str);
        for (int i = 0; i < n / 2; i++) {
            char startingChar = str.charAt(i);
            char endingChar = str.charAt(n - 1 - i);
            ans.setCharAt(n - 1 - i, startingChar);
            ans.setCharAt(i, endingChar);
        }

        System.out.println(ans.toString());
    }

    static void reverseString3(String str) {
        int n = str.length();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char startingChar = charArr[i];
            char endingChar = charArr[n - 1 - i];
            charArr[n - 1 - i] = startingChar;
            charArr[i] = endingChar;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(charArr[i]);
        }
    }

    static void checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char startingChar = str.toLowerCase().charAt(start);
            char endingChar = str.toLowerCase().charAt(end);
            if (startingChar != endingChar) {
                System.out.println(str + " is not Palindrome.");
                return;
            }
            start++;
            end--;
        }

        System.out.println(str + " is Palindrome.");
    }
    
    static void checkPalindrome1(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            char startingChar = str.toLowerCase().charAt(i);
            char endingChar = str.toLowerCase().charAt(n - 1 - i);
            if (startingChar != endingChar) {
                System.out.println(str + " is not Palindrome.");
                return;
            }
        }

        System.out.println(str + " is Palindrome.");
    }
    
    static void reverseWords(String str) {
        String[] wordsArr = str.trim().split(" ");
        for (int i = wordsArr.length - 1; i >= 0; i--) {
            if (wordsArr[i].length() != 0) {
                if (i != 0) {
                    System.out.print(wordsArr[i] + " ");
                } else {
                    System.out.print(wordsArr[i]);
                }
            }
        }
    }

    static void reverseWords1(String str) {
        String[] wordsArr = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = wordsArr.length - 1; i >= 0; i--) {
            if (wordsArr[i].length() != 0) {
                if (res.length() == 0) {
                    res.append(wordsArr[i]);
                } else {
                    res.append(" ");
                    res.append(wordsArr[i]);
                }
            }
        }
        System.out.println(res.toString());
    }

    static void reverseWords2(String str) {
        StringBuilder res = new StringBuilder();
        int startIdx = str.length() - 1;
        while (startIdx >= 0) {
            while (startIdx >= 0 && str.charAt(startIdx) == ' ') {
                startIdx--;
            }
            if (startIdx < 0) {
                break;
            }
            int endIdx = startIdx;
            while (startIdx >= 0 && str.charAt(startIdx) != ' ') {
                startIdx--;
            }

            // Word
            if (res.length() == 0) {
                res.append(str.substring(startIdx + 1, endIdx + 1));
            } else {
                res.append(" ");
                res.append(str.substring(startIdx + 1, endIdx + 1));
            }
        }
        System.out.println(res.toString());
    }

    static void checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println(str1 + " & " + str2 + " are not anagrams.");
            return;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < str1.length(); i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println(str1 + " & " + str2 + " are not anagrams.");
                return;
            }
        }

        System.out.println(str1 + " & " + str2 + " are anagrams.");
    }

    static void checkAnagrams1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println(str1 + " & " + str2 + " are not anagrams.");
            return;
        }

        int len = str1.length();
        int[] freq = new int[26];
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < len && idx2 < len) {
            char char1 = str1.charAt(idx1);
            int freqIdx1 = char1 - 97;

            freq[freqIdx1]++;

            char char2 = str2.charAt(idx2);
            int freqIdx2 = char2 - 97;

            freq[freqIdx2]--;

            idx1++;
            idx2++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                System.out.println(str1 + " & " + str2 + " are not anagrams.");
                return;
            }
        }

        System.out.println(str1 + " & " + str2 + " are anagrams.");
    }
    
    static void reverseCharOfWordsInString_557(String str) {
        String[] wordsArr = str.trim().split(" ");
        printArray(wordsArr);
        for (int i = 0; i < wordsArr.length; i++) {
            if (i != wordsArr.length - 1) {
                for (int j = wordsArr[i].length(); j > 0; j--) {
                    System.out.print(wordsArr[i].substring(j - 1, j));
                }
                System.out.print(" ");
            } else {
                for (int j = wordsArr[i].length(); j > 0; j--) {
                    System.out.print(wordsArr[i].substring(j - 1, j));
                }
            }
        }
    }

    static void reverseCharOfWordsInString_557_1(String str) {
        // Convert to char Array.
        char arr[] = str.toCharArray();
        int len = arr.length;
        int startPointer = 0;

        for (int endPointer = 0; endPointer <= len; endPointer++) {
            // Word will end at space or at end of string
            if (endPointer == len || arr[endPointer] == ' ') {
                reverse(arr, startPointer, endPointer - 1);
                //first char of next word
                startPointer = endPointer + 1;
            }
        }

        System.out.println(new String(arr));
    }

    static void reverse(char[] arr, int startPointer, int endPointer) {
        while (startPointer < endPointer) {
            char temp = arr[startPointer];
            arr[startPointer] = arr[endPointer];
            arr[endPointer] = temp;
            startPointer++;
            endPointer--;
        }
    }

    static void printArray(String arr[]) {
        System.out.print("arr : [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
        System.out.println();
    }
}
