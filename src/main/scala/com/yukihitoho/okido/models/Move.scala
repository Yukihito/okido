package com.yukihitoho.okido.models

case class ランク(value: Int = 0) {
  val 倍率: Float =
    if (value > 0) {
      (value + 2f) / 2f
    } else if (value < 0) {
      2f / (-value + 2f)
    } else 1f

  def +(that: ランク): ランク = ランク(this.value + that.value)
  override def toString: String = if (value > 0) s"+$value" else s"$value"
}

case class 能力変化(a: ランク = ランク(), b: ランク = ランク(), c: ランク = ランク(), d: ランク = ランク(), s: ランク = ランク()) {
  override def toString: String = {
    val labelAndRanks = Seq(
      ("攻撃", a),
      ("防御", b),
      ("特攻", c),
      ("特防", d),
      ("素早", s)
    )

    labelAndRanks.filter(_._2.value != 0).map(tpl => s"${tpl._1}: ${tpl._2}").mkString(", ")
  }

  def +(that: 能力変化): 能力変化 = 能力変化(this.a + that.a, this.b + that.b, this.c + that.c, this.d + that.d, this.s + that.s)
}

object 能力変化 {
  val Identity: 能力変化 = 能力変化()
}

case class わざ(name: String, タイプ: タイプ, わざ分類: わざ分類, 威力: Float, 自身の能力変化: Option[能力変化] = None, 相手の能力変化: Option[能力変化] = None)

trait わざ分類

object わざ分類 {
  object 物理 extends わざ分類
  object 特殊 extends わざ分類
  object 変化 extends わざ分類
}
