
package de.zeigermann.compilerSandbox.parser.v4.nocontext;

import de.zeigermann.compilerSandbox.ast.*;
import de.zeigermann.compilerSandbox.ast.Number;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprV4ASTCreationVisitor<T> {
	T visitStart(ExprV4ASTCreationParser.StartContext ctx);
	T visitExpr(ExprV4ASTCreationParser.ExprContext ctx);
}