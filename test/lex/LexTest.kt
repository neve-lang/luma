package lex

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import tok.Tok
import tok.TokKind
import tok.TokKind.*

class LexTest {
    @Test
    fun testOne() {
        assertEquals(
            listOf(
                ID, LPAREN, ID, PIPE, ID, IN, NAT, RPAREN, ASSIGN, ID, PLUS, ID, LPAREN, ID, PLUS, NUM, RPAREN
            ), "f(x | x in nat) = x + f(x + 1)".lex()
        )
    }

    @Test
    fun testTwo() {
        assertEquals(
            listOf(
                ID, LPAREN, NUM, RPAREN, ASSIGN, NUM
            ),
            "f(0) = 0".lex()
        )
    }

    @Test
    fun testThree() {
        assertEquals(
            listOf(
                ID, LPAREN, ID, RPAREN, ASSIGN, ID, PLUS, ID, LPAREN, ID, PLUS, NUM, RPAREN
            ),
            "f(x) = x + f(x + 0.1)".lex()
        )
    }

    @Test
    fun testFour() {
        assertEquals(
            listOf(
                ID, LPAREN, ID, PIPE, ID, GTE, NUM, RPAREN, ASSIGN, ID
            ),
            "f(x | x >= 0) = x".lex()
        )
    }

    @Test
    fun testFive() {
        assertEquals(
            listOf(
                ID, LPAREN, ID, RPAREN, ASSIGN, UNEXPECTED
            ),
            "f(x) = @".lex()
        )
    }
}

fun Lex.all(): List<Tok> {
    val tokInList = listOf(next())

    if (tokInList.first().isEof()) {
        return emptyList()
    }

    return tokInList + all()
}

fun List<Tok>.simplified(): List<TokKind> {
    return map { it.kind }
}

fun String.lex(): List<TokKind> {
    return Lex(this).all().simplified()
}