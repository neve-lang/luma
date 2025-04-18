package util.char

/**
 * In order to check whether [this] may be **from within** an identifier, use [Char.isId] instead.
 *
 * @return whether [this] may belong to **the beginning** of an identifier.
 */
fun Char.isFromId() = isLetter() || this == '_'

/**
 * @return whether [this] may belong to an identifier.
 */
fun Char.isId() = isLetterOrDigit() || this == '_'

/**
 * @return whether [this] is whitespace, excluding newline characters.
 */
fun Char.isInsignificant() = isWhitespace() && this != '\n'