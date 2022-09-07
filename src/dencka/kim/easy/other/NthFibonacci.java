package dencka.kim.easy.other;

public class NthFibonacci {
    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

    public static int getNthFib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n - 1];
    }

//    public static int getNthFib(int n) {
//        if (n == 1) return 0;
//        if (n == 2) return 1;
//        int prev = 0;
//        int cur = 1;
//        int result = 0;
//        for (int i = 2; i < n; i++) {
//            result = prev + cur;
//            prev = cur;
//            cur = result;
//        }
//        return result;
//    }
}
