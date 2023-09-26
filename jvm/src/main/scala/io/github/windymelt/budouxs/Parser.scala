package io.github.windymelt.budouxs

import com.google.budoux.{Parser => BParser}

import collection.JavaConverters._
import scala.util.Try
import scala.util.control.Exception.allCatch

/**
 * The BudouX parser that translates the input sentence into phrases.
 *
 * <p>You can create a parser instance by invoking {{{Parser(model)}}} with the model data you
 * want to use. You can also create a parser by specifying the model file path with
 * {{{Parser.loadByFileName(modelFileName)}}}.
 *
 * <p>In most cases, it's sufficient to use the default parser for the language. For example, you
 * can create a default Japanese parser as follows.
 *
 * @example
 * {{{
 * val parser = Parser.loadDefaultJapaneseParser()
 * val segmented: List[String] = parser.parse("小田原熱海間に、軽便鉄道敷設の工事が始まったのは、良平の八つの年だった。")
 * }}}
 */
class Parser(private val inner: BParser) {
  /**
   * Parses a sentence into phrases.
   *
   * @param sentence the sentence to break by phrase.
   * @return a list of phrases.
   */
  def parse(sentence: String): List[String] = inner.parse(sentence).asScala.toList

  /**
   * Translates an HTML string with phrases wrapped in no-breaking markup.
   *
   * @param html an HTML string.
   * @return the translated HTML string with no-breaking markup.
   */
  def translateHtmlString(html: String): String = inner.translateHTMLString(html)
}

object Parser {
  type Model = Map[String, Map[String, Int]]

  /**
   * Constructs a BudouX parser.
   *
   * @param model the model data.
   */
  def apply(model: Model): Parser = new Parser(new BParser(model.mapValues(_.mapValues(java.lang.Integer.valueOf).asJava).asJava))

  /**
   * Loads the default Japanese parser.
   *
   * @return a BudouX parser with the default Japanese model.
   */
  def loadDefaultJapanesePaper(): Parser = new Parser(BParser.loadDefaultJapaneseParser())

  /**
   * Loads the default Simplified Chinese parser.
   *
   * @return a BudouX parser with the default Simplified Chinese model.
   */
  def loadDefaultSimplifiedChinesePaper(): Parser = new Parser(BParser.loadDefaultSimplifiedChineseParser())

  /**
   * Loads the default Traditional Chinese parser.
   *
   * @return a BudouX parser with the default Traditional Chinese model.
   */
  def loadDefaultTraditionalChinesePaper(): Parser = new Parser(BParser.loadDefaultTraditionalChineseParser())

  /**
   * Loads a parser by specifying the model file path.
   * Returns [[scala.util.Failure]] on JSON or I/O error (catches all).
   *
   * @param modelFileName the model file path.
   * @return a BudouX parser.
   */
  def loadByFileName(modelFileName: String): Try[Parser] = allCatch withTry  {
    new Parser(BParser.loadByFileName(modelFileName))
  }
}

