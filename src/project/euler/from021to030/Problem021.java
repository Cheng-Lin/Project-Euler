package project.euler.from021to030;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly
 * into n). If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a
 * and b are called amicable numbers. 
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
 * therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220. 
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem021
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Please enter an number: ");
        
        if (cin.hasNext() && !cin.hasNextInt())
        {
            System.err.println("Please enter an valid number.");
            System.exit(1);
        }

        int limit = cin.nextInt();
        cin.close();

        if (limit < 1)
        {
            System.err.println("The input number must be greater than 1");
            System.exit(1);
        }
        
        Set<Integer> processed = new HashSet<>();
        for (int i = 2; i < limit; i++)
        {
            if (!processed.contains(i))
            {
                int j = sumOfDivisors(i);
                if (j < limit && i != j && sumOfDivisors(j) == i)
                {
                    processed.add(i);
                    processed.add(j);
                }
            }
        }
        
        int sum = 0;
        for (Integer i : processed)
        {
            System.out.println(i);
            sum += i;
        }
        System.out.println(sum);
    }
    
    public static int sumOfDivisors(int number)
    {
        int result = 1;
        
        for (int i = 2; i <= (int)Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                result += i + (number / i);
            }
        }
        
        return result;
    }
}
