package expression;

public class ShiftRight extends AbstractBinaryOperation {

    public ShiftRight(MarkExpression expLeft, MarkExpression expRight) {
        super(">>", 500, expLeft, expRight, false, false);
    }

    @Override
    public int calculate(int left, int right) {
        return left >> right;
    }

}
