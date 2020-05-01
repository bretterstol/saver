
object Main {
  def main(args: Array[String]): Unit = {
    val root = "/home/retterstol/src/asmund.best"
    val files = HandleFiles.getAllFiles(root)
      .filter(x => removeHidden(x.path))
      .map(x => dirFile(x.path.replaceAll(root, ""), x.file))
    files.foreach(x => println(x.path, x.file.getName))
  }

  def removeHidden(path: String) = "\\/\\.".r.findFirstMatchIn(path) match {
    case Some(_) => false
    case None => true
  }
}
