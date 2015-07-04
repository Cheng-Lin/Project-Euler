package project.euler.from011to020;

import project.euler.util.LargeInteger;

/**
 * problem 20 - factorial digit sum
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */

public class Problem020 
{
	public static void main(String[] args)
	{
		int number = 100;
		
		LargeInteger result = new LargeInteger(new Integer(1));
		for (int i = 1; i <= number; i++)
		{
			result.multiply(new LargeInteger(new Integer(i)));
		}
		
		System.out.println(result.toString());
		System.out.println(result.getDigitSum());
	}
}
