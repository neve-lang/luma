package loc

import tok.Tok
import tok.TokKind

class Tracker {
    private var line: Int = 1
    private var lexeme: StringBuffer = StringBuffer()

    fun newline(): Tok {
        line++
        return make(TokKind.NEWLINE)
    }

    fun sync() {
        lexeme = StringBuffer()
    }

    fun lexeme(): String {
        return lexeme.toString()
    }

    fun capture(some: Char) {
        lexeme.append(some)
    }

    fun loc(): Loc {
        return Loc(line)
    }

    fun make(kind: TokKind): Tok {
        return Tok(kind, lexeme(), loc())
    }
}