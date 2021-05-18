import java.util.regex.*;
import java.util.HashMap;
import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("bell(1) -> " + bell(1));
        System.out.println("bell(2) -> " + bell(2));
        System.out.println("bell(3) -> " + bell(3));

        System.out.println("translateWord(\"flag\") -> " + translateWord("flag"));
        System.out.println("translateWord(\"Apple\") -> " + translateWord("Apple"));
        System.out.println("translateWord(\"button\") -> " + translateWord("button"));
        System.out.println("translateWord(\"\") -> " + translateWord(""));
        System.out.println("translateSentence(\"I like, to eat honey waffles.\") -> " + translateSentence("I like, to eat honey waffles."));
        System.out.println("translateSentence(\"Do you think it, is going to rain today?\") -> " + translateSentence("Do you think it, is going to rain today?"));

        System.out.println("validColor(\"rgb(0,0,0)\") -> " + validColor("rgb(0,0,0)"));
        System.out.println("validColor(\"rgb(0,,0)\") -> " + validColor("rgb(0,,0)"));
        System.out.println("validColor(\"rgb(255,256,255)\") -> " + validColor("rgb(255,256,255)"));
        System.out.println("validColor(\"rgba(0,0,0,0.123456789)\") -> " + validColor("rgba(0,0,0,0.123456789)"));

        String[] a = { "b" };
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", a));
        System.out.println(stripUrlParams("https://edabit.com", a));

        System.out.println("getHashTags(\"How the Avocado Became the Fruit of the Global Trade\") -> " + Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println("getHashTags(\"Why You Will Probably Pay More for Your Christmas Tree This Year\") -> " + Arrays.toString(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")));
        System.out.println("getHashTags(\"Hey Parents, Surprise, Fruit Juice Is Not Fruit\") -> " + Arrays.toString(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println("getHashTags(\"Visualizing Science\") -> " + Arrays.toString(getHashTags("Visualizing Science")));

        System.out.println("ulam(4) -> " + ulam(4));
        System.out.println("ulam(9) -> " + ulam(9));
        System.out.println("ulam(206) -> " + ulam(206));

        System.out.println("longestNonrepeatingSubstring(\"abcabcbb\") -> " + longestNonrepeatingSubstring("abcabcbb"));
        System.out.println("longestNonrepeatingSubstring(\"aaaaaa\") -> " + longestNonrepeatingSubstring("aaaaaa"));
        System.out.println("longestNonrepeatingSubstring(\"abcde\") -> " + longestNonrepeatingSubstring("abcde"));
        System.out.println("longestNonrepeatingSubstring(\"abcda\") -> " + longestNonrepeatingSubstring("abcda"));

        System.out.println("convertToRoman(2) -> " + convertToRoman(2));
        System.out.println("convertToRoman(12) -> " + convertToRoman(12));
        System.out.println("convertToRoman(16) -> " + convertToRoman(16));

        System.out.println("formula(\"6 * 4 = 24\") -> " + formula("6 * 4 = 24"));
        System.out.println("formula(\"18 / 17 = 2\") -> " + formula("18 / 17 = 2"));
        System.out.println("formula(\"16 * 10 = 160 = 14 + 120\") -> " + formula("16 * 10 = 160 = 14 + 120"));

        System.out.println("palindromedescendant(11211230) -> " + palindromedescendant(11211230));
        System.out.println("palindromedescendant(13001120) -> " + palindromedescendant(13001120));
        System.out.println("palindromedescendant(23336014) -> " + palindromedescendant(23336014));
        System.out.println("palindromedescendant(11) -> " + palindromedescendant(11));
    }

    public static int bell(int n) {
        int[][] pirc = new int[n][n];

        int edge = 0;
        int number = 1;
        pirc[0][0] = number;
        for (int i = 1; i < n; i++) {
            pirc[i][0] = pirc[i - 1][edge];
            for (int j = 0; j < i; j++)
                pirc[i][j + 1] = pirc[i][j] + pirc[i - 1][j];
            edge++;
            number = pirc[i][edge];
        }
        return number;
    }

    public static String translateSentence(String string) {
        final Pattern regexString = Pattern.compile("[A-Za-z]+|[ .,?]");
        int pos = 0;
        Matcher matcher = regexString.matcher(string);
        String ret = "";
        while (matcher.find(pos) == true) {
            String matchedString = string.substring(matcher.start(), matcher.end());
            ret += translateWord(matchedString);
            pos = matcher.end();
        }
        return ret;
    }

    public static String translateWord(String string) {
        final String vowelsString = "AEIOUYaeiouy";
        final String consonantString = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";

        if (string.equals("") == true)
            return "";

        String ret = "";
        char firstChar = string.charAt(0);
        boolean isStartCapital = Character.isUpperCase(firstChar);
        string = string.toLowerCase();
        if (vowelsString.indexOf(firstChar) != -1)
            string = startVowel(string, vowelsString);
        else if (consonantString.indexOf(firstChar) != -1)
            string = startConsonant(string, consonantString);
        if (isStartCapital)
            string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
        ret += string;
        return ret;
    }

    private static String startVowel(String str, final String vowelsString) {
        return str + "yay";
    }

    private static String startConsonant(String str, final String consonantString) {
        String begin = "";
        int i = 0;
        for (; i < str.length() && consonantString.indexOf(str.charAt(i)) != -1; i++)
            begin += str.charAt(i);
        return str.substring(i) + begin + "ay";
    }

    public static boolean validColor(String str) {
        int pos = str.indexOf("rgb");
        if (pos == -1)
            return false;

        boolean isRgba = (str.charAt(pos + 1) == 'a');
        int args = 3 + (isRgba ? 1 : 0);
        int bracketStart = str.indexOf('(');
        int bracketEnd = str.indexOf(')');
        if (bracketStart == -1 || bracketEnd == -1)
            return false;

        String[] colorsString = str.substring(bracketStart + 1, bracketEnd).split(",");
        if (colorsString.length != args)
            return false;

        for (String s : colorsString)
            if (s.equals(""))
                return false;

        int r = Integer.parseInt(colorsString[0]);
        int g = Integer.parseInt(colorsString[1]);
        int b = Integer.parseInt(colorsString[2]);

        if (r < 0 || r > 255)
            return false;
        if (g < 0 || g > 255)
            return false;
        if (b < 0 || b > 255)
            return false;

        if (isRgba) {
            double a = Double.parseDouble(colorsString[3]);
            if (a < 0 || a > 1)
                return false;
        }
        return true;
    }

    private static HashMap<String, String> parseParams(String paramsString) {
        String[] params = paramsString.split("&");
        HashMap<String, String> newParams = new HashMap<String, String>();
        for (String param : params) {
            int valSeparatorInteger = param.indexOf('=');
            String name = param.substring(0, valSeparatorInteger);
            String arg = param.substring(valSeparatorInteger + 1);
            newParams.put(name, arg);
        }
        return newParams;
    }

    public static String stripUrlParams(String str) {
        int argSeparatorInteger = str.indexOf('?');
        String urlString = str.substring(0, argSeparatorInteger);
        String paramsString = str.substring(urlString.length() + 1);

        HashMap<String, String> paramsMap = parseParams(paramsString);

        String ret = new String(urlString);
        if (paramsMap.size() == 0)
            return ret;
        ret += '?';
        Object[] keyArray = (paramsMap.keySet().toArray());
        for (int i = 0; i < keyArray.length; i++) {
            ret += keyArray[i];
            ret += '=';
            ret += paramsMap.get(keyArray[i]);
            if (i + 1 < keyArray.length)
                ret += '&';
        }
        return ret;
    }

    public static String stripUrlParams(String str, String[] args) {
        int argSeparatorInteger = str.indexOf('?');
        if (argSeparatorInteger == -1)
            return str;
        String urlString = str.substring(0, argSeparatorInteger);
        String paramsString = str.substring(urlString.length() + 1);

        HashMap<String, String> paramsMap = parseParams(paramsString);

        HashMap<String, String> newHashMap = new HashMap<>();
        for (String key : paramsMap.keySet()) {
            boolean finded = false;
            for (int j = 0; j < args.length; j++) {
                if (key.equals(args[j])) {
                    finded = true;
                    break;
                }
            }
            if (finded == false)
                newHashMap.put(key, paramsMap.get(key));
        }

        String ret = new String(urlString);
        if (newHashMap.size() == 0)
            return ret;
        ret += '?';
        Object[] keyArray = (newHashMap.keySet().toArray());
        for (int i = 0; i < keyArray.length; i++) {
            ret += keyArray[i];
            ret += '=';
            ret += newHashMap.get(keyArray[i]);
            if (i + 1 < keyArray.length)
                ret += '&';
        }
        return ret;
    }

    public static String[] getHashTags(String string) {
        string = string.replaceAll("[.,?!]", "");
        String[] words = string.split(" ");
        String[] tagsArray = null;
        if (words.length == 1) {
            tagsArray = new String[1];
            tagsArray[0] = "#" + words[0].toLowerCase();
        } else if (words.length == 2) {
            tagsArray = new String[2];
            int minPos = (words[0].length() > words[1].length() ? 1 : 0);
            int maxPos = (words[0].length() > words[1].length() ? 0 : 1);
            tagsArray[0] = "#" + words[maxPos].toLowerCase();
            tagsArray[1] = "#" + words[minPos].toLowerCase();
        } else {
            tagsArray = new String[3];
            int tagsCount = 0;
            for (int i = 0; i < 3; i++) {
                int maxPos = 0;
                int maxLen = 0;
                for (int j = 0; j < words.length; j++) {
                    int len = words[j].length();
                    if (len > maxLen) {
                        maxLen = len;
                        maxPos = j;
                    }
                }
                tagsArray[tagsCount] = ("#" + words[maxPos]).toLowerCase();
                tagsCount++;
                words[maxPos] = "";
            }
        }
        return tagsArray;
    }

    public static int ulam(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] ulam = new int[n];
        int size = 2;
        ulam[0] = 1;
        ulam[1] = 2;
        for (int i = 3; size < n; i++) {
            int z = 0;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (ulam[j] < ulam[k] && ulam[j] + ulam[k] == i)
                        z++;
                }
            }
            if (z == 1) {
                ulam[size] = i;
                size++;
            }
        }
        return ulam[size - 1];
    }

    public static String longestNonrepeatingSubstring(String str) {
        final int ALPHABET_COUNT = 256;
        byte[] visited = new byte[ALPHABET_COUNT];
        for (int i = 0; i < ALPHABET_COUNT; i++)
            visited[i] = 0;
        int start = 0;
        int end = 0;
        int bestStart = 0;
        int best = 0;
        while (end < str.length()) {
            while (visited[str.charAt(end)] == 1) {
                start++;
                visited[str.charAt(start)] = 0;
            }
            visited[str.charAt(end)] = 1;
            end++;
            if (end - start > best) {
                bestStart = start;
                best = end - start;
            }
        }
        return str.substring(bestStart, bestStart + best);
    }

    public static String convertToRoman(int n) {
        if (n > 3999)
            return "Invalid input";

        final String ONE = "I";
        final String FIVE = "V";
        final String TEN = "X";
        final String FIFTY = "L";
        final String HUNDRED = "C";
        final String FHUNDRED = "D";
        final String THOUSAND = "M";

        int thousandsAmount = n / 1000;
        int hundredsAmount = n / 100 % 10;
        int tensAmount = n / 10 % 10;
        int digitsAmount = n % 10;

        return convertDigit(thousandsAmount, THOUSAND, "", "")
                + convertDigit(hundredsAmount, HUNDRED, FHUNDRED, THOUSAND)
                + convertDigit(tensAmount, TEN, FIFTY, HUNDRED) + convertDigit(digitsAmount, ONE, FIVE, TEN);
    }

    private static String convertDigit(int n, final String current, final String next, final String overNext) {
        String ret = "";
        if (n == 1)
            ret += current;
        else if (n > 1 && n < 4) {
            for (int i = 0; i < n; i++)
                ret += current;
        } else if (n == 4)
            ret += next + current;
        else if (n > 4 && n < 9) {
            ret += next;
            for (int i = 5; i < n; i++)
                ret += current;
        } else if (n == 9)
            ret += current + overNext;
        return ret;
    }

    public static boolean formula(String str) {
        String[] relativeEqv = str.split("=");
        int numberOfExpressions = relativeEqv.length;
        String[][] expressions = new String[numberOfExpressions][];
        int[] vals = new int[numberOfExpressions];
        for (int i = 0; i < relativeEqv.length; i++)
            expressions[i] = relativeEqv[i].split(" ");
        for (int i = 0; i < numberOfExpressions; i++) {
            String[] expr = expressions[i];
            if (expr.length == 2)
                vals[i] = Integer.parseInt(expr[1]);
            else {
                int j = 0;
                for (; j < expr.length; j++)
                    if (expr[j].equals("") == false)
                        break;
                int a = Integer.parseInt(expr[j]);
                int b = Integer.parseInt(expr[j + 2]);
                char operation = expr[j + 1].charAt(0);

                if (operation == '+')
                    vals[i] = a + b;
                else if (operation == '-')
                    vals[i] = a - b;
                else if (operation == '/')
                    vals[i] = a / b;
                else
                    vals[i] = a * b;
            }
        }
        int val = vals[numberOfExpressions - 1];
        for (int i = 0; i < vals.length; i++)
            vals[i] -= val;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean palindromedescendant(long n) {
        String nString = Long.toString(n);
        if (nString.length() == 2 && nString.charAt(0) == nString.charAt(1))
            return true;
        boolean isPalindrome = nString.equals(reverseString(nString));
        if (isPalindrome)
            return true;
        else {
            int pow10 = 1;
            long newLong = 0;
            for (int i = nString.length() - 1; i > 0; i -= 2) {
                int a = nString.charAt(i - 1) - '0';
                int b = nString.charAt(i) - '0';
                newLong += (a + b) * pow10;
                pow10 *= 10;
            }
            return palindromedescendant(newLong);
        }
    }

    private static String reverseString(String s) {
        String ret = "";
        for (int i = s.length() - 1; i >= 0; --i)
            ret += s.charAt(i);
        return ret;
    }
}
