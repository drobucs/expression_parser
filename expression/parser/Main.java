package expression.parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println("""
                enter expression with three variable x, y, z and constants
                binary operations : '+', '-', '*', '/', '//', '>>', '<<', '>>>', '**'
                unary operations: '-', 'abs', 'l0', 't0'""");
       ExpressionParser parser = new ExpressionParser();
       Scanner in = new Scanner(System.in);
       String str = in.nextLine();
       System.out.println(parser.parse(str).toMiniString());
       System.out.println(parser.parse(str));
       System.out.println("enter 3 numbers:");
       int x = in.nextInt();
       int y = in.nextInt();
       int z = in.nextInt();
       System.out.println("result = " + parser.parse(str).evaluate(x, y, z));
    }
}
