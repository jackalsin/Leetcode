package interviews.google._356_Line_Reflection;

import _351_400._356_Line_Reflection.Solution;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution;
    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testOnlineCase1() throws Exception {
        assertTrue(solution.isReflected(new int[][]{{1, 1}, {-1, 1}}));
    }

    @Test
    public void testOnlineCase2() throws Exception {
        assertFalse(solution.isReflected(new int[][]{{1, 1}, {-1, -1}}));
    }

    @Test
    public void testDuplicatedPoints() throws Exception {
        assertTrue(solution.isReflected(new int[][]{{-16, 1}, {16, 1}, {16, 1}}));
    }

    @Test
    public void testFailedCase() throws Exception {
        assertTrue(solution.isReflected(new int[][]{{1, 1}, {0, 1}, {-1, 1}, {0, 0}}));
    }
}