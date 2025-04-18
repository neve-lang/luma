package util.char

/**
 * Returns whether [this] may belong to **the beginning** of an identifier.
 *
 * In order to check whether [this] may be **from within** an identifier, use [Char.isId] instead.
 */
fun Char.isFromId() = isLetter() || this == '_'

/**
 * Returns whether [this] may belong to an identifier.
 */
fun Char.isId() = isLetterOrDigit() || this == '_'

/**
 * Returns whether [this] is whitespace, excluding newline characters.
 */
fun Char.isInsignificant() = isWhitespace() && this != '\n'