package expression.parser;

public class StringCharSource implements CharSource {
    private final String string;
    private int pos;

    public StringCharSource(String string) {
        this.string = string;
        pos = -1;
    }

    public char back() {
        return string.charAt(--pos);
    }

    public char getCurrent() {
        return string.charAt(pos);
    }

    @Override
    public char next() {
        return string.charAt(++pos);
    }

    @Override
    public boolean hasNext() {
        return pos + 1 < string.length();
    }

    @Override
    public IllegalArgumentException error(String message) {
        return new IllegalArgumentException(String.format(
                "%d: %s",
                pos, message
        ));
    }
}
