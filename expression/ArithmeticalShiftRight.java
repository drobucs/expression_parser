package expression;

import java.math.BigDecimal;

public class ArithmeticalShiftRight extends AbstractBinaryOperation {
    public ArithmeticalShiftRight(MarkExpression expLeft, MarkExpression expRight) {
        super(">>>", 500, expLeft, expRight, false, false);
    }

    @Override
    public int calculate(int left, int right) {
        return left >>> right;
    }

}
