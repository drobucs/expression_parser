package expression;

public class Add extends AbstractBinaryOperation {

    public Add(final MarkExpression expLeft, final MarkExpression expRight) {
        super("+", 400, expLeft, expRight, true, false);
    }

    @Override
    public int calculate(int left, int right) {
        return left + right;
    }

}
