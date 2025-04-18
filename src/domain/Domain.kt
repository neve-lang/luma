package domain

import domain.interval.Interval

/**
 * Represents all the values defined for a specific symbol.
 *
 * # Example
 *
 * In this example:
 *
 * ```
 * f(x | x in nat) = ...
 * ```
 *
 * `x` has the domain:
 *
 * ```
 * Domain(listOf(
 *     Interval(min = Edge.Excl(0), max = Edge.Excl(Double.POSITIVE_INFINITY)
 * ))
 * ```
 */
data class Domain(val intervals: List<Interval>)