package project.euler.util;

import java.util.ArrayList;
import java.util.List;

public class LargeInteger 
{
    /* Private Field */

    private List<Integer> number;

    /* Public Constructor */

    public LargeInteger()
    {
        this("0");
    }
    
    public LargeInteger(Integer number)
    {
        this(number.toString());
    }
    
    public LargeInteger(Long number)
    {
    	this(number.toString());
    }
    
    public LargeInteger(String number)
    {
    	this.number = new ArrayList<>(number.length());
    	for (int i = number.length() - 1; i >= 0; i--)
    	{
    		this.number.add(number.charAt(i) - '0');
    	}
    }
    
    public LargeInteger(List<Integer> number)
    {
    	this.number = number;
    }
    
    public LargeInteger(LargeInteger number)
    {
    	this.number = new ArrayList<>(number.number.size());
    	for (Integer i : number.number)
    	{
    		this.number.add(i);
    	}
    }
    
    /* Public Methods */
    
    public LargeInteger add(LargeInteger adder)
    {    	
        for (int i = 0; i < adder.number.size(); i++)
        {
            int carry = adder.number.get(i);
                        
            for (int j = i; j < this.number.size() && carry > 0; j++)
            {
                int result = carry + this.number.get(j);
                this.number.set(j, result % 10);
                carry = result / 10;
            }
            
            if (i > this.number.size() - 1 || carry > 0)
            {
            	this.number.add(carry);
            }
        }
        return this;
    }
    
    public long getDigitSum()
    {
    	long result = 0;
    	for (Integer i : this.number) 
    	{
    		result += i;
    	}
    	return result;
    }
    
    public LargeInteger multiply(LargeInteger multiplier)
    {
    	LargeInteger base = new LargeInteger(this);
    	this.singleMul(multiplier.number.get(0));
    	for (int i = 1; i < multiplier.number.size(); i++)
    	{
    		LargeInteger temp = new LargeInteger(base).singleMul(multiplier.number.get(i));
    		temp.shiftLeft(i);
    		this.add(temp);
    	}
    	return this;
    }
        
    /* Overrides */
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = this.number.size() - 1; i >= 0; i--)
        {
        	sb.append(this.number.get(i));
        }
        return sb.toString();
    }
    
    /* Private Methods */
    
    private LargeInteger singleMul(int multiplier)
    {
    	int carry = 0;
    	for (int i = 0; i < this.number.size(); i++)
    	{
    		int result = this.number.get(i) * multiplier + carry;
    		this.number.set(i, result % 10);
    		carry = result / 10;
    	}
    	if (carry > 0)
    	{
    		this.number.add(carry);
    	}
    	return this;
    }
    
    private LargeInteger shiftLeft(int amount)
    {
    	List<Integer> result = new ArrayList<>(this.number.size() + amount);
    	for (int i = 0; i < amount; i++)
    	{
    		result.add(0);
    	}
    	for (int i = 0; i < this.number.size(); i++)
    	{
    		result.add(this.number.get(i));
    	}
    	this.number = result;
    	return this;
    }
}
