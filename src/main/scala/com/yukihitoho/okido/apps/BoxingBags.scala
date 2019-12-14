package com.yukihitoho.okido.apps

import com.yukihitoho.okido.models._

case class BoxingBags(種族: 種族, 積みわざ: Option[わざ] = None) {
  val 無振 = applyBuff(ポケモン(s"無振${種族.longName}", 種族, 個体値.Max, 努力値.Min, せいかく.まじめ, Nil))
  val 準振 = applyBuff(ポケモン(s"準振${種族.longName}", 種族, 個体値.Max, 努力値.Max, せいかく.まじめ, Nil))
  val 最振 = applyBuff(ポケモン(s"最振${種族.longName}", 種族, 個体値.Max, 努力値.Max, せいかく.Max, Nil))

  private def applyBuff(p: ポケモン): ポケモン = 積みわざ.map(p.能力変化を適用).getOrElse(p)

  val all = 無振 :: 準振 :: 最振 :: Nil
}
