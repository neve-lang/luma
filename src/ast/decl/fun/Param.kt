package ast.decl.`fun`

import domain.Domain

/**
 * A parameter of a function.
 *
 * @param domain the domain that the param’s value must be in.
 */
data class Param(val name: String, val domain: Domain)