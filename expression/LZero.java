package expression;

public class LZero extends AbstractUnaryOperation {

    public LZero(MarkExpression exp) {
        super(exp, "l0");
    }

    @Override
    public int calculate(int val) {
        int counter = 0;
        while (val != 0) {
            counter++;
            val >>>= 1;
        }
        return 32 - counter;
    }
}
