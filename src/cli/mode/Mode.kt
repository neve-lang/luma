package cli.mode

sealed class Mode {
    data class Normal(val filename: String) : Mode()
    data object Repl : Mode()
}