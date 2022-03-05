package expression;

public class Divide extends AbstractBinaryOperation {

    public Divide(final MarkExpression expLeft, final MarkExpression expRight) {
        super("/", 300, expLeft, expRight, false, true);
    }

    @Override
    public int calculate(int left, int right) {
        return left / right;
    }

}
