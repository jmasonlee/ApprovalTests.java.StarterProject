package org;

import org.approvaltests.Approvals;
import org.approvaltests.legacycode.Range;
import org.junit.Assert;
import org.junit.Test;

public class RefactoringDemoTest {

	// @Test
	public void test() {
		for (int i = 0; i < 46; i++) {
			Assert.assertEquals(String.format("i=%s", i), fibonacci_direct(i), fibonacci_recursive(i));
		}
	}

	@Test
	public void testName() throws Exception {
		Approvals.verifyAll("fib", Range.get(1, 46), i -> String.format("%s -> %s", i, fibonacci_direct(i)));
	}

	public int fibonacci_recursive(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
	}

	public int fibonacci_direct(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			double sqrt_5 = 2.2360679775;
			double Phi = (1.0 + sqrt_5) / 2.0;
			double phi = (1.0 - sqrt_5) / 2.0;
			int value1 = n;
			int fib1 = (int) Math.round((Math.pow(Phi, value1) - Math.pow(phi, value1)) / sqrt_5);
			int value2 = n;
			int fib2 = (int) Math.round((Math.pow(Phi, value2) - Math.pow(phi, value2)) / sqrt_5);

			return fib1;
		}

	}

}
