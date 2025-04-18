package ast.call

import ast.expr.Expr

data class Call(val name: String, val args: List<Expr>)