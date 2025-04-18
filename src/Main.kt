import cli.Args
import cli.mode.Mode
import cli.repl.Repl
import mariyoko.Luma

fun main(args: Array<String>) = when (val mode = Args.from(args).mode()) {
    is Mode.Normal -> Luma().run(mode.filename)
    is Mode.Repl -> Repl().run()
}
