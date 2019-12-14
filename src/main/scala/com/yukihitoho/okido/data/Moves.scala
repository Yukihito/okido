package com.yukihitoho.okido.data

import com.yukihitoho.okido.models._

object Moves {
  val ハイパーボイス_フェアリースキン = わざ("ハイパーボイス(フェアリースキン)",   タイプ.フェアリー, わざ分類.特殊, 90f * 1.2f)
  val マジカルフレイム = わざ("マジカルフレイム", タイプ.ほのお,     わざ分類.特殊, 75)
  val めいそう         = わざ("めいそう",         タイプ.エスパー,   わざ分類.変化, 0, 自身の能力変化 = Some(能力変化(c = ランク(1), d = ランク(1))))
  val ダイフェアリー   = わざ("ダイフェアリー",   タイプ.フェアリー, わざ分類.特殊, 130)
  val じしん           = わざ("じしん",           タイプ.じめん,     わざ分類.物理, 100)
  val アイアンヘッド   = わざ("アイアンヘッド",   タイプ.はがね,     わざ分類.物理, 80)
  val いわなだれ       = わざ("いわなだれ",       タイプ.いわ,       わざ分類.物理, 75)
  val ジャイロボール   = わざ("ジャイロボール",   タイプ.はがね,     わざ分類.物理, 0)
  val タネマシンガン5  = わざ("タネマシンガン5",  タイプ.くさ,       わざ分類.物理, 25 * 5)
  val タネマシンガン2  = わざ("タネマシンガン2",  タイプ.くさ,       わざ分類.物理, 25 * 2)
  val はたきおとす     = わざ("はたきおとす",     タイプ.あく,       わざ分類.物理, 65)
  val ストーンエッジ   = わざ("ストーンエッジ",   タイプ.いわ,       わざ分類.物理, 100)
  val ばかぢから       = わざ("ばかぢから",       タイプ.かくとう,   わざ分類.物理, 120)
  val はらだいこ       = わざ("はらだいこ",       タイプ.ノーマル,   わざ分類.変化, 0, 自身の能力変化 = Some(能力変化(a = ランク(6))))
  val つららばり5      = わざ("つららばり5",      タイプ.こおり,     わざ分類.物理, 25 * 5)
  val つららばり2      = わざ("つららばり2",      タイプ.こおり,     わざ分類.物理, 25 * 2)
  val かみくだく       = わざ("かみくだく",       タイプ.あく,       わざ分類.物理, 80)
  val ほのおのパンチ   = わざ("ほのおのパンチ",   タイプ.ほのお,     わざ分類.物理, 75)
  val ハイドロポンプ   = わざ("ハイドロポンプ",   タイプ.みず,       わざ分類.特殊, 110)
  val _10まんボルト    = わざ("10まんボルト",     タイプ.でんき,     わざ分類.特殊, 90)
  val ボルトチェンジ   = わざ("ボルトチェンジ",   タイプ.でんき,     わざ分類.特殊, 70)
  val おんがえし       = わざ("おんがえし",       タイプ.ノーマル,   わざ分類.物理, 102)
  val サイコファング   = わざ("サイコファング",   タイプ.エスパー,   わざ分類.物理, 85)
  val ドラゴンアロー   = わざ("ドラゴンアロー",   タイプ.ドラゴン,   わざ分類.物理, 100)
  val ゴーストダイブ   = わざ("ゴーストダイブ",   タイプ.ゴースト,   わざ分類.物理, 90)
  val とんぼがえり     = わざ("とんぼがえり",     タイプ.むし,       わざ分類.物理, 70)
  val かえんほうしゃ   = わざ("かえんほうしゃ",   タイプ.ほのお,     わざ分類.特殊, 90)
  val かみなり         = わざ("かみなり",         タイプ.でんき,     わざ分類.特殊, 110)
  val りゅうのまい     = わざ("りゅうのまい",     タイプ.ノーマル,   わざ分類.変化, 0, 自身の能力変化 = Some(能力変化(a = ランク(1), s = ランク(1))))
  val ねっとう         = わざ("ねっとう",         タイプ.みず,       わざ分類.特殊, 80)
  val サイコキネシス   = わざ("サイコキネシス",   タイプ.エスパー,   わざ分類.特殊, 90)
  val つるぎのまい     = わざ("つるぎのまい",     タイプ.ノーマル,   わざ分類.変化, 0, 自身の能力変化 = Some(能力変化(a = ランク(2))))
  val リーフストーム   = わざ("リーフストーム",   タイプ.くさ,       わざ分類.特殊, 130, 自身の能力変化 = Some(能力変化(c = ランク(-2))))
  val わるだくみ       = わざ("わるだくみ",       タイプ.あく,       わざ分類.変化, 0, 自身の能力変化 = Some(能力変化(c = ランク(2))))
  val がんせきふうじ   = わざ("がんせきふうじ",   タイプ.いわ,       わざ分類.物理, 60)
}