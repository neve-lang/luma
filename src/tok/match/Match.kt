package tok.match

import tok.TokKind
import tok.TokKind.*

/**
 * Tiny wrapper around the mechanism of recognizing tokens from source code.
 */
object Match {
    private val KEYWORDS = mapOf(
        "in" to IN,
        "nat" to NAT,
        "whole" to WHOLE,
        "zahl" to ZAHL,
        "quot" to QUOT,
        "real" to REAL
    )

    private val ONE_CHAR = mapOf(
        '+' to PLUS,
        '-' to MINUS,
        '*' to STAR,
        '/' to SLASH,
        '>' to GT,
        '<' to LT,
        ',' to COMMA,
        '|' to PIPE,
        '(' to LPAREN,
        ')' to RPAREN,
        '=' to ASSIGN
    )

    private val TWO_CHAR = mapOf(
        "==" to EQ,
        "!=" to NEQ,
        ">=" to GTE,
        "<=" to LTE
    )

    /**
     * @return a [TokKind] if a matching [lexeme] is found, or [UNEXPECTED] otherwise.
     */
    fun match(lexeme: String): TokKind {
        return TWO_CHAR[lexeme] ?: ONE_CHAR[lexeme.first()] ?: UNEXPECTED
    }

    /**
     * @return whether a [TokKind] has a lexeme that spans two source code characters.
     */
    fun isTwoChars(kind: TokKind): Boolean {
        return TWO_CHAR.containsValue(kind)
    }

    /**
     * @return a keyword [TokKind], or `null` otherwise.
     */
    fun asKeyword(lexeme: String): TokKind? {
        return KEYWORDS[lexeme]
    }
}