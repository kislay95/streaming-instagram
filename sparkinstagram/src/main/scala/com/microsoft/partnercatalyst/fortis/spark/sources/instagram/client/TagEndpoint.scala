package com.microsoft.partnercatalyst.fortis.spark.sources.instagram.client

import scala.io.Source

case class Tag(name: String)

@SerialVersionUID(100L)
class InstagramTagClient(tag: Tag, auth: Auth) extends InstagramClient(auth) {
  override protected def fetchInstagramResponse(): String = {
    val url = s"https://${auth.apiHost}/v1/tags/${tag.name}/media/recent?access_token=${auth.accessToken}"
    Source.fromURL(url).mkString
  }
}