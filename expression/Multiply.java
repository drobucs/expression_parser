package expression;

public class Multiply extends AbstractBinaryOperation {

    public Multiply(final MarkExpression expLeft, final MarkExpression expRight) {
        super("*", 300, expLeft, expRight, true, false);
    }

    @Override
    public int calculate(int left, int right) {
        return left * right;
    }

}
