package com.qf.bigdata.util

/**
 * 类型转换
 */
object formatType {
  //转换Int类型
  def str2Int(str:String)={
    try{
      str.toInt
    }catch {
      case e:Exception=>0
    }
  }
  //转换Double类型
  def str2Double(str:String)={
    try{
      str.toDouble
    }catch {
      case e:Exception=>0.0
    }
  }
}
