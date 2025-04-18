package domain.interval

sealed class Edge {
    data class Incl(val value: Double) : Edge()
    data class Excl(val value: Double) : Edge()
}