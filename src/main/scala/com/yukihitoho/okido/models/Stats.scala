package com.yukihitoho.okido.models

case class Stats(baseStats: 種族値, iv: 個体値, ev: 努力値, nature: せいかく, 能力変化: 能力変化) extends StatsFactor {
  private val lv: Float = 50

  override def h: Float = ((baseStats.h * 2f + iv.h + (ev.h / 4f)) * lv / 100f + lv + 10f).toInt
  override def a: Float = stat(baseStats.a, ev.a, iv.a, nature.a, 能力変化.a.倍率)
  override def b: Float = stat(baseStats.b, ev.b, iv.b, nature.b, 能力変化.b.倍率)
  override def c: Float = stat(baseStats.c, ev.c, iv.c, nature.c, 能力変化.c.倍率)
  override def d: Float = stat(baseStats.d, ev.d, iv.d, nature.d, 能力変化.d.倍率)
  override def s: Float = stat(baseStats.s, ev.s, iv.s, nature.s, 能力変化.s.倍率)

  private def stat(b: Float, e: Float, i: Float, n: Float, r: Float): Float = ((((b * 2f + i + (e / 4f)) * (lv / 100f) + 5f) * n).toInt * r).toInt
}

trait StatsFactor {
  def h: Float
  def a: Float
  def b: Float
  def c: Float
  def d: Float
  def s: Float
}

case class 種族値(h: Float, a: Float, b: Float, c: Float, d: Float, s: Float) extends StatsFactor

case class 努力値(h: Float, a: Float, b: Float, c: Float, d: Float, s: Float) extends StatsFactor

object 努力値 {
  val Min = 努力値(0, 0, 0, 0, 0, 0)
  val Max = 努力値(252, 252, 252, 252, 252, 252)
}

case class 個体値(h: Float, a: Float, b: Float, c: Float, d: Float, s: Float) extends StatsFactor



object 個体値 {
  val Max = 個体値(31, 31, 31, 31, 31, 31)
}

case class せいかく(a: Float = 1, b: Float = 1, c: Float = 1, d: Float = 1, s: Float = 1) extends StatsFactor {
  val h: Float = 1
}

object せいかく {
  private val ↑ = 1.1f
  private val ↓ = 0.9f
  val Max      = せいかく(↑, ↑, ↑, ↑, ↑)
  val まじめ   = せいかく()
  val ひかえめ = せいかく(a = ↓, c = ↑)
  val おくびょう = せいかく(s = ↑, a = ↓)
  val ようき = せいかく(s = ↑, c = ↓)
  val いじっぱり = せいかく(a = ↑, c = ↓)
}
