//package io.github.windymelt.budouxs
//
//class ParserSpec extends munit.FunSuite {
//  test("Can segment Japanese") {
//    val p = JvmBudouXParser.loadDefaultJapanesePaper()
//    val segmented = p.parse("小田原熱海間に、軽便鉄道敷設の工事が始まったのは、良平の八つの年だった。")
//    val expected = List(
//      "小田原熱海間に、",
//      "軽便鉄道敷設の",
//      "工事が",
//      "始まったのは、",
//      "良平の",
//      "八つの",
//      "年だった。"
//    )
//    assertEquals(segmented, expected)
//  }
//
//  test("Can segment Simplified Chinese") {
//    val p = JvmBudouXParser.loadDefaultSimplifiedChinesePaper()
//    val segmented = p.parse("道可道，非常道。名可名，非常名。无名天地之始；有名萬物之母。")
//    val expected = List(
//      "道",
//      "可道，",
//      "非常道。",
//      "名",
//      "可名，",
//      "非常",
//      "名。",
//      "无名",
//      "天地",
//      "之始；",
//      "有",
//      "名",
//      "萬物",
//      "之母。"
//    )
//    assertEquals(segmented, expected)
//  }
//
//  test("Can segment Traditional Chinese") {
//    val p = JvmBudouXParser.loadDefaultTraditionalChinesePaper()
//    val segmented = p.parse("道可道，非常道。名可名，非常名。無名天地之始；有名萬物之母。")
//    val expected = List(
//      "道",
//      "可道，",
//      "非常",
//      "道。",
//      "名",
//      "可",
//      "名，",
//      "非常",
//      "名。",
//      "無",
//      "名",
//      "天地",
//      "之",
//      "始；",
//      "有",
//      "名萬物",
//      "之母。"
//    )
//    assertEquals(segmented, expected)
//  }
//
//  test("Can segment html text") {
//    val p = JvmBudouXParser.loadDefaultJapanesePaper()
//    val segmented = p.translateHtmlString("<html><body><p>小田原熱海間に、軽便鉄道敷設の工事が始まったのは、良平の八つの年だった。</p></body></html>")
//    val expected = """<span style="word-break: keep-all; overflow-wrap: anywhere;"><p>小田原熱海間に、<wbr>軽便鉄道敷設の<wbr>工事が<wbr>始まったのは、<wbr>良平の<wbr>八つの<wbr>年だった。</p></span>"""
//    assertEquals(segmented, expected)
//  }
//
//  test("Can catch in loadByFileName") {
//    val pTry = JvmBudouXParser.loadByFileName("/tmp/nothingnothingnothingnothingnothing")
//    assertEquals(pTry.isFailure, true)
//  }
//}
