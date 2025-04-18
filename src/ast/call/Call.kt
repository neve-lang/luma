package ast.call

import ast.expr.Expr

/**
 * A function call.
 */
data class Call(val name: String, val args: List<Expr>)