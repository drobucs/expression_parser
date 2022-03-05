package expression.parser;

public interface CharSource {
    char back();
    char next();
    boolean hasNext();
    IllegalArgumentException error(String message);
    char getCurrent();
}
