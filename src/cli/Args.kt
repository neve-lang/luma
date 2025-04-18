package cli

import cli.mode.Mode

/**
 * Very simple argument parser for Luma (and Mariyoko).
 */
class Args(private val themselves: Array<String>) {
    companion object {
        /**
         * Creates an [Args] instance from the array of strings given in `main`.
         */
        fun from(themselves: Array<String>): Args {
            return Args(themselves)
        }
    }

    /**
     * Determines the execution [Mode] based on the arguments given.
     *
     * @see Mode
     */
    fun mode() = when {
        themselves.isNotEmpty() -> Mode.Normal(filename())
        else -> Mode.Repl
    }

    private fun filename(): String {
        require(themselves.isNotEmpty()) {
            "filename() may only be called when `themselves.isNotEmpty()`"
        }

        return themselves[0]
    }
}