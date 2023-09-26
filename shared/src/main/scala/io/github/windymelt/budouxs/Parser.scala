package io.github.windymelt.budouxs

trait BudouXParser {

  /** Parses a sentence into phrases.
    *
    * @param sentence
    *   the sentence to break by phrase.
    * @return
    *   a list of phrases.
    */
  def parse(sentence: String): List[String]

  /** Translates an HTML string with phrases wrapped in no-breaking markup.
    *
    * @param html
    *   an HTML string.
    * @return
    *   the translated HTML string with no-breaking markup.
    */
  def translateHtmlString(html: String): String
}
