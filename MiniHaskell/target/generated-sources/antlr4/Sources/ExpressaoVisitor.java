package Sources;
// Generated from Expressao.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressaoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressaoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressaoParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExpressaoParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link ExpressaoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(ExpressaoParser.OpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ExpressaoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(ExpressaoParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ExpressaoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ExpressaoParser.ParenExprContext ctx);
}