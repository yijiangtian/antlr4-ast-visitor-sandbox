package de.zeigermann.compilerSandbox.parser.v4.nocontext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import de.zeigermann.compilerSandbox.ast.Expression;
import de.zeigermann.compilerSandbox.parser.ExpressionParser;
import de.zeigermann.compilerSandbox.parser.v4.nocontext.ExprV4ASTCreationParser.StartContext;


public class V4ExpressionParser extends ExpressionParser  {
	
    public Expression parseExpression(String expr) {
    	CharStream input = new ANTLRInputStream(expr);
    	ExprV4ASTCreationLexer lexer = new ExprV4ASTCreationLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprV4ASTCreationParser parser = new ExprV4ASTCreationParser(tokens);
		StartContext ctx = parser.start();
		return ctx.expression;
    }
}
