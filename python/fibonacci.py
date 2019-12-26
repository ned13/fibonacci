# This code calculates the fibonacci of some number many times and
# each time prints the total time it took to calculate the value
# @author Rodrigo Ramirez
import time


# Calculates the Fibonacci of n
def f(n):
    if n <= 2:
        return 1
    n1 = 1
    n2 = 1
    result = 0

    for i in range(3, n + 1):
        result = n1 + n2
        n2 = n1
        n1 = result

    return result;


# Prints the average time it takes to calculate f(n)
def track_execution_speed():
    print("Average time to execute f(90) in nanoseconds\n")
    EXECUTION_TIMES = 200
    CAL_FAB_TIMES = 5000
    results = list(range(EXECUTION_TIMES))
    for i in list(range(EXECUTION_TIMES)):
        start_time = time.time_ns()
        for j in list(range(CAL_FAB_TIMES)):
            f(90)

        total_time = (time.time_ns() - start_time)
        results[i] = total_time / CAL_FAB_TIMES
        # print(results[i])
        # print(1e+9 * total_time/50)

    average = sum(results) / len(results)
    print("Python Result: Avarage=%.5fns"% (average));


track_execution_speed()