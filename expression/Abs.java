package expression;

import java.math.BigDecimal;

public class Abs extends AbstractUnaryOperation {

    public Abs(MarkExpression exp) {
        super(exp, "abs");
    }

    @Override
    protected int calculate(int val) {
        if (val >= 0) {
            return val;
        }
        return val;
    }
}
