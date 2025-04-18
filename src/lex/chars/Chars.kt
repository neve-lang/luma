package lex.chars

/**
 * Tiny wrapper the source code that serves it one character at a time for [lex.Lex].
 */
class Chars(var src: String) {
    private var at: Int = 0

    /**
     * @return the next character in [src] and advances to the next.
     */
    fun pop(): Char? {
        return src.getOrNull(at).also { at += 1 }
    }

    /**
     * @return the next character in [src] but doesn’t advance.
     */
    fun peek(): Char? {
        return src.getOrNull(at)
    }

    /**
     * @return whether all characters in [src] were served.
     */
    fun isAtEnd(): Boolean {
        return at >= src.length
    }
}