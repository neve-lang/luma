package ast.expr

import ast.binop.BinOp
import ast.call.Call

/**
 * Expressions supported by Luma.
 */
sealed class Expr {
    /**
     * A number literal.
     */
    data class Lit(val value: Double) : Expr()

    /**
     * A negation node.
     */
    data class Neg(val expr: Expr) : Expr()

    /**
     * Represents the inverse of [expr].
     */
    data class Inv(val expr: Expr) : Expr()

    /**
     * Wrapper around [BinOp].
     */
    data class OfBinOp(val binOp: BinOp) : Expr()

    /**
     * Wrapper around [Call].
     *
     * Not to be confused with [ast.decl.Decl.OfCall]: this one represents a function call
     * *inside* a function, as in:
     *
     * ```
     * f(x) = x + f(x + 1)
     *            -------- here
     * ```
     *
     * Whereas an [ast.decl.Decl.OfCall] may only appear at top-level code:
     *
     * ```
     * f(5)
     * ```
     */
    data class OfCall(val call: Call) : Expr()
}