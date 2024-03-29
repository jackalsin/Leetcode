package _0151_0200._168_Excel_Sheet_Column_Title;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private Solution solution;

  @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testSingle() throws Exception {
        assertEquals("A", solution.convertToTitle(1));
        assertEquals("Z", solution.convertToTitle(26));
    }

    @Test
    public void testDouble() throws Exception {
        assertEquals("AB", solution.convertToTitle(26 * 1 + 2));
        assertEquals("AZ", solution.convertToTitle(26 * 1 + 26));
    }

    @Test
    public void testTriple() throws Exception {
        assertEquals("AAB", solution.convertToTitle(26 * 26 * 1 + 26 * 1 + 2));
    }
}