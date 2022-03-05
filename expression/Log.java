package expression;

public class Log extends AbstractBinaryOperation {

    public Log(MarkExpression expLeft, MarkExpression expRight) {
        super("//", 200, expLeft, expRight, false, false);
    }

    @Override
    protected int calculate(int left, int right) {
        int res = 0;
        if (right <= 0 || right == 1 || left <= 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        while (left >= right) {
            left /= right;
            res++;
        }
        return res;
    }
}
