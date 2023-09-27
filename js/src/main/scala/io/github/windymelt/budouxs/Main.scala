package io.github.windymelt.budouxs

import scalajs.js

object Main extends App {
  // this is dummy
  println("Hello, world from Scala.js!")
  val p = Parser.loadDefaultJapanesePaper()
  val text = p.parse("小田原熱海間に、軽便鉄道敷設の工事が始まったのは、良平の八つの年だった。")
  println(text.mkString(", "))
  println(text.size)
  val html = p.translateHtmlString("小田原熱海間に、軽便鉄道敷設の工事が始まったのは、良平の八つの年だった。")
  println(html)
}
