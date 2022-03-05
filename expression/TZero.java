package expression;

public class TZero extends AbstractUnaryOperation {

    public TZero(MarkExpression exp) {
        super(exp, "t0");
    }

    @Override
    public int calculate(int val) {
        if (val == 0) {
            return 32;
        }
        int counter = 0;
        while (val % 2 == 0) {
            counter++;
            val /= 2;
        }
        return counter;
    }

}
