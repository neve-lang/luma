package ast.expr

import ast.binop.BinOp
import ast.call.Call

sealed class Expr {
    data class Lit(val value: Double) : Expr()
    data class Neg(val expr: Expr) : Expr()
    data class Inv(val expr: Expr) : Expr()

    data class OfBinOp(val binOp: BinOp) : Expr()
    data class OfCall(val call: Call) : Expr()
}