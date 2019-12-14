package com.yukihitoho.okido.models

case class Damage(min: Float, max: Float) {
  override def toString: String = s"${min.toInt} ～ ${max.toInt}"
}

case class DamagePercentage(min: Float, max: Float) {
  override def toString: String = s"${(min * 100f).toInt}% ～ ${(max * 100f).toInt}%"

  def 確定何発: Int = scala.math.ceil(1f / min).toInt
  def 乱数何発: Int = scala.math.ceil(1f / max).toInt
}

class DamageCalculationService {
  private val lv = 50
  def calcDamage(攻撃側のポケモン: ポケモン, 防御側のポケモン: ポケモン, わざ: わざ): Damage = {
    val 攻撃or特攻 = わざ.わざ分類 match {
      case わざ分類.物理 => 攻撃側のポケモン.stats.a
      case わざ分類.特殊 => 攻撃側のポケモン.stats.c
      case わざ分類.変化 => 1f
    }

    val 防御or特防 = わざ.わざ分類 match {
      case わざ分類.物理 => 防御側のポケモン.stats.b
      case わざ分類.特殊 => 防御側のポケモン.stats.d
      case わざ分類.変化 => 1f
    }

    val タイプ一致補正 = if (攻撃側のポケモン.種族.全てのタイプ.contains(わざ.タイプ)) 1.5f else 1f

    val タイプ相性倍率 = 防御側のポケモン.種族.全てのタイプ.foldLeft(1f){ (acc, e) =>
      acc * わざ.タイプ.倍率(e)
    }

    val 威力 =
      if (わざ.name == "ジャイロボール") ジャイロボール威力(攻撃側のポケモン, 防御側のポケモン)
      else わざ.威力

    val 基本ダメージ = (((lv * 2f / 5f + 2) * ((威力 * 攻撃or特攻) / 防御or特防).toInt / 50f).toInt + 2f).toInt

    val max = 基本ダメージ * タイプ一致補正 * タイプ相性倍率
    val min = (基本ダメージ * 0.85f).toInt * タイプ一致補正 * タイプ相性倍率

    Damage(min, max)
  }

  private def ジャイロボール威力(攻撃側のポケモン: ポケモン, 防御側のポケモン: ポケモン): Float =
    ((25f * 防御側のポケモン.stats.s / 攻撃側のポケモン.stats.s) + 1f).toInt
}
