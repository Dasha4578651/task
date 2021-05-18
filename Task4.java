import java.util.Stack;
import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(bessi(10, 7, "hello my name is Bessie and this is my essay"));

        System.out.println("split(\"()()()\") -> " + split("()()()"));
        System.out.println("split(\"((()))\") -> " + split("((()))"));
        System.out.println("split(\"((()))(())()()(()())\") -> " + split("((()))(())()()(()())"));
        System.out.println("split(\"((())())(()(()()))\") -> " + split("((())())(()(()()))"));

        System.out.println("toCamelCase(\"hello_edabit\") -> " + toCamelCase("hello_edabit"));
        System.out.println("toSnakeCase(\"helloEdabit\") -> " + toSnakeCase("helloEdabit"));
        System.out.println("toCamelCase(\"is_modal_open\") -> " + toCamelCase("is_modal_open"));
        System.out.println("toSnakeCase(\"getColor\") -> " + toSnakeCase("getColor"));

        double[] test1 = { 9, 17, 30, 1.5 };
        double[] test2 = { 16, 18, 30, 1.8 };
        double[] test3 = { 13.25, 15, 30, 1.5 };

        System.out.println("overTime([9, 17, 30, 1.5]) -> " + overTime(test1));
        System.out.println("overTime([16, 18, 30, 1.8]) -> " + overTime(test2));
        System.out.println("overTime([13.25, 15, 30, 1.5]) -> " + overTime(test3));

        System.out.println("BMI(\"205 pounds\", \"73 inches\") -> " + BMI("205 pounds", "73 inches"));
        System.out.println("BMI(\"55 kilos\", \"1.65 meters\") -> " + BMI("55 kilos", "1.65 meters"));
        System.out.println("BMI(\"154 pounds\", \"2 meters\") -> " + BMI("154 pounds", "2 meters"));

        System.out.println("bugger(39) -> " + bugger(39));
        System.out.println("bugger(999) -> " + bugger(999));
        System.out.println("bugger(4) -> " + bugger(4));

        System.out.println("toStarShorthand(\"abbcccd\") -> " + toStarShorthand("abbcccd"));
        System.out.println("toStarShorthand(\"77777geff\") -> " + toStarShorthand("77777geff"));
        System.out.println("toStarShorthand(\"abc\") -> " + toStarShorthand("abc"));
        System.out.println("toStarShorthand(\"\") -> " + toStarShorthand(""));

        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and ham.\") -> " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") -> " + doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println("doesRhyme(\"and frequently do?\", \"you gotta move.\") -> " + doesRhyme("and frequently do?", "you gotta move."));

        System.out.println("trouble(451999277, 41177722899) -> " + trouble(451999277L, 41177722899L));
        System.out.println("trouble(1222345, 12345) -> " + trouble(1222345, 12345));
        System.out.println("trouble(666789, 12345667) -> " + trouble(666789, 12345667));
        System.out.println("trouble(33789, 12345337) -> " + trouble(33789, 12345337));

        System.out.println("countUniqueBooks(\"AZYWABBCATTTA\", \'A\') -> " + countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(
                "countUniqueBooks(\"$AA$BBCATT$C$$B$\", \'$\') -> " + countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println("countUniqueBooks(\"ZZABCDEF\", \'Z\') -> " + countUniqueBooks("ZZABCDEF", 'Z'));
    }

    public static String bessi(int n, int k, String str) {
        String ret = "";

        String[] arr = str.split(" ");

        int added = 0;
        String temp_str = "";
        for (int i = 0; i < n;) {
            String s = arr[i];
            if (temp_str.length() + s.length() - added <= k) {
                temp_str += s + ' ';
                added++;
                i++;
            } else {
                added = 0;
                ret += temp_str + '\n';
                temp_str = "";
            }
        }
        ret += temp_str + '\n';
        return ret;
    }

    public static ArrayList<String> split(String str) {
        ArrayList<String> ret = new ArrayList<>();
        Stack<Character> bracketAnalizer = new Stack<>();

        String temp = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                temp += '(';
                bracketAnalizer.push('(');
            }
            if (str.charAt(i) == ')') {
                temp += ')';
                bracketAnalizer.pop();
            }
            if (bracketAnalizer.empty()) {
                ret.add(temp);
                temp = "";
            }
        }
        return ret;
    }

    public static String toCamelCase(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '_')
                ret += Character.toUpperCase(str.charAt(++i));
            else
                ret += str.charAt(i);
        }
        return ret;
    }
    public static String toSnakeCase(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); ++i) {
            if (Character.isUpperCase(str.charAt(i)) == true)
                ret += "_" + Character.toLowerCase(str.charAt(i));
            else
                ret += str.charAt(i);
        }
        return ret;
    }

    public static String overTime(double[] a) {
        double timeStart = a[0];
        double timeEnd = a[1];
        double hourPay = a[2];
        double multiplyer = a[3];

        if (timeEnd < 17)
            return String.format("$%.2f", (timeEnd - timeStart) * hourPay);
        else
            return String.format("$%.2f", (17 - timeStart) * hourPay + (timeEnd - 17) * hourPay * multiplyer);
    }

    public static String BMI(String input1, String input2) {
        String[] arr1 = input1.split(" ");
        String[] arr2 = input2.split(" ");

        double weight = Double.parseDouble(arr1[0]) * (arr1[1].equals("pounds") ? 1 / 2.20462 : 1);
        double heigth = Double.parseDouble(arr2[0]) * (arr2[1].equals("inches") ? 2.54 / 100 : 1);

        double bmi = weight / (heigth * heigth);

        String res = null;
        if (bmi < 18.5)
            res = "Underweight";
        else if (bmi >= 18.5 && bmi < 24.9)
            res = "Normal weight";
        else
            res = "Overweight";
        return String.format("%.1f %s", bmi, res);
    }

    public static int bugger(int n) {
        int new_n = n;
        int iteration = 0;
        while (new_n > 10) {
            int temp = new_n;
            new_n = 1;
            while (temp > 0) {
                new_n *= temp % 10;
                temp /= 10;
            }
            iteration++;
        }
        return iteration;
    }

    public static String toStarShorthand(String str) {
        String ret = "";
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            ret += str.charAt(i);
            int j = i + 1;
            if (j < strLen)
                for (; j < strLen && str.charAt(j) == str.charAt(i); j++)
                    ;
            if (j - i > 1) {
                ret += "*" + Integer.toString(j - i);
                i = j - 1;
            }
        }
        return ret;
    }

    public static boolean doesRhyme(String str1, String str2) {
        final String vowels = "aeiouy";

        String[] arr1 = str1.split(" "); // getting the array of words
        String[] arr2 = str2.split(" ");
        String lastWord1 = arr1[arr1.length - 1]; // get the last word from string
        String lastWord2 = arr2[arr2.length - 1];

        String vowels1 = "";
        String vowels2 = "";
        for (int i = 0; i < lastWord1.length(); i++) {
            int index = vowels.indexOf(Character.toLowerCase(lastWord1.charAt(i)));
            if (index != -1)
                vowels1 += vowels.charAt(index);
        }
        for (int i = 0; i < lastWord2.length(); i++) {
            int index = vowels.indexOf(Character.toLowerCase(lastWord2.charAt(i)));
            if (index != -1)
                vowels2 += vowels.charAt(index);
        }

        return vowels1.equals(vowels2);
    }

    public static boolean trouble(long n1, long n2) {
        String num1 = Long.toString(n1);
        String num2 = Long.toString(n2);

        int start = 0;
        int numLen = num1.length();
        for (int i = 0; i < numLen; i++) {
            int j = i + 1;
            if (j < numLen - 1) {
                for (; num1.charAt(j) == num1.charAt(i) && j < numLen; j++)
                    ;
                if (j - i == 3)
                    start = i;
            }
        }
        int index = num2.indexOf(num1.charAt(start));
        int i = index;
        for (; i < num2.length() && num1.charAt(start) == num2.charAt(i); i++)
            ;
        return (i - index) == 2;
    }

    public static int countUniqueBooks(String input, char delimiter) {
        int count = 0;

        int first = 0;
        int second = 0;
        while ((first = input.indexOf(delimiter, second)) != -1) {
            String temp = "";
            second = input.indexOf(delimiter, first + 1);
            for (int i = first + 1; i < second; i++) {
                char c = input.charAt(i);
                if (temp.indexOf(c) == -1)
                    temp += c;
            }
            count += temp.length();
            second++;
        }
        return count;
    }
}
