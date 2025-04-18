package ast.decl

import ast.call.Call
import ast.decl.`fun`.FunDecl

/**
 * All kinds of valid declarations in Luma.
 */
sealed class Decl {
    /**
     * Wrapper around [FunDecl].
     */
    data class OfFun(val decl: FunDecl) : Decl()

    /**
     * Wrapper around [Call].
     *
     * The reason we only allow [Call] nodes as [Decl]s is to allow for
     * simple function calls like:
     *
     * ```
     * f(0) = 0
     * f(x | x in nat) = x + f(x - 1)
     * f(5)
     * ```
     *
     * where the last expression would give you the number of recursive steps `f` takes
     * before it reaches the base case.
     */
    data class OfCall(val call: Call) : Decl()
}