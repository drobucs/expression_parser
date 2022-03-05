package expression;


public abstract class AbstractExpression implements MarkExpression {
    protected final int priority;
    protected final Object value;

    public AbstractExpression(final Object value, final int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public abstract int evaluate(int x, int y, int z);

    @Override
    public abstract int evaluate(int x);

    @Override
    public int getPriority() {
        return priority;
    }

}
