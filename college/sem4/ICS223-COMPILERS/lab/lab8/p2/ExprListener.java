// Generated from Expr.g by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExprParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExprParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#code_block}.
	 * @param ctx the parse tree
	 */
	void enterCode_block(ExprParser.Code_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#code_block}.
	 * @param ctx the parse tree
	 */
	void exitCode_block(ExprParser.Code_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(ExprParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(ExprParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ExprParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ExprParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expr(ExprParser.Arithmetic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expr(ExprParser.Arithmetic_exprContext ctx);
}