package com.yukihitoho.okido.models

case class 種族(name: String, variant: String, タイプ1: タイプ, タイプ2: Option[タイプ], 種族値: 種族値) {
  def 全てのタイプ: List[タイプ] = タイプ1 :: タイプ2.toList
  def longName: String = if (variant == "") name else s"$name ($variant)"
}

object 種族 {
  def apply(name: String, type1: タイプ, type2: タイプ, baseStats: 種族値): 種族 = new 種族(name, "", type1, Some(type2), baseStats)
  def apply(name: String, type1: タイプ, baseStats: 種族値): 種族 = new 種族(name, "", type1, None, baseStats)
  def apply(name: String, variant: String, type1: タイプ, baseStats: 種族値)= new 種族(name, variant, type1, None, baseStats)
  def apply(name: String, variant: String, type1: タイプ, type2: タイプ, baseStats: 種族値) = new 種族(name, variant, type1, Some(type2), baseStats)
}
