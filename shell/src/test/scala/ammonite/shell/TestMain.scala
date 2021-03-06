package ammonite.shell

import ammonite.repl.Storage
import ammonite.ops._
/**
 * Convenience entry-point useful to kick off a shell with
 */
object TestMain {
  val examplePredef = "shell/src/main/resources/ammonite/shell/example-predef-bare.scala"
  def main(args: Array[String]): Unit = {
    System.setProperty("ammonite-sbt-build", "true")
    ammonite.repl.Main(
      storageBackend = new Storage.Folder(cwd/'target/'tempAmmoniteHome){
        override val predef = cwd/RelPath(examplePredef)
      }
    ).run()
  }
}
