package tok

import loc.Loc

data class Tok(val kind: TokKind, val lexeme: String, val loc: Loc) {
    companion object {
        fun eof(loc: Loc): Tok {
            return Tok(TokKind.EOF, "", loc)
        }
    }

    fun isEof(): Boolean {
        return kind == TokKind.EOF
    }
}