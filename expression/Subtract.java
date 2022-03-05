package expression;

public class Subtract extends AbstractBinaryOperation {

    public Subtract(final MarkExpression expLeft, final MarkExpression expRight) {
        super("-", 400, expLeft, expRight, false, false);
    }

    @Override
    public int calculate(int left, int right) {
        return left - right;
    }

}
