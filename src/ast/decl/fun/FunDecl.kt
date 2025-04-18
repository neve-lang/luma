package ast.decl.`fun`

import ast.expr.Expr

data class FunDecl(val name: String, val params: List<Param>, val body: Expr)