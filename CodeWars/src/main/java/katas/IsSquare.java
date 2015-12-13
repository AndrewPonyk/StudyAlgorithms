package katas;

public class IsSquare {

    public static void main(String[] args) {
        System.out.println(isSquare(11235902));
    }

    public static boolean isSquare(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (i * i == n) {
                return true;
            }
        }
        return false;
    }

}
