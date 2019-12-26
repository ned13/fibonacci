function fobonacci(n) {
	if (n <= 2) {
		return 1;
	}
	let n1 = 1;
	let n2 = 1;
	let result = 0;
	let range = n + 1;
	for (let index = 3; index <= range; index++) {
		result = n1 + n2;
		n2 = n1;
		n1 = result;
	}

	return result;
}

function track_execution_speed() {
    console.log('Average time to execute f(90) in nanoseconds\n');
    const EXECUTION_TIMES = 200;
    const CAL_FAB_TIMES = 50000;
    const results = new Array(EXECUTION_TIMES);
	for (let i = 0; i < EXECUTION_TIMES; i++) {
        //let start_time = Date.now();
        let start_time = process.hrtime.bigint();

		for (let j = 0; j < CAL_FAB_TIMES; j++) {
			fobonacci(90);
        }

        //let totaltime = Date.now() - start_time;
        let totaltime = (process.hrtime.bigint() - start_time);
        //results.push(totaltime / BigInt(CAL_FAB_TIMES));
        results[i] = totaltime / BigInt(CAL_FAB_TIMES);
    }

    // const average = results.reduce((p, c) => p + BigInt(c), BigInt(0)) / BigInt(results.length);
    // const detail = results.join(",");
    // console.log(`Node.js Result: Avarage=${average}ms, Detail=${detail}`);

    const average = results.reduce((p, c) => p + BigInt(c), BigInt(0)) / BigInt(results.length);
    console.log(`Node.js Result: Avarage=${average}ns`);
}

track_execution_speed();
