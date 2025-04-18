package tok

import loc.Loc

data class Tok(val kind: TokKind, val lexeme: String, val loc: Loc) {
    companion object {
        /**
         * @return a [Tok] with [TokKind.EOF], empty [lexeme] and the [loc] given.
         */
        fun eof(loc: Loc): Tok {
            return Tok(TokKind.EOF, "", loc)
        }
    }

    /**
     * @return whether a [Tok] has [kind] of [TokKind.EOF].
     */
    fun isEof(): Boolean {
        return kind == TokKind.EOF
    }
}