package com.yukihitoho.okido.apps
import com.yukihitoho.okido.models._

object Tools {
  val damageCalculationService = new DamageCalculationService

  def 受けポケである(種族: 種族): Boolean =  物理受けである(種族) || 特殊受けである(種族)
  def 両受けである(種族: 種族): Boolean =  物理受けである(種族) && 特殊受けである(種族)
  def 物理受けである(種族: 種族): Boolean = 種族.種族値.h + 種族.種族値.b >= 190 // 190で受けポケ, 180で後出しOKなポケモンが出てくるイメージ
  def 特殊受けである(種族: 種族): Boolean = 種族.種族値.h + 種族.種族値.d >= 190

  def 物理アタッカーである(種族: 種族): Boolean = 種族.種族値.a >= 90
  def 特殊アタッカーである(種族: 種族): Boolean = 種族.種族値.c >= 90
  def 両刀である(種族: 種族): Boolean = 物理アタッカーである(種族) && 特殊アタッカーである(種族)
  def 物理特化アタッカーである(種族: 種族): Boolean = 物理アタッカーである(種族) && 種族.種族値.a - 種族.種族値.c >= 15
  def 特殊特化アタッカーである(種族: 種族): Boolean = 特殊アタッカーである(種族) && 種族.種族値.c - 種族.種族値.a >= 15

  def 持っているわざのうち最大のダメージ倍率(自分のポケモン: ポケモン, 攻撃対象の種族: 種族): Float =
    (for {
      わざ <- 自分のポケモン.わざリスト
    } yield タイプ相性による倍率(わざ.タイプ, 攻撃対象の種族) * タイプ一致補正の倍率(自分のポケモン.種族, わざ)).max

  def タイプ相性による倍率(攻撃側のわざのタイプ: タイプ, 防御側の種族: 種族): Float =
    防御側の種族.全てのタイプ.foldLeft(1f)((acc, 防御側のタイプ) => acc * 攻撃側のわざのタイプ.倍率(防御側のタイプ))

  def タイプ一致補正の倍率(種族: 種族, わざ: わざ): Float = if (種族.全てのタイプ.contains(わざ.タイプ)) 1.5f else 1f

  def タイプ相性的に受けにくい種族のリスト(自分のポケモン: ポケモン, 環境にいる種族のリスト: Seq[種族]): Seq[種族] =
    環境にいる種族のリスト.filter(相手の種族 => 相手の種族.全てのタイプ.exists(相手のタイプ => タイプ相性による倍率(相手のタイプ, 自分のポケモン.種族) >= 2f))

  def 役割的に受けにくい種族のリスト(自分のポケモン: ポケモン, 環境にいる種族のリスト: Seq[種族]): Seq[種族] =
    (if (!物理受けである(自分のポケモン.種族)) {
      環境にいる種族のリスト.filter(物理アタッカーである)
    } else Seq()) ++
    (if (!特殊受けである(自分のポケモン.種族)) {
      環境にいる種族のリスト.filter(特殊アタッカーである)
    } else Seq()).distinct

  def 受けにくい種族のリスト(自分のポケモン: ポケモン, 環境にいる種族のリスト: Seq[種族]): Seq[種族] =
    (タイプ相性的に受けにくい種族のリスト(自分のポケモン, 環境にいる種族のリスト) ++ 役割的に受けにくい種族のリスト(自分のポケモン, 環境にいる種族のリスト)).distinct

  def toCSVString(elements: Seq[種族]): String = elements.map(toCSVLineString).mkString("\n")

  def toCSVLineString(element: 種族): String = Seq(element.name, element.種族値.h, element.種族値.a, element.種族値.b, element.種族値.c, element.種族値.d, element.種族値.s).mkString(",")
}
