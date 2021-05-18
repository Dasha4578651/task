import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("repeat(\"mice\", 5) -> " + repeat("mice", 5));
        System.out.println("repeat(\"hello\", 3) -> " + repeat("hello", 3));
        System.out.println("repeat(\"stop\", 1) -> " + repeat("stop", 1));

        int[] first_test = { 10, 4, 1, 4, -10, -50, 32, 21 };
        int[] second_test = { 44, 32, 86, 19 };
        System.out.println("differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) -> " + differenceMaxMin(first_test));
        System.out.println("differenceMaxMin([44, 32, 86, 19]) -> " + differenceMaxMin(second_test));

        int[] test11 = { 1, 3 };
        int[] test12 = { 1, 2, 3, 4 };
        int[] test13 = { 1, 5, 6 };
        int[] test14 = { 1, 1, 1 };
        int[] test15 = { 9, 2, 2, 5 };

        System.out.println("isAvgWhole([1, 3]) -> " + isAvgWhole(test11));
        System.out.println("isAvgWhole([1, 2, 3, 4]) -> " + isAvgWhole(test12));
        System.out.println("isAvgWhole([1, 5, 6]) -> " + isAvgWhole(test13));
        System.out.println("isAvgWhole([1, 1, 1]) -> " + isAvgWhole(test14));
        System.out.println("isAvgWhole([9, 2, 2, 5]) -> " + isAvgWhole(test15));

        int[] test21 = { 1, 2, 3 };
        int[] test22 = { 1, -2, 3 };
        int[] test23 = { 3, 3, -2, 408, 3, 3 };

        System.out.println("cumulativeSum([1, 2, 3]) -> " + Arrays.toString(cumulativeSum(test21)));
        System.out.println("cumulativeSum([1, -2, 3]) -> " + Arrays.toString(cumulativeSum(test22)));
        System.out.println("cumulativeSum([3, 3, -2, 408, 3, 3]) -> " + Arrays.toString(cumulativeSum(test23)));

        System.out.println("getDecimalPlaces(\"43.20\") -> " + getDecimalPlaces("43.20"));
        System.out.println("getDecimalPlaces(\"400\") -> " + getDecimalPlaces("400"));
        System.out.println("getDecimalPlaces(\"3.1\") -> " + getDecimalPlaces("3.1"));

        System.out.println("Fibonacci(3) -> " + Fibonacci(3));
        System.out.println("Fibonacci(7) -> " + Fibonacci(7));
        System.out.println("Fibonacci(12) -> " + Fibonacci(12));

        System.out.println("isValid(\"59001\") -> " + isValid("59001"));
        System.out.println("isValid(\"853a7\") -> " + isValid("853a7"));
        System.out.println("isValid(\"732 32\") -> " + isValid("732 32"));
        System.out.println("isValid(\"393939\") -> " + isValid("393939"));

        System.out.println("isStrangePair(\"ratio\", \"orator\") -> " + isStrangePair("ratio", "orator"));
        System.out.println("isStrangePair(\"sparkling\", \"groups\") -> " + isStrangePair("sparkling", "groups"));
        System.out.println("isStrangePair(\"bush\", \"hubris\") -> " + isStrangePair("bush", "hubris"));
        System.out.println("isStrangePair(\"\", \"\") -> " + isStrangePair("", ""));

        System.out.println("isPrefix(\"automation\", \"auto-\") -> " + isPrefix("automation", "auto-"));
        System.out.println("isSuffix(\"arachnophobia\", \"-phobia\") -> " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("isPrefix(\"retrospect\", \"sub-\") -> " + isPrefix("retrospect", "sub-"));
        System.out.println("isSuffix(\"vocation\", \"-logy\") -> " + isSuffix("vocation", "-logy"));

        System.out.println("boxSeq(0) -> " + boxSeq(0));
        System.out.println("boxSeq(1) -> " + boxSeq(1));
        System.out.println("boxSeq(2) -> " + boxSeq(2));
        System.out.println("boxSeq(5) -> " + boxSeq(5));
    }

    public static String repeat(String str, int n) {
        String ret = "";
        for (int i = 0; i < str.length(); ++i)
            for (int j = 0; j < n; ++j)
                ret += str.charAt(i);
        return ret;
    }

    public static int differenceMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        return max - min;
    }

    public static boolean isAvgWhole(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        double avg = (double) sum / (double) arr.length;
        return Math.floor(avg) == avg;
    }

    public static int[] cumulativeSum(int[] arr) {
        int ret[] = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            int sum = 0;
            for (int j = 0; j <= i; ++j)
                sum += arr[j];
            ret[i] = sum;
        }
        return ret;
    }

    public static int getDecimalPlaces(String str) {
        int find_dot = str.indexOf('.');
        if (find_dot == -1)
            return 0;
        return str.length() - 1 - find_dot;
    }

    public static int Fibonacci(int n) {
        if (n == 1 || n == 0)
            return 1;
        else
            return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public static boolean isValid(String str) {
        if (str.length() == 5) {
            for (int i = 0; i < str.length(); ++i) {
                if (!Character.isDigit(str.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    public static boolean isStrangePair(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0)
            return true;
        else if (str1.length() == 0 && str2.length() != 0 || str1.length() != 0 && str2.length() == 0)
            return false;

        boolean a = str1.charAt(0) == str2.charAt(str2.length() - 1);
        boolean b = str1.charAt(str1.length() - 1) == str2.charAt(0);
        return a && b;
    }

    public static boolean isSuffix(String str, String suffix) {
        for (int i = suffix.length() - 2, j = str.length() - 1; i >= 0; --i, --j) {
            if (str.charAt(j) == suffix.charAt(i))
                return false;
        }
        return true;
    }
    public static boolean isPrefix(String str, String prefix) {
        for (int i = 1; i < prefix.length() - 1; ++i) {
            if (str.charAt(i) != prefix.charAt(i))
                return false;
        }
        return true;
    }

    public static int boxSeq(int n) {
        int ret = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0)
                ret += 3;
            else
                ret -= 1;
        }
        return ret;
    }
}
