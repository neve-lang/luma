package domain.interval

/**
 * Represents an infinite interval (unless `min == max`) of values, from [min] to [max].
 */
data class Interval(val min: Edge, val max: Edge, val predicate: Predicate = Predicate.none()) {
    /**
     * Flips the [Interval]’s [min] and [max] edges **if they can be flipped**,
     * i.e. if `min >= max`.
     *
     * This is useful in cases of negation.
     *
     * @return the flipped [Interval] if it can be flipped, the interval unchanged otherwise.
     */
    fun flip(): Interval {
        return if (min.value() > max.value())
            Interval(max, min, predicate)
        else
            this
    }
}