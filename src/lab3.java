package lab3;

public class lab3 {
    public static void main(String[] args) {

        System.out.println("=== завдання 5 ===");
        executeTask5();


        System.out.println("\n=== завдання 7 ===");
        executeTask7();


        System.out.println("\n=== завдання 14 ===");
        executeTask14();
    }

    //
    public static void executeTask5() {
        testTask5(10, 5);
        testTask5(20, 10);
        testTask5(-5, 10);
        testTask5(10, 40);
        testTask5(15, 34);
    }

    public static double calculateSumTask5(double s, int k) {
        if (s <= 0) {
            throw new IllegalArgumentException("задача 5: Параметр s повинен бути > 0. дано: s = " + s);
        }
        if (k >= 35) {
            throw new IllegalArgumentException("задача 5: Параметр k повинен бути < 35. дано: k = " + k);
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.log10(Math.sqrt(s * (1.0 / (i * i))));
        }
        return sum;
    }

    public static void testTask5(double s, int k) {
        System.out.print("задача 5 -> s: " + s + ", k: " + k + " -> результат: ");
        try {
            System.out.println(calculateSumTask5(s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("виняток" + e.getMessage());
        }
    }

    // ======== задача 7 ========
    public static void executeTask7() {
        testTask7(10, 1);
        testTask7(10, 2);
        testTask7(10, 3);
        testTask7(-5, 3);
        testTask7(15, 5);
    }

    public static double calculateFunctionTask7(double t, int i) {
        if (t <= 0) {
            throw new IllegalArgumentException("задача 7: Параметр t повинен бути > 0. дано: t = " + t);
        }
        if (i < 1) {
            throw new IllegalArgumentException("задача 7: Параметр i повинен бути >= 1. дано: i = " + i);
        }

        if (i == 1 || i == 2) {
            return Math.log(t);
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
    }

    public static void testTask7(double t, int i) {
        System.out.print("задача 7 -> t: " + t + ", i: " + i + " -> результат: ");
        try {
            System.out.println(calculateFunctionTask7(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("виняток" + e.getMessage());
        }
    }

    // ======== задача 14 ========
    public static void executeTask14() {
        testTask14(0.01);
        testTask14(0.0001);
        testTask14(-0.1);
    }

    public static double calculateInfiniteSumTask14(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("задача 14: параметр epsilon повинен бути > 0. дано: epsilon = " + epsilon);
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
        System.out.print("задача 14 -> epsilon: " + epsilon + " -> результат: ");
        try {
            System.out.println(calculateInfiniteSumTask14(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("виняток " + e.getMessage());
        }
    }
}
