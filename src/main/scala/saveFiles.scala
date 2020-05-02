import java.io.{File, FileInputStream}
import java.security.{DigestInputStream, MessageDigest}

object saveFiles {
  def saveFiles(files: List[File]) = files
    .filter(f => !checkFile(f))
    .map(f => redis.set(f, getHashsum(f)))

  def getHashsum(file : File) = {
    val buffer = new Array[Byte](8192)
    val md5 = MessageDigest.getInstance("MD5")

    val dis = new DigestInputStream(new FileInputStream(new File(file.getPath)), md5)
    try { while (dis.read(buffer) != -1) { } } finally { dis.close() }

    md5.digest.map("%02x".format(_)).mkString
  }

  def checkFile(file: File) = {
    val checkSum = redis.get(file.getPath) match {
      case Some(a) => a
      case None => ""
    }
    println(checkSum == getHashsum(file))
    checkSum == getHashsum(file)
  }
}
