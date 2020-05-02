import java.io.File

import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.{AmazonS3ClientBuilder}

import scala.util.Try

object aws {
  val s3 = AmazonS3ClientBuilder.standard().withRegion("eu-north-1").build()
  implicit val rootName = "/home/retterstol/Documents/"
  def upload(file: File)  = {
    val request = new PutObjectRequest("fedora-saver", removeRoot(file), file)
    Try(s3.putObject(request))
  }

  def removeRoot(file: File)(implicit rootName: String) =
    file.getPath.replace(rootName, "")
}
