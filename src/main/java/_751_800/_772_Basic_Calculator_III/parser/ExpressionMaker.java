package _751_800._772_Basic_Calculator_III.parser;

import _751_800._772_Basic_Calculator_III.expression.BinaryOperatorExpression;
import _751_800._772_Basic_Calculator_III.expression.Expression;
import _751_800._772_Basic_Calculator_III.expression.NumberExpression;
import _751_800._772_Basic_Calculator_III.expression.UnaryOperatorExpression;
import _751_800._772_Basic_Calculator_III.operator.BinaryOperator;
import _751_800._772_Basic_Calculator_III.operator.UnaryOperator;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class ExpressionMaker {

  public Expression createBinaryOperationExpression(Expression op1, BinaryOperator op, Expression op2) {
    return new BinaryOperatorExpression(op1, op, op2);
  }

  public Expression createUnaryOperationExpression(UnaryOperator operator, Expression opperand) {
    return new UnaryOperatorExpression(operator, opperand);
  }

  public Expression createNumberExpression(double value) {
    return new NumberExpression(value);
  }
}
