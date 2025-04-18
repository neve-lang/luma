package cli

import cli.mode.Mode

class Args(private val themselves: Array<String>) {
    companion object {
        fun from(themselves: Array<String>): Args {
            return Args(themselves)
        }
    }

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