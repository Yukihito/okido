package com.yukihitoho.okido
import com.yukihitoho.okido.apps.BoxingBags
import com.yukihitoho.okido.models._
import com.yukihitoho.okido.ui.Page

object Main {
  import com.yukihitoho.okido.data.Pokedex._
  import com.yukihitoho.okido.data.Moves._
  import com.yukihitoho.okido.apps.Tools._

  def main(args: Array[String]): Unit = {
    val ニンフィア = ポケモン(
      "ニンフィア",
      ポケモン図鑑.find(_.name == "ニンフィア").get,
      個体値.Max,
      努力値(236, 0, 252, 0, 0, 20), // 無振バンギラス抜きS調整のみ
      //努力値(236, 0, 252, 36, 0, 20), // C調整ナットレイ確2, アイアント準振確1, バンギラス確2, S調整無振バンギラス抜き
      せいかく.ひかえめ,
      ハイパーボイス_フェアリースキン :: マジカルフレイム :: めいそう :: Nil
    )

    val エーフィ = ポケモン(
      "エーフィ",
      ポケモン図鑑.find(_.name == "エーフィ").get,
      個体値.Max,
      努力値(252, 0, 4, 0, 0, 252),
      せいかく.おくびょう,
      サイコキネシス :: Nil
    )

    val ドリュウズ = ポケモン(
      "ドリュウズ",
      ポケモン図鑑.find(_.name == "ドリュウズ").get,
      個体値.Max,
      努力値(0, 252, 4, 0, 0, 252),
      せいかく.ようき,
      じしん :: アイアンヘッド :: いわなだれ :: つるぎのまい :: Nil
    )

    val ロトム = ポケモン(
      "ロトム",
      ポケモン図鑑.find(_.name == "ロトム").get,
      個体値.Max,
      努力値(4, 0, 0, 252, 0, 252),
      せいかく.ひかえめ,
      ボルトチェンジ :: _10まんボルト :: リーフストーム :: わるだくみ :: Nil
    )

    val ドラパルト = ポケモン(
      "ドラパルト",
      ポケモン図鑑.find(_.name == "ドラパルト").get,
      個体値.Max,
      努力値(0, 252, 0, 0, 4, 252),
      せいかく.ようき,
      ドラゴンアロー :: ゴーストダイブ :: とんぼがえり :: りゅうのまい :: Nil
    )

    val バンギラス = ポケモン(
      "バンギラス",
      ポケモン図鑑.find(_.name == "バンギラス").get,
      個体値.Max,
      努力値(252, 252, 0, 0, 0, 4),
      せいかく.いじっぱり,
      ほのおのパンチ :: かみくだく :: がんせきふうじ :: Nil
    )

    val 手持ち = ニンフィア :: エーフィ :: ドリュウズ :: ロトム :: ドラパルト :: バンギラス :: Nil

    for {
      ポケモン <- 手持ち
      page <- 概要ページを作成する(ポケモン) :: 与ダメ一覧のページを全て作成する(ポケモン)
    } yield page.write()

    S早見表を作成する(手持ち).write()

    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "ドリュウズ").get, じしん :: アイアンヘッド :: いわなだれ :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "ナットレイ").get, ジャイロボール :: タネマシンガン2 :: タネマシンガン5 :: はたきおとす :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "アイアント").get, アイアンヘッド :: ストーンエッジ :: ばかぢから :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(p => p.name == "コオリッポ" && p.variant == "アイスフェイス").get, つららばり2 :: つららばり5 :: はらだいこ :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(p => p.name == "コオリッポ" && p.variant == "ナイスフェイス").get, つららばり2 :: つららばり5 :: はらだいこ :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "バンギラス").get, アイアンヘッド :: ばかぢから :: ストーンエッジ :: かみくだく :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(p => p.name == "ロトム" && p.variant == "ウォッシュ").get, ハイドロポンプ :: _10まんボルト :: ボルトチェンジ :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "カビゴン").get, じしん :: おんがえし :: はらだいこ :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "ドラパルト").get, ドラゴンアロー :: ゴーストダイブ :: とんぼがえり :: かみなり :: かえんほうしゃ :: サイコファング :: りゅうのまい :: Nil).write()
    仮想敵対策ページを作成する(ニンフィア, ポケモン図鑑.find(_.name == "ヌオー").get, ねっとう :: じしん :: ストーンエッジ :: Nil).write()

    仮想敵対策ページを作成する(エーフィ,   ポケモン図鑑.find(_.name == "ドラパルト").get, ドラゴンアロー :: ゴーストダイブ :: とんぼがえり :: かみなり :: かえんほうしゃ :: サイコファング :: りゅうのまい :: Nil).write()

    仮想敵対策ページを作成する(ドリュウズ, ポケモン図鑑.find(_.name == "カビゴン").get, じしん :: おんがえし :: はらだいこ :: Nil).write()
    仮想敵対策ページを作成する(ドリュウズ, ポケモン図鑑.find(_.name == "ヌオー").get, ねっとう :: じしん :: ストーンエッジ :: Nil).write()
    仮想敵対策ページを作成する(ドリュウズ, ポケモン図鑑.find(_.name == "ナットレイ").get, ジャイロボール :: タネマシンガン2 :: タネマシンガン5 :: はたきおとす :: Nil).write()
    仮想敵対策ページを作成する(ドリュウズ, ポケモン図鑑.find(p => p.name == "コオリッポ" && p.variant == "アイスフェイス").get, つららばり2 :: つららばり5 :: はらだいこ :: Nil).write()
    仮想敵対策ページを作成する(ドリュウズ, ポケモン図鑑.find(p => p.name == "コオリッポ" && p.variant == "ナイスフェイス").get, つららばり2 :: つららばり5 :: はらだいこ :: Nil).write()
    // ギルガルド
    // ドヒドイデ

  }

  def 仮想敵対策ページを作成する(自分のポケモン: ポケモン, 相手の種族: 種族, 相手のわざリスト: List[わざ]): Page = {
    val title = s"${自分のポケモン.name} vs ${相手の種族.longName}"

    val damagesToGive = (for {
      攻撃わざ <- 自分のポケモン.わざリスト.filter(_.わざ分類 != わざ分類.変化)
    } yield {
      val d = 与ダメ割合一覧(自分のポケモン, 相手の種族, 攻撃わざ)
      (d.無振.max, d)
    }).filter(_._1 >= 1f/3f).sortBy(_._1).reverse.map(tpl => s"### ${tpl._2.使用するわざ.name}\n${tpl._2}").mkString("\n\n")

    val damagesToGiveWithBuff = (for {
      攻撃わざ <- 自分のポケモン.わざリスト.filter(_.わざ分類 != わざ分類.変化)
      積みわざ <- 自分のポケモン.わざリスト.filter(_.自身の能力変化.isDefined)
      積み回数 <- 1 to 2
    } yield {
      val 積んだポケモン = (1 to 積み回数).foldLeft(自分のポケモン)((acc, _) => acc.能力変化を適用(積みわざ))
      val buffLabel = s"${積みわざ.name} × $積み回数"
      val d = 与ダメ割合一覧(積んだポケモン, 相手の種族, 攻撃わざ)
      (d.無振.max, d, buffLabel)
    }).filter(_._1 >= 1f/3f).sortBy(_._1).reverse.map(tpl => s"### ${tpl._2.使用するわざ.name} (${tpl._3})\n${tpl._2}").mkString("\n\n")

    val damagesToBeTaken = (for {
      わざ <- 相手のわざリスト.filter(_.わざ分類 != わざ分類.変化)
    } yield {
      val d = 被ダメ割合一覧(自分のポケモン, 相手の種族, わざ)
      (d.無振.max, d)
    }).filter(_._1 >= 1f/3f).sortBy(_._1).reverse.map(tpl => s"### ${tpl._2.使用するわざ.name}\n${tpl._2}").mkString("\n\n")

    val damagesToBeTakenWithBuff = (for {
      わざ <- 相手のわざリスト.filter(_.わざ分類 != わざ分類.変化)
      積みわざ <- 相手のわざリスト.filter(_.自身の能力変化.isDefined)
    } yield {
      val buffLabel = 積みわざ.name
      val d = 被ダメ割合一覧(自分のポケモン, 相手の種族, わざ, Some(積みわざ))
      (d.無振.max, d, buffLabel)
    }).filter(_._1 >= 1f/3f).sortBy(_._1).reverse.map(tpl => s"### ${tpl._2.使用するわざ.name} (${tpl._3})\n${tpl._2}").mkString("\n\n")

    val boxingBags = BoxingBags(相手の種族)

    val content =
      s"""
         |# $title
         |
         |## すばやさ比較
         |
         |自分の素早さ: ${自分のポケモン.stats.s}
         |
         |相手の素早さ:
         |- 無振: ${boxingBags.無振.stats.s}
         |- 準速: ${boxingBags.準振.stats.s}
         |- 最速: ${boxingBags.最振.stats.s}
         |
         |## 与ダメ一覧
         |$damagesToGive
         |
         |$damagesToGiveWithBuff
         |
         |## 被ダメ一覧
         |$damagesToBeTaken
         |
         |$damagesToBeTakenWithBuff
         |""".stripMargin
    Page(title, content)
  }

  def S早見表を作成する(手持ち: List[ポケモン]): Page = {
    val title = "S早見表"

    val boxingBags = for {
      環境にいる種族 <- ポケモン図鑑
      boxingBag <- BoxingBags(環境にいる種族).all
    } yield boxingBag

    val content = (boxingBags ++ 手持ち)
      .sortBy(p => p.stats.s)
      .reverse
      .map { p =>
        if (手持ち.contains(p)) s"""- <span style="color: red; ">${p.stats.s}:""" + s"\t${p.name}</span>"
        else s"- ${p.stats.s}:\t${p.name}"
      }
      .mkString("\n")

    Page(title, content)
  }

  def 概要ページを作成する(ポケモン: ポケモン): Page = {
    val title = ポケモン.種族.longName
    val content = s"""
       |# $title
       |
       |## 実数値
       |- HP ${ポケモン.stats.h.toInt}
       |- 攻撃 ${ポケモン.stats.a.toInt}
       |- 防御 ${ポケモン.stats.b.toInt}
       |- 特攻 ${ポケモン.stats.c.toInt}
       |- 特防 ${ポケモン.stats.d.toInt}
       |- 素早 ${ポケモン.stats.s.toInt}
       |
       |## 得意な相手
       |${得意な相手のリスト(ポケモン).map(p => s"- ${p.longName}").mkString("\n")}
       |
       |## 苦手な相手
       |${苦手な相手のリスト(ポケモン).map(p => s"- ${p.longName}").mkString("\n")}
       |
       |## タイプ相性的に受けにくい相手
       |${タイプ相性的に受けにくい種族のリスト(ポケモン, ポケモン図鑑).map(p => s"- ${p.longName}").mkString("\n")}
       |
       |## 役割的に受けにくい相手
       |${役割的に受けにくい種族のリスト(ポケモン, ポケモン図鑑).map(p => s"- ${p.longName}").mkString("\n")}
       |
       |## 期待できる役割
       |""".stripMargin +
      List(
        if (両受けである(ポケモン.種族)) Some("- 両受け")
        else if (特殊受けである(ポケモン.種族)) Some("- 特殊受け")
        else if (物理受けである(ポケモン.種族)) Some("- 物理受け")
        else None,
        if (両刀である(ポケモン.種族)) Some("- 両刀")
        else if (特殊特化アタッカーである(ポケモン.種族)) Some("- 特殊アタッカー")
        else if (物理特化アタッカーである(ポケモン.種族)) Some("- 物理アタッカー")
        else None,
        if (ポケモン.わざリスト.exists(_.自身の能力変化.isDefined)) Some(
          "- 積み性能\n" +
            (for {
              わざ <- ポケモン.わざリスト
              自身の能力変化 <- わざ.自身の能力変化.toSeq
            } yield s"\t- ${わざ.name} ($自身の能力変化)").mkString("\n"))
        else None
      ).flatten.mkString("\n")
    Page(title, content)
  }

  def 与ダメ一覧のページを作成する(label: Option[String], ポケモン: ポケモン): Page = {
    val title = s"${ポケモン.種族.longName}の与ダメージ一覧${label.map(l => s" ($l)").getOrElse("")}"
    val content =
    s"""
       |# $title
       |
     """.stripMargin + (for (n <- 1 to 4) yield
    s"""
       |## 確$n
       |${与ダメ情報(ポケモン, _.無振.確定何発 == n, s => s.準振.確定何発 > n, s => s.最振.確定何発 > n).mkString("\n\n")}
       |
       |""".stripMargin).mkString("\n") +
    s"""
       |## 確5以上
       |${与ダメ情報(ポケモン, _.無振.確定何発 >= 5, _ => false, _ => false).mkString("\n\n")}
       |""".stripMargin
    Page(title, content)
  }

  def 与ダメ一覧のページを全て作成する(ポケモン: ポケモン): List[Page] =
    与ダメ一覧のページを作成する(None, ポケモン) ::
      (for {
        積みわざ <- ポケモン.わざリスト.filter(_.自身の能力変化.isDefined)
        積み回数 <- 1 to 2
      } yield {
        val 積んだポケモン = (1 to 積み回数).foldLeft(ポケモン)((acc, _) => acc.能力変化を適用(積みわざ))
        val label = s"${積みわざ.name} × $積み回数"
        与ダメ一覧のページを作成する(Some(label), 積んだポケモン)
      })

  def 得意な相手のリスト(ポケモン: ポケモン): Seq[種族] = {
    val 受けにくいやつら = (役割的に受けにくい種族のリスト(ポケモン, ポケモン図鑑) ++ タイプ相性的に受けにくい種族のリスト(ポケモン, ポケモン図鑑)).distinct
    種族に対する最大ダメージ割合(ポケモン)
      .filter(tpl => tpl._2.無振.確定何発 <= 2)
      .map(_._1)
      .filter(s => !受けにくいやつら.contains(s))
  }

  def 苦手な相手のリスト(ポケモン: ポケモン): Seq[種族] = {
    val 受けにくいやつら = (役割的に受けにくい種族のリスト(ポケモン, ポケモン図鑑) ++ タイプ相性的に受けにくい種族のリスト(ポケモン, ポケモン図鑑)).distinct
    種族に対する最大ダメージ割合(ポケモン)
      .filter(tpl => tpl._2.無振.確定何発 >= 3)
      .map(_._1)
      .filter(s => 受けにくいやつら.contains(s))
  }

  def 種族に対する最大ダメージ割合(攻撃側のポケモン: ポケモン): Seq[(種族, 与ダメ割合一覧)] = for {
    相手の種族 <- ポケモン図鑑
  } yield {
    val 最大ダメージを与えられるわざ = 攻撃側のポケモン.わざリスト
      .filter(_.わざ分類 != わざ分類.変化)
      .maxBy(わざ => 与ダメ割合一覧(攻撃側のポケモン, 相手の種族, わざ).無振.max)
    (相手の種族, 与ダメ割合一覧(攻撃側のポケモン, 相手の種族, 最大ダメージを与えられるわざ))
  }


  def 与ダメ情報(攻撃側のポケモン: ポケモン, filter: 与ダメ割合一覧 => Boolean, shouldWarnStrongly: 与ダメ割合一覧 => Boolean, shouldWarn: 与ダメ割合一覧 => Boolean) = (for {
    相手の種族 <- ポケモン図鑑
  } yield {
    val 最大ダメージを与えられるわざ =
      攻撃側のポケモン.わざリスト
        .filter(_.わざ分類 != わざ分類.変化)
        .maxBy(わざ => 与ダメ割合一覧(攻撃側のポケモン, 相手の種族, わざ).無振.max)
    val ダメージ割合 = 与ダメ割合一覧(攻撃側のポケモン, 相手の種族, 最大ダメージを与えられるわざ)
    if (filter(ダメージ割合)) {
      if (shouldWarnStrongly(ダメージ割合)) Some((ダメージ割合.無振.max, s"""<details><summary><span style="color: red; ">${最大ダメージを与えられるわざ.name} => ${相手の種族.longName}</span></summary>""" + s"\n$ダメージ割合</details>"))
      else if (shouldWarn(ダメージ割合)) Some((ダメージ割合.無振.max, s"""<details><summary><span style="color: yellow; ">${最大ダメージを与えられるわざ.name} => ${相手の種族.longName}</span></summary>""" + s"\n$ダメージ割合</details>"))
      else Some((ダメージ割合.無振.max, s"<details><summary>${最大ダメージを与えられるわざ.name} => ${相手の種族.longName}</summary>\n$ダメージ割合</details>"))
    }
    else None
  }).flatten.sortBy(_._1).reverse.map(_._2)

  case class 与ダメ一覧(攻撃側のポケモン: ポケモン, 防御側の種族: 種族, 使用するわざ: わざ) {
    val 無振: Damage = damageCalculationService.calcDamage(攻撃側のポケモン, BoxingBags(防御側の種族).無振, 使用するわざ)
    val 準振: Damage = damageCalculationService.calcDamage(攻撃側のポケモン, BoxingBags(防御側の種族).準振, 使用するわざ)
    val 最振: Damage = damageCalculationService.calcDamage(攻撃側のポケモン, BoxingBags(防御側の種族).最振, 使用するわざ)
    val all = 無振 :: 準振 :: 最振 :: Nil

    override def toString: String = s"無振: $無振\n準硬: $準振\n最硬: $最振"
  }

  case class 与ダメ割合一覧(攻撃側のポケモン: ポケモン, 防御側の種族: 種族, 使用するわざ: わざ) {
    private val boxingBags = BoxingBags(防御側の種族)
    private val 与ダメ = 与ダメ一覧(攻撃側のポケモン, 防御側の種族, 使用するわざ)
    val 無振: DamagePercentage = DamagePercentage(与ダメ.無振.min / boxingBags.無振.stats.h, 与ダメ.無振.max / boxingBags.無振.stats.h)
    val 準振: DamagePercentage = DamagePercentage(与ダメ.準振.min / boxingBags.準振.stats.h, 与ダメ.準振.max / boxingBags.準振.stats.h)
    val 最振: DamagePercentage = DamagePercentage(与ダメ.最振.min / boxingBags.最振.stats.h, 与ダメ.最振.max / boxingBags.最振.stats.h)
    val all = 無振 :: 準振 :: 最振 :: Nil

    private def 必要な行動回数のラベル(damagePercentage: DamagePercentage): String =
      if (damagePercentage.乱数何発 == damagePercentage.確定何発) s"確定${damagePercentage.確定何発}発"
      else s"乱数${damagePercentage.乱数何発}発"

    override def toString: String = s"<ul><li>無振: $無振 (${必要な行動回数のラベル(無振)})</li>\n<li>準振: $準振 (${必要な行動回数のラベル(準振)})</li>\n<li>最振: $最振 (${必要な行動回数のラベル(最振)})</li></ul>"
  }

  case class 被ダメ一覧(防御側のポケモン: ポケモン, 攻撃側の種族: 種族, 使用するわざ: わざ, 攻撃側積みわざ: Option[わざ] = None) {
    val 無振: Damage = damageCalculationService.calcDamage(BoxingBags(攻撃側の種族, 攻撃側積みわざ).無振, 防御側のポケモン, 使用するわざ)
    val 準振: Damage = damageCalculationService.calcDamage(BoxingBags(攻撃側の種族, 攻撃側積みわざ).準振, 防御側のポケモン, 使用するわざ)
    val 最振: Damage = damageCalculationService.calcDamage(BoxingBags(攻撃側の種族, 攻撃側積みわざ).最振, 防御側のポケモン, 使用するわざ)
    val all = 無振 :: 準振 :: 最振 :: Nil

    override def toString: String = s"無振: $無振\n準硬: $準振\n最硬: $最振"
  }

  case class 被ダメ割合一覧(防御側のポケモン: ポケモン, 攻撃側の種族: 種族, 使用するわざ: わざ, 攻撃側積みわざ: Option[わざ] = None) {
    private val 被ダメ = 被ダメ一覧(防御側のポケモン, 攻撃側の種族, 使用するわざ, 攻撃側積みわざ)
    val 無振: DamagePercentage = DamagePercentage(被ダメ.無振.min / 防御側のポケモン.stats.h, 被ダメ.無振.max / 防御側のポケモン.stats.h)
    val 準振: DamagePercentage = DamagePercentage(被ダメ.準振.min / 防御側のポケモン.stats.h, 被ダメ.準振.max / 防御側のポケモン.stats.h)
    val 最振: DamagePercentage = DamagePercentage(被ダメ.最振.min / 防御側のポケモン.stats.h, 被ダメ.最振.max / 防御側のポケモン.stats.h)
    val all = 無振 :: 準振 :: 最振 :: Nil

    private def 必要な行動回数のラベル(damagePercentage: DamagePercentage): String =
      if (damagePercentage.乱数何発 == damagePercentage.確定何発) s"確定${damagePercentage.確定何発}発"
      else s"乱数${damagePercentage.乱数何発}発"

    override def toString: String = s"<ul><li>無振: $無振 (${必要な行動回数のラベル(無振)})</li>\n<li>準振: $準振 (${必要な行動回数のラベル(準振)})</li>\n<li>最振: $最振 (${必要な行動回数のラベル(最振)})</li></ul>"
  }
}
