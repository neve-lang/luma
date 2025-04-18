package ast.decl.`fun`

import ast.expr.Expr

/**
 * A function declaration.
 */
data class FunDecl(val name: String, val params: List<Param>, val body: Expr)