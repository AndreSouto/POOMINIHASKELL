package br.unb.poo.mh;

import Sources.ExpressaoBaseVisitor;
import Sources.ExpressaoParser;

public class ExprVisitor extends ExpressaoBaseVisitor<Double> {

    @Override
    public Double visitOpExpr(ExpressaoParser.OpExprContext ctx) {
        double left = visit(ctx.left);
        double right = visit(ctx.right);
        String op = ctx.op.getText();
        switch (op.charAt(0)) {
            case '*': return left * right;
            case '/': return left / right;
            case '+': return left + right;
            case '-': return left - right;
            default: throw new IllegalArgumentException("Unknown operator " + op); // tipo lógico não implementados ainda
        }
    }

    @Override
    public Double visitStart(ExpressaoParser.StartContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Double visitAtomExpr(ExpressaoParser.AtomExprContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    @Override
    public Double visitParenExpr(ExpressaoParser.ParenExprContext ctx) {
        return this.visit(ctx.expr());
    }
}

