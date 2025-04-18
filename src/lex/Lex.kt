package lex

import lex.chars.Chars
import loc.Tracker
import tok.Tok
import tok.TokKind
import tok.match.Match
import util.char.isFromId
import util.char.isId
import util.char.isInsignificant

class Lex(src: String) {
    private val chars = Chars(src)
    private val tracker = Tracker()

    private fun advance(): Char? {
        return chars.pop()?.also { tracker.capture(it) }
    }

    fun next(): Tok {
        skipWs()
        sync()

        if (isAtEnd()) {
            return Tok.eof(tracker.loc())
        }

        return advance()!!.let {
            when {
                it.isFromId() -> id()
                it.isDigit() -> num()

                it == '\n' -> newline()
                else -> simple()
            }
        }
    }

    private fun id(): Tok {
        return takeWhile(Char::isId).run {
            tracker.make(
                kind = Match.asKeyword(tracker.lexeme()) ?: TokKind.ID
            )
        }
    }

    private fun num(): Tok {
        takeWhile(Char::isDigit)

        if (match('.')) {
            takeWhile(Char::isDigit)
        }

        return tracker.make(TokKind.NUM)
    }

    private fun simple(): Tok {
        val kind = Match.match(tracker.lexeme() + peek())

        return tracker.make(
            if (Match.isTwoChars(kind))
                kind.also { advance()?.let { tracker.capture(it) } }
            else
                kind
        )
    }

    private fun newline(): Tok {
        return tracker.newline()
    }

    private fun skipWs() {
        takeWhile(Char::isInsignificant)
    }

    private fun match(some: Char): Boolean {
        if (peek() == some) {
            advance()
            return true
        }

        return false
    }

    private fun takeWhile(predicate: (Char) -> Boolean) {
        if (isAtEnd() || !predicate(peek()!!)) {
            return
        }

        advance()
        takeWhile(predicate)
    }

    private fun peek(): Char? {
        return chars.peek()
    }

    private fun sync() {
        tracker.sync()
    }

    private fun isAtEnd(): Boolean {
        return chars.isAtEnd()
    }
}