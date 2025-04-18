package ast.decl

import ast.call.Call
import ast.decl.`fun`.FunDecl

/**
 * All kinds of valid declarations in Luma.
 */
sealed class Decl {
    data class OfFun(val decl: FunDecl) : Decl()
    data class OfCall(val call: Call) : Decl()
}