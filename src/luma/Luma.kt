package luma

import java.io.File

/**
 * Wrapper around the Luma “runtime.”
 *
 * Takes care of ordering each step (i.e. lexing, parsing, etc.)
 */
class Luma {
    /**
     * Reads a file and executes it, or halts with an error message if no such file is found.
     */
    fun run(filename: String) {
        // TODO: actually implement Luma
        File(filename).forEachLine {
            println(it)
        }
    }
}