# BudouXₛ: Scala binding for BudouX

BudouXₛ (BudouXs) is Scala binding for [BudouX, linebreak organizer (sentence segmenter) developed by Google](https://github.com/google/budoux).

## Dependency

WIP

- [x] JVM
- [ ] Scala.js

## What is nice

- Pure Scala interface
- Cross compiling (WIP)
- Minimal dependency (depending to just `budoux`)

## Usage

```scala
import io.github.windymelt.budouxs.Parser

val text = "小田原熱海間に、軽便鉄道敷設の工事が始まったのは、良平の八つの年だった。"
val p = Parser.loadDefaultJapanesePaper()
val segmented: List[String] = p.parse(text)
/* =>
 List(
  "小田原熱海間に、",
  "軽便鉄道敷設の",
  "工事が",
  "始まったのは、",
  "良平の",
  "八つの",
  "年だった。"
)
*/

val html: String = p.translateHtmlString(text)
/* =>
<span style="word-break: keep-all; overflow-wrap: anywhere;"><p>小田原熱海間に、<wbr>軽便鉄道敷設の<wbr>工事が<wbr>始まったのは、<wbr>良平の<wbr>八つの<wbr>年だった。</p></span>
*/
```

