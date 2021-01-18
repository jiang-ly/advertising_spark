package com.qf.bigdata

import com.qf.bigdata.util.formatType
import org.apache.spark.SparkConf
import org.apache.spark.sql.{Dataset, SaveMode, SparkSession}

/**
 * 将Log转换成Parquet文件格式
 */
object Log2Parquet {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","E:\\qianfeng\\hadoop\\hadoop-2.7.6")
    val conf = new SparkConf()
    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val spark: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("log2Parquet")
      .getOrCreate()
    val ds: Dataset[String] = spark.read.textFile("data/textLog.log")
    import spark.implicits._
    val dsLog: Dataset[Log] = ds.map(data => {
      val arr: Array[String] = data.split(",", -1)
      // 将切分出来的数据进行封装赋值
      Log(arr(0),
        formatType.str2Int(arr(1)),
        formatType.str2Int(arr(2)),
        formatType.str2Int(arr(3)),
        formatType.str2Int(arr(4)),
        arr(5),
        arr(6),
        formatType.str2Int(arr(7)),
        formatType.str2Int(arr(8)),
        formatType.str2Double(arr(9)),
        formatType.str2Double(arr(10)),
        arr(11),
        arr(12),
        arr(13),
        arr(14),
        arr(15),
        arr(16),
        formatType.str2Int(arr(17)),
        arr(18),
        arr(19),
        formatType.str2Int(arr(20)),
        formatType.str2Int(arr(21)),
        arr(22),
        arr(23),
        arr(24),
        arr(25),
        formatType.str2Int(arr(26)),
        arr(27),
        formatType.str2Int(arr(28)),
        arr(29),
        formatType.str2Int(arr(30)),
        formatType.str2Int(arr(31)),
        formatType.str2Int(arr(32)),
        arr(33),
        formatType.str2Int(arr(34)),
        formatType.str2Int(arr(35)),
        formatType.str2Int(arr(36)),
        arr(37),
        formatType.str2Int(arr(38)),
        formatType.str2Int(arr(39)),
        formatType.str2Double(arr(40)),
        formatType.str2Double(arr(41)),
        formatType.str2Int(arr(42)),
        arr(43),
        formatType.str2Double(arr(44)),
        formatType.str2Double(arr(45)),
        arr(46),
        arr(47),
        arr(48),
        arr(49),
        arr(50),
        arr(51),
        arr(52),
        arr(53),
        arr(54),
        arr(55),
        arr(56),
        formatType.str2Int(arr(57)),
        formatType.str2Double(arr(58)),
        formatType.str2Int(arr(59)),
        formatType.str2Int(arr(60)),
        arr(61),
        arr(62),
        arr(63),
        arr(64),
        arr(65),
        arr(66),
        arr(67),
        arr(68),
        arr(69),
        arr(70),
        arr(71),
        arr(72),
        formatType.str2Int(arr(73)),
        formatType.str2Double(arr(74)),
        formatType.str2Double(arr(75)),
        formatType.str2Double(arr(76)),
        formatType.str2Double(arr(77)),
        formatType.str2Double(arr(78)),
        arr(79),
        arr(80),
        arr(81),
        arr(82),
        arr(83),
        formatType.str2Int(arr(84))
      )
    })
    dsLog.write.mode(SaveMode.Overwrite).save("output/rs")
  }
}

case class Log(sessionid: String,
               advertisersid: Int,
               adorderid: Int,
               adcreativeid: Int,
               adplatformproviderid: Int,
               sdkversion: String,
               adplatformkey: String,
               putinmodeltype: Int,
               requestmode: Int,
               adprice: Double,
               adppprice: Double,
               requestdate: String,
               ip: String,
               appid: String,
               appname: String,
               uuid: String,
               device: String,
               client: Int,
               osversion: String,
               density: String,
               pw: Int,
               ph: Int,
               longs: String,
               lat: String,
               provincename: String,
               cityname: String,
               ispid: Int,
               ispname: String,
               networkmannerid: Int,
               networkmannername:String,
               iseffective: Int,
               isbilling: Int,
               adspacetype: Int,
               adspacetypename: String,
               devicetype: Int,
               processnode: Int,
               apptype: Int,
               district: String,
               paymode: Int,
               isbid: Int,
               bidprice: Double,
               winprice: Double,
               iswin: Int,
               cur: String,
               rate: Double,
               cnywinprice: Double,
               imei: String,
               mac: String,
               idfa: String,
               openudid: String,
               androidid: String,
               rtbprovince: String,
               rtbcity: String,
               rtbdistrict: String,
               rtbstreet: String,
               storeurl: String,
               realip: String,
               isqualityapp: Int,
               bidfloor: Double,
               aw: Int,
               ah: Int,
               imeimd5: String,
               macmd5: String,
               idfamd5: String,
               openudidmd5: String,
               androididmd5: String,
               imeisha1: String,
               macsha1: String,
               idfasha1: String,
               openudidsha1: String,
               androididsha1: String,
               uuidunknow: String,
               userid: String,
               iptype: Int,
               initbidprice: Double,
               adpayment: Double,
               agentrate: Double,
               lomarkrate: Double,
               adxrate: Double,
               title: String,
               keywords: String,
               tagid: String,
               callbackdate: String,
               channelid: String,
               mediatype: Int)