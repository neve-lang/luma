package ast.binop

import ast.expr.Expr

/**
 * All kinds of supported binary operations in Luma.
 */
sealed class BinOp {
    /**
     * Adding two operands together.
     *
     * This node is also used for subtraction: we simply modify the [right]
     * node to be an [Expr.Neg] of the original one.
     */
    data class Add(val left: Expr, val right: Expr) : BinOp()

    /**
     * Multiplying two operands together.
     *
     * This node is also used for division: we simply modify the [right]
     * node to be an [Expr.Inv] of the original one.
     */
    data class Mul(val left: Expr, val right: Expr) : BinOp()
}