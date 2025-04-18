package ast.program

import ast.decl.Decl

/**
 * Represents a Luma program.
 */
data class Program(val decls: List<Decl>)