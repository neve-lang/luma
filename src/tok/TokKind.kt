package tok

enum class TokKind {
    PLUS,
    MINUS,
    STAR,
    SLASH,

    LPAREN,
    RPAREN,

    ASSIGN,

    EQ,
    NEQ,
    GT,
    GTE,
    LT,
    LTE,

    ID,
    NUM,

    IN,
    NAT,
    WHOLE,
    ZAHL,
    QUOT,
    REAL,

    COMMA,
    PIPE,

    NEWLINE,
    EOF,
    UNEXPECTED;
}