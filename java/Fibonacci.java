import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Class used to calculate the fibonacci of some number many times and each time
 * print the total time it took to calculate the value
 *
 * @author Rodrigo Ramirez
 */
public class Fibonacci {

    /**
     * Calculates the Fibonacci of n :
     * @param n
     * @return f(n)
     */
    public static long f(long n) {
        if (n <= 2) {
            return 1;
        }
        long n1 = 1;
        long n2 = 1;
        long result = 0;

        for(long i = 3; i <= n; i++ ) {
            result = n1 + n2;
            n2 = n1;
            n1 = result;
        }
        return result;
    }


    /**
     * Prints the average time it takes to calculate f(n)
     * @param args
     */
    public static void trackExecutionSpeed() {
        System.out.println("Average time to execute f(90) in nanoseconds");
        final int EXECUTION_TIMES = 200;
        final int CAL_FAB_TIMES = 50000;
        double[] results = new double[EXECUTION_TIMES];
        for(int i = 0; i < EXECUTION_TIMES; i++) {
            long startTime = System.nanoTime();
            for(int j = 0; j < CAL_FAB_TIMES; j++) {
                f(90);
            }
            long totalTime = System.nanoTime() - startTime;
            results[i] = totalTime/CAL_FAB_TIMES;
        }

        // System.out.println(String.format(
        //     "Java Result: Avarage=%fms, Detail=%s",
        //     Arrays.stream(results).average().orElse(0.0D),
        //     String.join(",", Arrays.stream(results).boxed().map(d -> d.toString()).toArray(String[]::new)))
        // );

        System.out.println(String.format(
            "Java Result: Avarage=%fms",
            Arrays.stream(results).average().orElse(0.0D))
        );
    }

    public static void main(String[] args) {
        trackExecutionSpeed();
    }
}
