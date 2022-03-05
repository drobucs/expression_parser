package expression;

import java.math.BigDecimal;

public abstract class AbstractElement extends AbstractExpression {

    public AbstractElement(final Object value) {
        super(value, 100);
    }

    @Override
    public abstract int evaluate(int varValue);

    @Override
    public abstract int evaluate(int x, int y, int z);

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String toMiniString() {
        return toString();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object exp) {
        if (exp == null || exp.getClass() != this.getClass()) {
            return false;
        }
        return exp.toString().equals(value.toString());
    }
}
