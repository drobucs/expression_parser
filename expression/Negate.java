package expression;

public class Negate extends AbstractUnaryOperation {

    public Negate(MarkExpression exp) {
        super(exp, "-");
    }

    @Override
    public int calculate(int val) {
        return -val;
    }

}
