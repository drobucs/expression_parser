package expression;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractBinaryOperation extends AbstractExpression {
    protected final MarkExpression expLeft;
    protected final MarkExpression expRight;
    private final boolean associative;
    private final boolean alwaysBrackets;

    public AbstractBinaryOperation(final String operation, final int priority, final MarkExpression expLeft,
                                   final MarkExpression expRight, final boolean associative,
                                   final boolean alwaysBrackets) {
        super(" " + operation + " ", priority);
        this.expLeft = expLeft;
        this.expRight = expRight;
        this.associative = associative;
        this.alwaysBrackets = alwaysBrackets;
    }


    protected abstract int calculate(int left, int right);

    protected boolean getAlwaysBrackets() {
        return alwaysBrackets;
    }

    @Override
    public int evaluate(int x) {
        return calculate(expLeft.evaluate(x), expRight.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(expLeft.evaluate(x, y, z), expRight.evaluate(x, y, z));
    }

    @Override
    public boolean equals(Object exp) {
        if (exp == null || exp.getClass() != this.getClass()) {
            return false;
        }
        return ((AbstractBinaryOperation) exp).expLeft.equals(expLeft)
                && ((AbstractBinaryOperation) exp).expRight.equals(expRight);
    }

    @Override
    public String toString() {
        return "(" + expLeft.toString() + value.toString() + expRight.toString() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(expLeft, expRight, associative, alwaysBrackets, priority);
    }

    @Override
    public String toMiniString() {
        String left = expLeft.toMiniString();
        String right = expRight.toMiniString();
        if (isLeftBrackets()) {
            left = "(" + left + ")";
        }
        if (isRightBrackets()) {
            right = "(" + right + ")";
        }
        return left + value.toString() + right;
    }

    private boolean isLeftBrackets() {
        return expLeft.getPriority() > priority;
    }

    private boolean isRightBrackets() {
        return priority <= expRight.getPriority()
                && (alwaysBrackets
                || priority < expRight.getPriority()
                || !associative
                || ((AbstractBinaryOperation) expRight).getAlwaysBrackets());
    }

}
