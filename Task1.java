public class Task1 {
    public static void main(String[] args) {
        System.out.println("remainder(1,3) -> " + remainder(1, 3));
        System.out.println("remainder(3,4) -> " + remainder(3, 4));
        System.out.println("remainder(-9,45) -> " + remainder(-9, 45));
        System.out.println("remainder(5,5) -> " + remainder(5, 5));

        System.out.println("triArea(3,2) -> " + triArea(3, 2));
        System.out.println("triArea(7,4) -> " + triArea(7, 4));
        System.out.println("triArea(10,10) -> " + triArea(10, 10));

        System.out.println("animals(2,3,5) -> " + animals(2, 3, 5));
        System.out.println("animals(1,2,3) -> " + animals(1, 2, 3));
        System.out.println("animals(5,2,8) -> " + animals(5, 2, 8));

        System.out.println("profitableGamble(0.2, 50, 9) -> " + profitableGamble(0.2, 50, 9));
        System.out.println("profitableGamble(0.9, 1, 2) -> " + profitableGamble(0.9, 1, 2));
        System.out.println("profitableGamble(0.9, 3, 2) -> " + profitableGamble(0.9, 3, 2));

        System.out.println("operation(24, 15, 9) -> " + operation(24, 15, 9));
        System.out.println("operation(24, 26, 2) -> " + operation(24, 26, 2));
        System.out.println("operation(15, 11, 11) -> " + operation(15, 11, 11));

        System.out.println("ctoa('A') -> " + ctoa('A'));
        System.out.println("ctoa('m') -> " + ctoa('m'));
        System.out.println("ctoa('[') -> " + ctoa('['));
        System.out.println("ctoa('\\') -> " + ctoa('\\'));

        System.out.println("addUpTo(3) -> " + addUpTo(3));
        System.out.println("addUpTo(10) -> " + addUpTo(10));
        System.out.println("addUpTo(7) -> " + addUpTo(7));

        System.out.println("nextEdge(8, 10) -> " + nextEdge(8, 10));
        System.out.println("nextEdge(5, 7) -> " + nextEdge(5, 7));
        System.out.println("nextEdge(9, 2) -> " + nextEdge(9, 2));

        int[] first_test = { 1, 5, 9 };
        int[] second_test = { 3, 4, 5 };
        int[] third_test = { 2 };
        int[] four_test = {};

        System.out.println("sumOfCubes([1, 5, 9]) -> " + sumOfCubes(first_test));
        System.out.println("sumOfCubes([3, 4, 5]) -> " + sumOfCubes(second_test));
        System.out.println("sumOfCubes([2]) -> " + sumOfCubes(third_test));
        System.out.println("sumOfCubes([]) -> " + sumOfCubes(four_test));

        System.out.println("abcmath(42, 5, 10) -> " + abcmath(42, 5, 10));
        System.out.println("abcmath(5, 2, 1) -> " + abcmath(5, 2, 1));
        System.out.println("abcmath(1, 2, 3) -> " + abcmath(1, 2, 3));
    }
    
    private static int remainder(int a, int b) {
        return (a % b);
    }
    private static double triArea(double a, double h) {
        return (a * h) / 2;
    }
    private static int animals(int a, int b, int c) {
        return a * 2 + b * 4 + c * 4;
    }
    private static boolean profitableGamble(double prob, double prize, double pay) {
        return (prob * prize > pay) ? true : false;
    }
    private static String operation(int N, int a, int b) {
        if (a + b == N)
            return "added";
        else if (a - b == N)
            return "subtracted";
        else if (a * b == N)
            return "multiplied";
        else if (a / b == N)
            return "divided";
        return "none";
    }
    private static int ctoa(char a) {
        return (int) a;
    }
    private static int addUpTo(int n) {
        int ret = 0;
        for (int i = 0; i < n; ++i, ret += i)
            ;
        return ret;
    }
    private static int nextEdge(int a, int b) {
        return a + b - 1;
    }
    private static int sumOfCubes(int[] arr) {
        int ret = 0;
        for (int i : arr)
            ret += i * i * i;
        return ret;
    }
    private static boolean abcmath(int a, int b, int N) {
        for (int i = 0; i < b; ++i, a += a);
        return a % N == 0;
    }
}