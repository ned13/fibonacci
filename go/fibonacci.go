// This code calculates the fibonacci of some large number many times and
// each time prints the total time it took to calculate the value
// @author Rodrigo Ramirez
package main

import (
	"fmt"
	"time"
)

// Calculates the Fibonacci of n
func f(n int) int {
	if n <= 2 {
		return 1
	}

	n1 := 1
	n2 := 1
	result := 0

	for i := 3; i <= n; i++ {
		result = n1 + n2
		n2 = n1
		n1 = result
	}

	return result
}

// Prints the average time it takes to calculate f(n)
func trackExecutionSpeed() {
	println("Average time to execute f(90) in nanoseconds")
	const EXECUTION_TIMES = 200
	const CAL_FAB_TIMES = 50000
	var results [EXECUTION_TIMES]float64
	for i := 0; i < EXECUTION_TIMES; i++ {
		startTime := time.Now()
		for j := 0; j < CAL_FAB_TIMES; j++ {
			f(90)
		}
		totalTime := time.Since(startTime)
		results[i] = float64(totalTime.Nanoseconds()) / float64(CAL_FAB_TIMES)
	}

	var total float64 = 0
	for _, r := range results {
		total += r
	}
	var average float64 = total / float64(len(results))
	fmt.Printf("Go Result: Avarage=%vns \n", average)
	return
}

func main() {
	trackExecutionSpeed()
	return
}
