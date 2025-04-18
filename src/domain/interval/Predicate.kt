package domain.interval

/**
 * Represents a limitation within an [Interval].
 *
 * # Example
 *
 * The interval of natural numbers can’t just be defined as:
 *
 * ```
 * Interval(
 *     min = Edge.Excl(0)
 *     max = Edge.Excl(Double.POSITIVE_INFINITY)
 * )
 * ```
 *
 * Because by that logic, `55.4` would be included, whereas it’s actually a
 * rational number.  So we give it the predicate:
 *
 * ```
 * Interval(
 *     ...,
 *     predicate = Predicate(Double::isWhole)
 * )
 * ```
 */
data class Predicate(val itself: (Double) -> Boolean) {
    companion object {
        /**
         * Represents no predicate at all.
         */
        fun none() = Predicate { true }
    }
}