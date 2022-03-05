package expression;

public class Pow extends AbstractBinaryOperation {

    public Pow(MarkExpression expLeft, MarkExpression expRight) {
        super("**", 200, expLeft, expRight, false, false);
    }

    @Override
    protected int calculate(int left, int right) {
        if (right == 0 || left == 1) {
            return 1;
        }
        if (left == -1) {
            return right % 2 == 0 ? 1 : -1;
        }
        int res = 1;
        for (int i = 0; i < right; ++i) {
            res *= left;
        }
        return res;
    }

}
