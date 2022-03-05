package expression;

public class Variable extends AbstractElement {

    public Variable(final String var) {
        super(var);
    }

    @Override
    public int evaluate(int varValue) {
        return varValue;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return switch (value.toString()) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            default -> throw new AssertionError("Unknown variable");
        };
    }
}
