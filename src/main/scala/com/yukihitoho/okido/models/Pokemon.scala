package com.yukihitoho.okido.models

case class ポケモン(name: String, 種族: 種族, iv: 個体値, ev: 努力値, せいかく: せいかく, わざリスト: List[わざ], ランク補正: 能力変化 = 能力変化.Identity) {
  def stats: Stats = Stats(種族.種族値, iv, ev, せいかく, ランク補正)
  def 能力変化を適用(わざ: わざ): ポケモン = わざ.自身の能力変化.map(r => this.copy(ランク補正 = ランク補正 + r)).getOrElse(this)
}
