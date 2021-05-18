import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("solutions(1, 0, -1) -> " + solutions(1, 0, -1));
        System.out.println("solutions(1, 0, 0) -> " + solutions(1, 0, 0));
        System.out.println("solutions(1, 0, 1) -> " + solutions(1, 0, 1));

        System.out.println("findZip(\"all zip files are zipped\") -> " + findZip("all zip files are zipped"));
        System.out.println("findZip(\"all zip files are compressed\") -> " + findZip("all zip files are compressed"));

        System.out.println("checkPerfect(6) -> " + checkPerfect(6));
        System.out.println("checkPerfect(28) -> " + checkPerfect(28));
        System.out.println("checkPerfect(496) -> " + checkPerfect(496));
        System.out.println("checkPerfect(12) -> " + checkPerfect(12));
        System.out.println("checkPerfect(97) -> " + checkPerfect(97));

        System.out.println("flipEndChars(\"Cat, dog, and mouse.\") -> " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("flipEndChars(\"ada\") -> " + flipEndChars("ada"));
        System.out.println("flipEndChars(\"Ada\") -> " + flipEndChars("Ada"));
        System.out.println("flipEndChars(\"z\") -> " + flipEndChars("z"));

        System.out.println("isValidHexCode(\"#CD5C5C\") -> " + isValidHexCode("#CD5C5C"));
        System.out.println("isValidHexCode(\"#EAECEE\") -> " + isValidHexCode("#EAECEE"));
        System.out.println("isValidHexCode(\"#eaecee\") -> " + isValidHexCode("#eaecee"));
        System.out.println("isValidHexCode(\"#CD5C58C\") -> " + isValidHexCode("#CD5C58C"));
        System.out.println("isValidHexCode(\"#CD5C5Z\") -> " + isValidHexCode("#CD5C5Z"));
        System.out.println("isValidHexCode(\"#CD5C&C\") -> " + isValidHexCode("#CD5C&C"));
        System.out.println("isValidHexCode(\"CD5C5C\") -> " + isValidHexCode("CD5C5C"));

        int[] test1_1 = { 1, 3, 4, 4, 4 };
        int[] test1_2 = { 2, 5, 7 };
        int[] test2_1 = { 9, 8, 7, 6 };
        int[] test2_2 = { 4, 4, 3, 1 };
        int[] test3_1 = { 2 };
        int[] test3_2 = { 3, 3, 3, 3 };

        System.out.println("same([1, 3, 4, 4, 4], [2, 5, 7]) -> " + same2(test1_1, test1_2));
        System.out.println("same([9, 8, 7, 6], [4, 4, 3, 1]) -> " + same2(test2_1, test2_2));
        System.out.println("same([2], [3, 3, 3, 3, 3]) -> " + same2(test3_1, test3_2));

        System.out.println("isKaprekar(3) -> " + isKaprekar(3));
        System.out.println("isKaprekar(5) -> " + isKaprekar(5));
        System.out.println("isKaprekar(297) -> " + isKaprekar(297));

        System.out.println("longestZero(\"01100001011000\") -> " + longestZero("01100001011000"));
        System.out.println("longestZero(\"100100100\") -> " + longestZero("100100100"));
        System.out.println("longestZero(\"11111\") -> " + longestZero("11111"));

        System.out.println("nextPrime(12) -> " + nextPrime(12));
        System.out.println("nextPrime(24) -> " + nextPrime(24));
        System.out.println("nextPrime(11) -> " + nextPrime(11));

        System.out.println("rightTriangle(3, 4, 5) -> " + rightTriangle(3, 4, 5));
        System.out.println("rightTriangle(145, 105, 100) -> " + rightTriangle(145, 105, 100));
        System.out.println("rightTriangle(70, 130, 110) -> " + rightTriangle(70, 130, 110));
    }

    public static int solutions(int a, int b, int c) {
        int val = b * b - 4 * a * c;
        if (val == 0)
            return 1;
        else if (val > 0)
            return 2;
        else
            return 0;
    }

    public static int findZip(String str) {
        int first_pos = str.indexOf("zip");
        int second_pos = str.indexOf("zip", first_pos + 1);
        return second_pos;
    }

    public static boolean checkPerfect(int x) {
        int temp = 0;
        for (int i = 1; i < x; ++i) {
            if (x % i == 0)
                temp += i;
        }
        return temp == x;
    }

    public static String flipEndChars(String str) {
        if (str.length() <= 2)
            return "Incompatible";
        else if (str.charAt(0) == str.charAt(str.length() - 1))
            return "Two's a pair";
        else {
            String ret = "" + str.charAt(str.length() - 1);
            ret += str.substring(1, str.length() - 1);
            ret += str.charAt(0);
            return ret;
        }
    }

    public static boolean isValidHexCode(String str) {
        final String alphabet = "0123456789ABCDEFabcdef";
        if (str.charAt(0) != '#' || str.length() != 6 + 1)
            return false;
        for (int i = 1; i < str.length(); ++i) {
            if (alphabet.indexOf(str.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public static boolean same2(int[] a, int[] b) {
        HashSet<Integer> seta = new HashSet<Integer>();
        HashSet<Integer> setb = new HashSet<Integer>();
        for (int i : a)
            seta.add(i);
        for (int i : b)
            setb.add(i);
        return seta.size() == setb.size();
    }

    public static boolean isKaprekar(int n) {
        int temp = n * n;
        String num = Integer.toString(temp);

        String left = null;
        String right = null;

        int len = num.length();
        if (len % 2 == 0) {
            left = num.substring(0, len / 2);
            right = num.substring(len / 2);
        } else {
            left = num.substring(0, (len - 1) / 2);
            right = num.substring((len - 1) / 2);
        }

        if (left.equals(""))
            left = "0";
        if (right.equals(""))
            right = "0";

        return Integer.parseInt(left) + Integer.parseInt(right) == n;
    }

    public static String longestZero(String str) {
        int longest = 0;
        int start = 0;

        int len = str.length() - 1;
        for (int i = 0; i < len;) {
            if (str.charAt(i) == '0') {
                int temp_start = i;
                int temp_len = 0;
                for (; str.charAt(i) == '0' && i < len; ++i, ++temp_len)
                    ;
                if (longest < temp_len) {
                    longest = temp_len;
                    start = temp_start;
                }
            } else
                i++;
        }

        return str.substring(start, start + longest);
    }

    public static int nextPrime(int n) {
        if (isPrime(n) == true)
            return n;
        else {
            n++;
            while (isPrime(n) == false)
                n++;
            return n;
        }
    }
    public static boolean isPrime(int n) {
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i < n; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean rightTriangle(int x, int y, int z) {
        boolean first_rule = (x * x == (y * y + z * z));
        boolean second_rule = (y * y == (x * x + z * z));
        boolean third_rule = (z * z == (x * x + y * y));
        return first_rule || second_rule || third_rule;
    }
}
