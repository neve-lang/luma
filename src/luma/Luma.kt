package luma

import java.io.File

class Luma {
    fun run(filename: String) {
        // TODO: actually implement Luma
        File(filename).forEachLine {
            println(it)
        }
    }
}