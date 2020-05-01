import java.io.File

object HandleFiles {

  private def createFile(file: File) = dirFile(file.getPath, file)

  def getFiles(file: File) = {
      if(file.isDirectory) file
        .listFiles(_.isFile)
        .toList
        .map(f => createFile(f))
      else if (file.isFile) List(createFile(file))
      else List()
  }

  def getDirs(file: File) = file
        .listFiles(_.isDirectory)
        .toList

  def getAllDirs(file: File):List[File] = getDirs(file) ++ getDirs(file).flatMap(f => getAllDirs(f))


  private def getSub(file: File) =
    for {
      dirs <- getAllDirs(file)
      files <- getFiles(dirs)
    } yield files

  def getAllFiles(name: String):List[dirFile] = {
    val file = new File(name)
    getFiles(file) ++ getSub(file)
  }
}

case class dirFile (path: String, file: File)