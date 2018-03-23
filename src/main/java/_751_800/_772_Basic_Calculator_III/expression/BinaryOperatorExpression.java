package _751_800._772_Basic_Calculator_III.expression;

import _751_800._772_Basic_Calculator_III.operator.BinaryOperator;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class BinaryOperatorExpression implements Expression {
  private final Expression op1, op2;
  private final BinaryOperator op;

  public BinaryOperatorExpression(Expression op1, BinaryOperator op, Expression op2) {
    this.op1 = op1;
    this.op = op;
    this.op2 = op2;
  }

  @Override
  public double eval() {
    return op.apply(op1.eval(), op2.eval());
  }

  @Override
  public String toString() {
    return new StringBuilder().append("(").
        append(op1).append(" ").append(op).append(op2).
        append(")").toString();
  }
}
