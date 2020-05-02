import java.io.File

object HandleFiles {


  def getFiles(file: File) = {
      if(file.isDirectory) file
        .listFiles(_.isFile)
        .toList
      else if (file.isFile) List(file)
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

  def getAllFiles(name: String):List[File] = {
    val file = new File(name)
    getFiles(file) ++ getSub(file)
  }
}

