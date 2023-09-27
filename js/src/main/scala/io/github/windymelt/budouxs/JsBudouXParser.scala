package io.github.windymelt.budouxs

import internal.budoux.moduleHtmlProcessorMod.HTMLProcessingParser as BParser
import internal.budoux.moduleMod as BParserMod

import scala.scalajs.js
import js.{JSStringOps, Dictionary as JMap}
class JsBudouXParser(private val inner: BParser) extends BudouXParser {
  def parse(sentence: String): List[String] = inner.parse(sentence).toList

  def translateHtmlString(html: String): String = "WIP"
}

trait JsBudouXParserObj {
  type Model = Map[String, Map[String, Double]]

//  def apply(model: Model): JsBudouXParser = {
//    import scalajs.js.JSConverters.*
//    val jsModel: JMap[JMap[Double]] =
//      model.view.mapValues[JMap[Double]](_.toJSDictionary).toMap.toJSDictionary
//    new BParser(
//      jsModel.asInstanceOf[StringDictionary[StringDictionary[Double]]]
//    )
//  }

  def loadDefaultJapanesePaper(): JsBudouXParser = new JsBudouXParser(
    BParserMod.loadDefaultJapaneseParser()
  )

  def loadDefaultSimplifiedChinesePaper(): JsBudouXParser = new JsBudouXParser(
    BParserMod.loadDefaultSimplifiedChineseParser()
  )

  def loadDefaultTraditionalChinesePaper(): JsBudouXParser = new JsBudouXParser(
    BParserMod.loadDefaultTraditionalChineseParser()
  )
}

object Parser extends JsBudouXParserObj
