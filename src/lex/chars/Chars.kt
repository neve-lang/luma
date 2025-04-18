package lex.chars

class Chars(var src: String) {
    private var at: Int = 0

    fun pop(): Char? {
        return src.getOrNull(at).also { at += 1 }
    }

    fun peek(): Char? {
        return src.getOrNull(at)
    }

    fun isAtEnd(): Boolean {
        return at >= src.length
    }
}