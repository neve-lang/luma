package cli.mode

/**
 * Tiny union-like sealed class that determines whether Luma should run as a REPL or normally.
 */
sealed class Mode {
    data class Normal(val filename: String) : Mode()
    data object Repl : Mode()
}