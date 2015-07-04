package project.euler.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class LargeIntegerTest 
{
	private static final int NUMBER_CAP = 1000000;
	private static final Random RANDOM = new Random();
	
	@Test
	public void testConstructor() 
	{
		LargeInteger defaultCtor = new LargeInteger();
		assertEquals(defaultCtor.toString(), "0");
		
		Integer i = new Integer(Math.abs(RANDOM.nextInt()));
		LargeInteger intCtor = new LargeInteger(i);
		assertEquals(intCtor.toString(), i.toString());
		
		Long l = new Long(Math.abs(RANDOM.nextLong()));
		LargeInteger longCtor = new LargeInteger(l);
		assertEquals(longCtor.toString(), l.toString());
		
		List<Integer> list = new ArrayList<>();
		String s = String.valueOf(Math.abs(RANDOM.nextInt()));
		for (int j = s.length() - 1; j >= 0; j--)
		{
			list.add(s.charAt(j) - '0');
		}
		LargeInteger listCtor = new LargeInteger(list);
		assertEquals(listCtor.toString(), s);
		
		LargeInteger copyCtor = new LargeInteger(intCtor);
		assertEquals(copyCtor.toString(), intCtor.toString());
	}
	
	@Test
	public void testAddition()
	{
		Long l1 = new Long(Math.abs(RANDOM.nextInt()));
		Long l2 = new Long(Math.abs(RANDOM.nextInt()));
		
		LargeInteger result = new LargeInteger(l1);
		result.add(new LargeInteger(l2));
		
		assertEquals(result.toString(), String.valueOf(l1 + l2));
		
		Long l3 = new Long(Math.abs(RANDOM.nextInt()));
		result.add(new LargeInteger(l3));
		
		assertEquals(result.toString(), String.valueOf(l1 + l2 + l3));
	}
	
	@Test
	public void testMultiplication()
	{
		Long l1 = new Long(Math.abs(RANDOM.nextInt()) % NUMBER_CAP);
		Long l2 = new Long(Math.abs(RANDOM.nextInt()) % NUMBER_CAP);
		
		LargeInteger result = new LargeInteger(l1);
		result.multiply(new LargeInteger(l2));
		
		assertEquals(result.toString(), String.valueOf(l1 * l2));
		
		Long l3 = new Long(Math.abs(RANDOM.nextInt()) % NUMBER_CAP);
		result.multiply(new LargeInteger(l3));
		
		assertEquals(result.toString(), String.valueOf(l1 * l2 * l3));
		
		LargeInteger test = new LargeInteger("608281864034267560872252163321295376887552831379210240000000000");
		test.multiply(new LargeInteger(50));
	}
}
