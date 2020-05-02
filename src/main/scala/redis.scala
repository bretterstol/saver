import java.io.File

import com.redis._

object redis {
  val redis = new RedisClient("localhost", 6379)

  def set(file: File, hash: String) = redis.set(file.getPath, hash)

  def get(key: String) = redis.get(key)
}
