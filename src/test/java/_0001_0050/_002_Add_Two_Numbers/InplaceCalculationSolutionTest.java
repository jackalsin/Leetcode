package _0001_0050._002_Add_Two_Numbers;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/7.
 */
public class InplaceCalculationSolutionTest {

  private InplaceCalculationSolution solution = new InplaceCalculationSolution();

  private ListNode NUM_432;

  private ListNode NUM_768;

  private ListNode NUM_38;

  @Before
  public void setUp() {
    NUM_432 = ListNodes.getListOfNodes(new int[]{2, 3, 4});
    NUM_768 = ListNodes.getListOfNodes(new int[]{8, 6, 7});
    NUM_38 = ListNodes.getListOfNodes(new int[]{8, 3});
  }

  @Test
  public void addTwoNumbersNUM_432AndNUM_768() throws Exception {
    assertEquals(ListNodes.getListOfNodes(new int[]{0, 0, 2, 1}),
        solution.addTwoNumbers(NUM_432, NUM_768));

  }

  @Test
  public void addTwoNumbersNum432And38() throws Exception {
    assertEquals(ListNodes.getListOfNodes(new int[]{0, 7, 4}),
        solution.addTwoNumbers(NUM_432, NUM_38));
  }

  @Test
  public void addTwoNumbersNum38And432() throws Exception {
    assertEquals(ListNodes.getListOfNodes(new int[]{0, 7, 4}),
        solution.addTwoNumbers(NUM_38, NUM_432));
  }
}
