package _151_200._170_Two_Sum_III_Data_structure_design;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    private TwoSum twoSum;
    @Before
    public void setUp() throws Exception {
        twoSum = new TwoSum();
    }

    @Test
    public void test1Element() throws Exception{
        twoSum.add(0);
        assertFalse(twoSum.find(0));
    }

    @Test
    public void testDuplicatedElements() throws Exception{
        twoSum.add(0);
        twoSum.add(0);
        assertTrue(twoSum.find(0));
    }

    @Test
    public void testTwoDistinctElements() throws Exception{
        twoSum.add(0);
        twoSum.add(1);
        assertTrue(twoSum.find(1));
    }
}