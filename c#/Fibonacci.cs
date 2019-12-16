using System;
using System.Diagnostics;
using System.Linq;

namespace CSharp
{
    public class Fibonacci
    {
        public static long f(long n)
        {
            if (n <= 2)
            {
                return 1;
            }
            long n1 = 1;
            long n2 = 1;
            long result = 0;

            for (long i = 3; i <= n; i++)
            {
                result = n1 + n2;
                n2 = n1;
                n1 = result;
            }
            return result;
        }

        public static void trackExecutionSpeed()
        {
            Console.WriteLine("Average time to execute f(90) in nanoseconds");
            const int EXECUTION_TIMES = 200;
            const int CAL_FAB_TIMES = 50_000;
            double[] results = new double[EXECUTION_TIMES];
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < EXECUTION_TIMES; i++)
            {
                //long startTime = System.nanoTime();
                sw.Restart();
                for (int j = 0; j < CAL_FAB_TIMES; j++)
                {
                    f(90);
                }
                sw.Stop();
                //long totalTime = sw.ElapsedMilliseconds;
                var totalTimeSpan = sw.Elapsed;
                double totalTime = totalTimeSpan.TotalMilliseconds * 1000000;
                results[i] = totalTime/CAL_FAB_TIMES;
            }

            //Console.WriteLine($"C# Result: Avarage={results.Average()}ms, Detail={String.Join(",", results)}");

            Console.WriteLine($"C# Result: Avarage={results.Average()}ms");
        }

        public static void Main(string[] args)
        {
            trackExecutionSpeed();
        }
    }
}