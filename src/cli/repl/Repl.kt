package cli.repl

/**
 * Wrapper around the REPL mechanism.
 */
class Repl {
    /**
     * Runs the REPL continuously; it invokes an infinite loop.
     */
    fun run() {
        // TODO: actually implement the Repl
        while (true) {
            print("> ")
            readln()
        }
    }
}