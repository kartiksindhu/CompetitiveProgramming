package resursuion;

public class fib {
    private static int solve(int n) {
        if (n == 0) {
            return 0;
        } if (n == 1) {
            return 1;
        }
        return solve(n - 1) + solve( n - 2);
    }
    public static void main(String[] args) {
        System.out.println(solve(0));
    }
}
