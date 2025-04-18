package mariyoko

import java.io.File

class Luma {
    fun run(filename: String) {
        // TODO: actually implement Mariyoko
        File(filename).forEachLine {
            println(it)
        }
    }
}