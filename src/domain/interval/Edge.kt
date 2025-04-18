package domain.interval

/**
 * An edge within an interval.
 */
sealed class Edge {
    /**
     * An inclusive edge within an interval.
     */
    data class Incl(val value: Double) : Edge()

    /**
     * An exclusive edge within an interval.
     */
    data class Excl(val value: Double) : Edge()

    /**
     * @return the value stored in the [Edge].
     */
    fun value() = when (this) {
        is Incl -> value
        is Excl -> value
    }
}