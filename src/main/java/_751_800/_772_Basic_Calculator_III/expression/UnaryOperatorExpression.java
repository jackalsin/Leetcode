package _751_800._772_Basic_Calculator_III.expression;


import _751_800._772_Basic_Calculator_III.operator.UnaryOperator;

/**
 * @author jacka
 * @version 1.0 on 3/22/2018.
 */
public final class UnaryOperatorExpression implements Expression {
  private final UnaryOperator operator;

  private final Expression op;

  public UnaryOperatorExpression(UnaryOperator operator, Expression op) {
    this.operator = operator;
    this.op = op;
  }

  @Override
  public double eval() {
    return operator.apply(op.eval());
  }

  @Override
  public String toString() {
    return new StringBuilder().append(" ( ").
        append(operator.toString()).append(op.toString()).
        append(" ) ").toString();
  }
}
