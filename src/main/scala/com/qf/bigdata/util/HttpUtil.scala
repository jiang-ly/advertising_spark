package com.qf.bigdata.util

import org.apache.http.client.methods.{CloseableHttpResponse, HttpGet}
import org.apache.http.impl.client.{CloseableHttpClient, HttpClients}
import org.apache.http.util.EntityUtils


object HttpUtil {
  def httpUtil(jd:Double,wd:Double)={
    var url =s"https://restapi.amap.com/v3/geocode/regeo?location=${jd},${wd}&key=a36400c0638b739d1422ae33b5cd487b&radius=1000&extensions=all"
    val client: CloseableHttpClient = HttpClients.createDefault()
    val get: HttpGet = new HttpGet(url)
    val response: CloseableHttpResponse = client.execute(get)
    val str: String = EntityUtils.toString(response.getEntity(), "UTF-8")
    println(str)
  }
}
