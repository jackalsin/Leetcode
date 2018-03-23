package _751_800._772_Basic_Calculator_III.parser;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import _751_800._772_Basic_Calculator_III.expression.Expression;
import _751_800._772_Basic_Calculator_III.operator.Addition;
import _751_800._772_Basic_Calculator_III.operator.BinaryOperator;
import _751_800._772_Basic_Calculator_III.operator.Division;
import _751_800._772_Basic_Calculator_III.operator.Multiplication;
import _751_800._772_Basic_Calculator_III.operator.Operator;
import _751_800._772_Basic_Calculator_III.operator.Subtraction;
import _751_800._772_Basic_Calculator_III.operator.UnaryOperator;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class ExpressionParser {
  /* operator set */
  private final Set<Operator> operatorSet = Set.of(
      new Addition(),
      new Subtraction(),
      new Multiplication(),
      new Division()
  );
  /* precedence table */
  private final OrderOfOperationsRules precedence;

  private final ExpressionMaker builder = new ExpressionMaker();

  public ExpressionParser() {
    precedence = new OrderOfOperationsRules(Map.of(
        "+", 1,
        "-", 1,
        "*", 2,
        "/", 2
    ));

  }

  public Expression parse(final String expression) {
    return null;
  }


  public static void main(String[] args) {
    final String str = "(1 + 3 *   (14 / 7))";
    final Scanner scanner = new Scanner(str).useDelimiter("\\s+|\\(|\\)");
    while (scanner.hasNext()) {
      System.out.println(scanner.next());
    }
  }

  private final class TreeHelper {

  }

  private Expression convert(final Expression treeNode) {
    if (treeNode instanceof BinaryNode) {
      final BinaryNode binaryNode = (BinaryNode) treeNode;
      return builder.createBinaryOperationExpression(
          convert(binaryNode.left),
          binaryNode.operator,
          convert(binaryNode.right));
    } else if (treeNode instanceof UnaryNode) {
      final UnaryNode unaryNode = (UnaryNode) treeNode;
      return builder.createUnaryOperationExpression(
          unaryNode.operator,
          convert(unaryNode.child));
    }
    return treeNode;
  }

  /*
   **************************************************
   * Class definition.
   **************************************************
   */

  private abstract class AbstractNode implements Expression {

    @Override
    public double eval() {
      throw new RuntimeException("Parse Error");
    }
  }

  private final class BinaryNode extends AbstractNode {
    private final BinaryOperator operator;
    private Expression left, right;

    private BinaryNode(BinaryOperator operator, Expression left, Expression right) {
      this.operator = operator;
      this.left = left;
      this.right = right;
    }

  }

  /**
   * Used to build support for order of operations without contaminating the
   * Expression interface
   */
  private final class UnaryNode extends AbstractNode {
    private final UnaryOperator operator;
    private Expression child;

    private UnaryNode(UnaryOperator operator, Expression child) {
      this.operator = operator;
      this.child = child;
    }
  }
}
