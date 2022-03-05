package expression.parser;

import expression.*;

public class ExpressionParser extends BaseParser implements Parser {
    private final String[][] OPERATIONS = {
            {"*", "/"},
            {"+", "-"},
            {"<<", ">>", ">>>"}
    };

    public ExpressionParser(final CharSource source) {
        super(source);
    }

    public ExpressionParser() {
        this(null);
    }

    @Override
    public TripleExpression parse(final String expression) {
        startParse(new StringCharSource(expression));
        return parseXElement(OPERATIONS.length + 1);
    }

    // 1Element -> const, variable, (expression)
    // XElement -> [x - 1]Element [x priority operation] [x - 1]Element, [x - 1]Element
    private MarkExpression parse1Element() {
        skipWhitespace();
        if (take('(')) {
            final MarkExpression exp = parseXElement(OPERATIONS.length + 1);
            skipWhitespace();
            expect(')');
            return exp;
        } else if (take('-')) {
            if (between('0', '9')) {
                return new Const(parseNumber(true));
            } else {
                return new Negate(parse1Element());
            }
        } else if (take('t')) {
            expect('0');
            return new TZero(parse1Element());
        } else if (take('l')) {
            expect('0');
            return new LZero(parse1Element());
        } else if (between('0', '9')) {
            return new Const(parseNumber(false));
        } else if (take('x')) {
            return new Variable("x");
        } else if (take('y')) {
            return new Variable("y");
        } else if (take('z')) {
            return new Variable("z");
        } else {
            throw error("Unexpected symbol in parse1Element : " + getCh());
        }
    }

    // 1 <= x <= OPERATION.length + 1
    private MarkExpression parseXElement(final int x) {
        if (x == 1) {
            return parse1Element();
        }
        skipWhitespace();
        MarkExpression exp = parseXElement(x - 1);
        boolean isNewOperation;
        do {
            skipWhitespace();
            isNewOperation = false;
            for (final String operation : OPERATIONS[x - 2]) {
                if (take(operation.charAt(0))) {
                    isNewOperation = true;
                    exp = expByOperation(exp, operation, x);
                    break;
                }
            }
        } while (isNewOperation);
        return exp;
    }

    private int parseNumber(final boolean negate) {
        final StringBuilder sb = new StringBuilder();
        if (negate) {
            sb.append('-');
        }
        while (between('0', '9')) {
            sb.append(take());
        }
        return Integer.parseInt(sb.toString());
    }

    private MarkExpression expByOperation(final MarkExpression exp, final String operation, final int x) {
        if (startsWith(operation, '*')) {
            if (take('*')) {
                return new Pow(exp, parseXElement(x - 1));
            }
           return new Multiply(exp, parseXElement(x - 1));
        } else if (startsWith(operation, '/')) {
            if (take('/')) {
                return new Log(exp, parseXElement(x - 1));
            }
            return new Divide(exp, parseXElement(x - 1));
        } else if (startsWith(operation, '+')) {
            return new Add(exp, parseXElement(x - 1));
        } else if (startsWith(operation, '-')) {
            return new Subtract(exp, parseXElement(x - 1));
        } else if (startsWith(operation, '<')) {
            expect('<');
            return new ShiftLeft(exp, parseXElement(x - 1));
        } else if (startsWith(operation, '>')) {
            expect('>');
            if (take('>')) {
                return new ArithmeticalShiftRight(exp, parseXElement(x - 1));
            }
            return new ShiftRight(exp, parseXElement(x - 1));
        }
        throw error("Unexpected operation -> operation[0] = '" + operation.charAt(0) + "'");
    }

    private static boolean startsWith(final String operation, final char c) {
        return operation.charAt(0) == c;
    }
}
