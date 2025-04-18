package lex

import loc.Loc
import tok.Tok
import tok.TokKind

/**
 * Helper for [Lex]; tracks position in the source code *and* the current lexeme being built.
 */
class Tracker {
    private var line: Int = 1
    private var lexeme: StringBuffer = StringBuffer()

    /**
     * Tracks a newline in the source code.
     *
     * @return a [TokKind.NEWLINE] token.
     */
    fun newline(): Tok {
        line++
        return make(TokKind.NEWLINE)
    }

    /**
     * Resets the [lexeme] being built.
     */
    fun sync() {
        lexeme = StringBuffer()
    }

    /**
     * @return the [lexeme] being built *as a String*.
     */
    fun lexeme(): String {
        return lexeme.toString()
    }

    /**
     * Captures a character and stores it in the [lexeme] being built.
     */
    fun capture(some: Char) {
        lexeme.append(some)
    }

    /**
     * @return the current position.
     */
    fun loc(): Loc {
        return Loc(line)
    }

    /**
     * @return a [Tok] with kind [kind] and the [lexeme] and [loc] currently being tracked.
     */
    fun make(kind: TokKind): Tok {
        return Tok(kind, lexeme(), loc())
    }
}