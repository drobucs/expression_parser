package expression;

public class ShiftLeft extends AbstractBinaryOperation {

    public ShiftLeft(MarkExpression expLeft, MarkExpression expRight) {
        super("<<", 500, expLeft, expRight, false, false);
    }

    @Override
    public int calculate(int left, int right) {
        return left << right;
    }

}
