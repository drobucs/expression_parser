package expression;

public abstract class AbstractUnaryOperation extends AbstractExpression {
    protected final MarkExpression exp;

    public AbstractUnaryOperation(final MarkExpression exp, final String operation) {
        super(operation, 0);
        this.exp = exp;
    }

    protected abstract int calculate(int val);

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(exp.evaluate(x, y, z));
    }

    @Override
    public int evaluate(int x) {
        return calculate(exp.evaluate(x));
    }

    @Override
    public String toString() {
        return value.toString() + "(" + exp.toString() + ")";
    }

    @Override
    public String toMiniString() {
        if (exp.getPriority() <= 100) {
            return value.toString() + " " + exp.toMiniString();
        }
        return value.toString() + "(" + exp.toMiniString() + ")";
    }

    @Override
    public int hashCode() {
        return value.hashCode() * exp.hashCode();
    }

}
