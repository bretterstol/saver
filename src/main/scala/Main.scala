
object Main {
  def main(args: Array[String]): Unit = {
    val root = "/home/retterstol/Documents/"
    val files = HandleFiles.getAllFiles(root)
      .filter(!_.isHidden)
    files
      .filter {
        f =>
          !saveFiles.checkFile(f)
      }
      .map {
        file =>
          aws.upload(file)
      }
    saveFiles.saveFiles(files)
  }
}
