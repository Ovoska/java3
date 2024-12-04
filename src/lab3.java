package lab3;

public class lab3 {
    public static void main(String[] args) {
        // Task 5
        System.out.println("=== Task 5 ===");
        executeTask5();

        // Task 7
        System.out.println("\n=== Task 7 ===");
        executeTask7();

        // Task 14
        System.out.println("\n=== Task 14 ===");
        executeTask14();
    }

    // ======== Task 5 ========
    public static void executeTask5() {
        testTask5(10, 5);  // Valid
        testTask5(20, 10); // Valid
        testTask5(-5, 10); // Invalid: s <= 0
        testTask5(10, 40); // Invalid: k >= 35
        testTask5(15, 34); // Valid
    }

    public static double calculateSumTask5(double s, int k) {
        if (s <= 0) {
            throw new IllegalArgumentException("Task 5: Parameter s must be > 0. Provided: s = " + s);
        }
        if (k >= 35) {
            throw new IllegalArgumentException("Task 5: Parameter k must be < 35. Provided: k = " + k);
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.log10(Math.sqrt(s * (1.0 / (i * i))));
        }
        return sum;
    }

    public static void testTask5(double s, int k) {
        System.out.print("Task 5 -> s: " + s + ", k: " + k + " -> Result: ");
        try {
            System.out.println(calculateSumTask5(s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    // ======== Task 7 ========
    public static void executeTask7() {
        testTask7(10, 1);  // Valid
        testTask7(10, 2);  // Valid
        testTask7(10, 3);  // Valid
        testTask7(-5, 3);  // Invalid: t <= 0
        testTask7(15, 5);  // Valid
    }

    public static double calculateFunctionTask7(double t, int i) {
        if (t <= 0) {
            throw new IllegalArgumentException("Task 7: Parameter t must be > 0. Provided: t = " + t);
        }
        if (i < 1) {
            throw new IllegalArgumentException("Task 7: Parameter i must be >= 1. Provided: i = " + i);
        }

        if (i == 1 || i == 2) {
            return Math.log(t); // ln(t)
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
    }

    public static void testTask7(double t, int i) {
        System.out.print("Task 7 -> t: " + t + ", i: " + i + " -> Result: ");
        try {
            System.out.println(calculateFunctionTask7(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    // ======== Task 14 ========
    public static void executeTask14() {
        testTask14(0.01);   // Valid
        testTask14(0.0001); // Valid
        testTask14(-0.1);   // Invalid: epsilon <= 0
    }

    public static double calculateInfiniteSumTask14(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Task 14: Parameter epsilon must be > 0. Provided: epsilon = " + epsilon);
        }

        double sum = 0;
        double term;
        int i = 0;

        do {
            term = Math.pow(-2, i) / (factorial(i) * (i + 1));
            sum += term;
            i++;
        } while (Math.abs(term) >= epsilon);

        return sum;
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void testTask14(double epsilon) {
        System.out.print("Task 14 -> epsilon: " + epsilon + " -> Result: ");
        try {
            System.out.println(calculateInfiniteSumTask14(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
