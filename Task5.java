import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class Task5 {
    public static void main(String[] args) {
        int[] test = { 72, 33, -73, 84, -12, -3, 13, -13, -68 };

        System.out.println("encrypt(\"Hello\") -> " + Arrays.toString(encrypt("Hello")));
        System.out.println("decrypt([ 72, 33, -73, 84, -12, -3, 13, -13, -68 ]) -> " + decrypt(test));
        System.out.println("encrypt(\"Sunshine\") -> " + Arrays.toString(encrypt("Sunshine")));

        System.out.println("canMove(\"Rook\", \"A8\", \"H8\") -> " + canMove("Rook", "A8", "H8"));
        System.out.println("canMove(\"Bishop\", \"A7\", \"G1\") -> " + canMove("Bishop", "A7", "G1"));
        System.out.println("canMove(\"Queen\", \"C4\", \"D6\") -> " + canMove("Queen", "C4", "D6"));

        System.out.println("sumDigProd(16, 28) -> " + sumDigProd(16, 28));
        System.out.println("sumDigProd(0) -> " + sumDigProd(0));
        System.out.println("sumDigProd(1, 2, 3, 4, 5, 6) -> " + sumDigProd(1, 2, 3, 4, 5, 6));

        System.out.println("canComplete(\"butl\", \"beautiful\") -> " + canComplete("butl", "beautiful"));
        System.out.println("canComplete(\"butlz\", \"beautiful\") -> " + canComplete("butlz", "beautiful"));
        System.out.println("canComplete(\"tulb\", \"beautiful\") -> " + canComplete("bbutl", "beautiful"));
        System.out.println("canComplete(\"bbutl\", \"beautiful\") -> " + canComplete("tulb", "beautiful"));

        String[] test1 = { "toe", "ocelot", "maniac" };
        String[] test2 = { "many", "carriage", "emit", "apricot", "animal" };
        String[] test3 = { "hoops", "chuff", "bot", "bottom" };

        System.out.println("sameVowelGroup([\"toe\", \"ocelot\", \"maniac\"]) -> " + sameVowelGroup(test1));
        System.out.println("sameVowelGroup([\"many\", \"carriage\", \"emit\", \"apricot\", \"animal\"]) -> " + sameVowelGroup(test2));
        System.out.println("sameVowelGroup([\"hoops\", \"chuff\", \"bot\", \"bottom\"]) -> " + sameVowelGroup(test3));

        System.out.println("validateCard(1234567890123456) -> " + validateCard(1234567890123456L));
        System.out.println("validateCard(1234567890123452) -> " + validateCard(1234567890123452L));

        System.out.println("numToEng(0) -> " + numToEng(0));
        System.out.println("numToEng(18) -> " + numToEng(18));
        System.out.println("numToEng(126) -> " + numToEng(126));
        System.out.println("numToEng(909) -> " + numToEng(909));

        System.out.println("getSha256Hash(\"password123\") -> " + getSha256Hash("password123"));
        System.out.println("getSha256Hash(\"Fluffy@home\") -> " + getSha256Hash("Fluffy@home"));
        System.out.println("getSha256Hash(\"Hey dude!\") -> " + getSha256Hash("Hey dude!"));

        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));

        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
        System.out.println(hexLattice(37));
    }

    public static int[] encrypt(String text) {
        int[] encrypted = new int[text.length()];
        int dependecy = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            encrypted[i] = c - dependecy;
            dependecy = (int) c;
        }
        return encrypted;
    }

    public static String decrypt(int[] input) {
        String temp = "";
        int dependecy = 0;
        for (int i = 0; i < input.length; i++) {
            char c = (char) (input[i] + dependecy);
            temp += c;
            dependecy = c;
        }
        return temp;
    }

    public static boolean canMove(String figure, String pos1, String pos2) {
        switch (figure) {
            case "Pawn":
                return Pawn.checkMove(pos1, pos2);
            case "Knight":
                return Knight.checkMove(pos1, pos2);
            case "Bishop":
                return Bishop.checkMove(pos1, pos2);
            case "Rook":
                return Rook.checkMove(pos1, pos2);
            case "Queen":
                return Queen.checkMove(pos1, pos2);
            case "King":
                return King.checkMove(pos1, pos2);
            default:
                System.out.println("Undefined figure");
                return false;
        }
    }

    private static class Pawn {
        public static boolean checkMove(String pos1, String pos2) {
            char literal1 = pos1.charAt(0);
            int digit1 = pos1.charAt(1) - '0';

            char literal2 = pos2.charAt(0);
            int digit2 = pos2.charAt(1) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if ((difference_digit == 2 || difference_digit == 1) && difference_literal == 0)
                return true;
            return false;
        }
    }

    private static class Knight {
        public static boolean checkMove(String pos1, String pos2) {
            char literal1 = pos1.charAt(0);
            int digit1 = pos1.charAt(1) - '0';

            char literal2 = pos2.charAt(0);
            int digit2 = pos2.charAt(1) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if (Math.abs(difference_digit) == 2 && Math.abs(difference_literal) == 1)
                return true;

            return false;
        }
    }

    private static class Bishop {
        public static boolean checkMove(String pos1, String pos2) {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';

            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if (Math.abs(difference_digit) == Math.abs(difference_literal))
                return true;
            return false;
        }
    }

    private static class Rook {
        public static boolean checkMove(String pos1, String pos2) {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';

            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if ((difference_digit == 0 && difference_literal < 8) || (difference_digit < 8 && difference_literal == 0))
                return true;
            return false;
        }
    }

    private static class Queen {
        public static boolean checkMove(String pos1, String pos2) {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';

            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if ((difference_digit == 0 && difference_literal < 8) || (difference_digit < 8 && difference_literal == 0)
                    || (Math.abs(difference_digit) == Math.abs(difference_literal)))
                return true;
            return false;
        }
    }

    private static class King {
        public static boolean checkMove(String pos1, String pos2) {
            char literal1 = pos1.charAt(1);
            int digit1 = pos1.charAt(0) - '0';

            char literal2 = pos2.charAt(1);
            int digit2 = pos2.charAt(0) - '0';

            int difference_literal = literal2 - literal1;
            int difference_digit = digit2 - digit1;
            if (Math.abs(difference_literal) == 1 || Math.abs(difference_digit) == 1)
                return true;
            return false;
        }
    }

    public static boolean canComplete(String str, final String input)
    {
        int pos = -2;
        for(int i = 0; i < str.length(); i++)
        {
            int index = input.indexOf(str.charAt(i));
            if(index <= pos)
                return false;
            else
                pos = index;
        }

        for(int i = 0; i < str.length(); i++)
        {
            if(input.indexOf(str.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public static int sumDigProd(int ... v)
    {
        int ret = 0;
        for(int i = 0; i < v.length; i++) ret += v[i];

        int new_n = ret;
        while(new_n > 10)
        {
            int temp = new_n;
            new_n = 1;
            while(temp > 0)
            {
                new_n *= temp % 10;
                temp /= 10;
            }
        } 
        return new_n;
    }

    public static ArrayList<String> sameVowelGroup(String[] arr)    
    {
        final String VOWELS = "aeiouy";
        HashSet<Character> vowelsSet = new HashSet<>();
        String word = arr[0];

        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int indexInVOWELS = VOWELS.indexOf(c);
            if(indexInVOWELS != -1) vowelsSet.add(c);
        }

        ArrayList<String> ret = new ArrayList<>();
        for(String s : arr)
        {
            HashSet<Character> check = new HashSet<>();
            for(int i = 0; i < s.length(); ++i)
            {
                char c = s.charAt(i);
                int index = VOWELS.indexOf(c);
                if(index != -1)
                    check.add(c);
            }
            if(check.equals(vowelsSet) == true)
                ret.add(s);
        }        

        return ret;
    }

    public static boolean validateCard(final long cardLong)
    {  
        final String card = Long.toString(cardLong);
        int cardLen = card.length();
        if(cardLen < 14 || cardLen > 19)
            return false;
        String reversedString = card.substring(0, cardLen - 1);
        int checkDigit = card.charAt(cardLen - 1) - '0';

        reversedString = reverseString(reversedString);
        cardLen = reversedString.length();

        int[] massive = new int[cardLen];
        int sum = 0;
        for(int i = 0; i < cardLen; i++) massive[i] = reversedString.charAt(i) - '0';
        for(int i = 0; i < cardLen; i += 2) 
        {
            massive[i] <<= 1;
            if(massive[i] > 9)
                massive[i] = massive[i] % 10 + massive[i] / 10;
        }
        for(int i = 0; i < cardLen; i++)
            sum += massive[i];

        int check = 10 - sum % 10;
        if(check == checkDigit)
            return true;
        return false;
    }
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String numToEng(int n)
    {
        final String[] list1 = { "one", "two", "three", "four", "five", "six", "seven", "eight",
                                 "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                                 "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        final String[] list2 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                                "eighty", "ninety"};

        String ret = "";
        int nDivide = n / 100;
        int nMod = n % 100;
        if(n == 0)
            return "zero";
        if(nDivide != 0 && nMod != 0)
            ret = String.format("%s hundred ", list1[nDivide - 1]);
        else if(nDivide != 0)
            ret = String.format("%s hundred", list1[nDivide - 1]);
        if(nMod <= 19)
            ret += list1[nMod - 1];
        else
            ret += list2[nMod / 10 - 2] + " " + list1[n % 10 - 1];
        return ret;
    }

    public static String getSha256Hash(final String input)
    {
        final int[] K = { 0x428A2F98, 0x71374491, 0xB5C0FBCF, 0xE9B5DBA5, 0x3956C25B, 0x59F111F1, 0x923F82A4, 0xAB1C5ED5,
            0xD807AA98, 0x12835B01, 0x243185BE, 0x550C7DC3, 0x72BE5D74, 0x80DEB1FE, 0x9BDC06A7, 0xC19BF174,
            0xE49B69C1, 0xEFBE4786, 0x0FC19DC6, 0x240CA1CC, 0x2DE92C6F, 0x4A7484AA, 0x5CB0A9DC, 0x76F988DA,
            0x983E5152, 0xA831C66D, 0xB00327C8, 0xBF597FC7, 0xC6E00BF3, 0xD5A79147, 0x06CA6351, 0x14292967,
            0x27B70A85, 0x2E1B2138, 0x4D2C6DFC, 0x53380D13, 0x650A7354, 0x766A0ABB, 0x81C2C92E, 0x92722C85,
            0xA2BFE8A1, 0xA81A664B, 0xC24B8B70, 0xC76C51A3, 0xD192E819, 0xD6990624, 0xF40E3585, 0x106AA070,
            0x19A4C116, 0x1E376C08, 0x2748774C, 0x34B0BCB5, 0x391C0CB3, 0x4ED8AA4A, 0x5B9CCA4F, 0x682E6FF3,
            0x748F82EE, 0x78A5636F, 0x84C87814, 0x8CC70208, 0x90BEFFFA, 0xA4506CEB, 0xBEF9A3F7, 0xC67178F2
        };
        int[] H = { 0x6A09E667, 0xBB67AE85, 0x3C6EF372, 0xA54FF53A, 0x510E527F, 0x9B05688C, 0x1F83D9AB, 0x5BE0CD19 };
        int[] W = new int[64];
        
        final int BLOCKSIZE = 512;
        final int CHARSIZE = 8;
        final int ADDITIONBITS = 1 + 64;
        int fullSizeInBits = input.length() * CHARSIZE + ADDITIONBITS;
        int calculatedBits = (int)(Math.ceil((double)fullSizeInBits / BLOCKSIZE) * BLOCKSIZE);
        int[] byteString = new int[calculatedBits / 8];
        int inputLen = input.length();
        for(int i = 0; i < inputLen; i++)
            byteString[i] = (int)input.charAt(i);
        byteString[inputLen] = -128;
        for(int i = inputLen + 1; i < calculatedBits / 8 - 8; i++)
            byteString[i] = 0;
        long longSizeInput = inputLen * 8;
        for(int i = 0, j = byteString.length - 1; i < 8; i++, j--)
            byteString[j] = (int)(longSizeInput >> (8 * i));

        for(int j = 0; j < byteString.length; j += BLOCKSIZE / 8)
        {
            for(int i = 0; i < 16; i++)
                W[i] = ((0xff & byteString[j + i * 4]) << 24) | ((0xff & byteString[j + i * 4 + 1]) << 16) | ((0xff & byteString[j + i * 4 + 2]) << 8) | ((0xff & byteString[j + i * 4 + 3]) << 0);
            for(int i = 16; i < 64; i++)
            {
                int s0 = Integer.rotateRight(W[i-15], 7) ^ Integer.rotateRight(W[i-15], 18) ^ (W[i-15] >>> 3);
                int s1 = Integer.rotateRight(W[i-2], 17) ^ Integer.rotateRight(W[i-2], 19) ^ (W[i-2] >>> 10);
                W[i] = W[i-16] + s0 + W[i-7] + s1;
            }
            int a = H[0];
            int b = H[1];
            int c = H[2];
            int d = H[3];
            int e = H[4];
            int f = H[5];
            int g = H[6];
            int h = H[7];
            for(int i = 0; i < 64; i++)
            {
                int sigma0 = (Integer.rotateRight(a, 2) ^ Integer.rotateRight(a, 13) ^ Integer.rotateRight(a, 22));
                int Ma = ((a & b) ^ (a & c) ^ (b & c));
                int t2 = sigma0 + Ma;
                int sigma1 = (Integer.rotateRight(e, 6) ^ Integer.rotateRight(e, 11) ^ Integer.rotateRight(e, 25));
                int Ch = ((e & f) ^ ((~e) & g));
                int t1 = h + sigma1 + Ch + K[i] + W[i];

                h = g;
                g = f;
                f = e;
                e = d + t1;
                d = c;
                c = b;
                b = a;
                a = t1 + t2;
            }
            H[0] += a;
            H[1] += b;
            H[2] += c;
            H[3] += d;
            H[4] += e;
            H[5] += f;
            H[6] += g;
            H[7] += h;
        }
        String digestString = "";
        for(int i = 0; i < H.length; i++)
            digestString += Integer.toHexString(H[i]);
        return digestString;
    }

    public static String correctTitle(String string)
    {
        return correctOne(string, " ");
    }
    public static String correctOne(String string, String delimiter)
    {
        final String immutable = "ANDINTHEOF";
        
        String[] words = string.split(delimiter);

        for(int i = 0; i < words.length; i++)
        {
            String s = words[i];
            if(s.indexOf('-') == -1)
            {
                int index = immutable.indexOf(s.toUpperCase());
                if(index == -1)
                {
                    String newString = Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
                    words[i] = newString;
                }
                else
                    words[i] = s.toLowerCase();
            }
            else
            {
                words[i] = correctOne(s, "-");
            }
        }

        String ret = "";
        for(int i = 0; i < words.length; i++)
        {
            ret += words[i];
            if(i + 1 < words.length)
                ret += delimiter; 
        }
        return ret;
    }

    public static String hexLattice(int n)
    {
        if(isCentered(n) == false)
            return "Invalid";
        int c = 1;
        for(; 3 * c * (c - 1) + 1 != n; c++);
        int[] columns = columns(2 * (c - 1) + 1);
        int max = Integer.MIN_VALUE;    
        for(int i = 0; i < columns.length; i++)
        {
            if(columns[i] > max)
                max = columns[i];
        }

        String ret = "";
        final String EMPTY = " ";
        final String SPOT = " o";
        for(int i = 0; i < columns.length; i++)
        {
            int space = (max - columns[i]);
            for(int j = 0; j < space; j++) ret += EMPTY;
            for(int j = 0; j < columns[i]; j++) ret += SPOT;
            for(int j = 0; j < space; j++) ret += EMPTY;
            ret += '\n';
        }
        return ret;
    }
    public static int[] columns(int n) 
    {
        int[] columns = new int[n];
        int h = (int)Math.floor(n / 2);
            
        for (int i = 0; i < n; i++)
            columns[i] = n - Math.abs(i - h);
    
        return columns;
    }
    public static boolean isCentered(int n)
    {
        double val = 4. * (n - 1) / 3.;
        double D = 1 + val;
        return D % 1 == 0;
    }
}
