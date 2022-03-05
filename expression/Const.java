package expression;

public class Const extends AbstractElement {

    public Const(final int value) {
        super(value);
    }

    @Override
    public int evaluate(int varValue) {
        return (Integer)value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return evaluate(x);
    }

}
