package project.euler.from021to030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Problem021Test
{
    @Test
    public void testSumOfDivisors()
    {
        assertEquals(Problem021.sumOfDivisors(220), 284);
        assertEquals(Problem021.sumOfDivisors(284), 220);
    }
}
