package com.yukihitoho.okido.models

sealed trait タイプ {
  def 倍率(防御側のタイプ: タイプ): Float
  protected val △ = 0.5f
  protected val × = 0f
  protected val ◯ = 2f
  protected val 等倍 = 1f
}

object タイプ {
  case object ノーマル extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case いわ => △
      case ゴースト => ×
      case はがね => △
      case _ => 等倍
    }
  }

  case object ほのお extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => △
      case みず => △
      case くさ => ◯
      case こおり => ◯
      case むし => ◯
      case いわ => △
      case ドラゴン => △
      case はがね => ◯
      case _ => 等倍
    }
  }

  case object みず extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => ◯
      case みず => △
      case くさ => △
      case じめん => ◯
      case いわ => ◯
      case ドラゴン => △
      case _ => 等倍
    }
  }

  case object くさ extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => △
      case みず => ◯
      case くさ => △
      case どく => △
      case じめん => ◯
      case ひこう => △
      case むし => △
      case いわ => ◯
      case ドラゴン => △
      case はがね => △
      case _ => 等倍
    }
  }

  case object でんき extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case みず => ◯
      case でんき => △
      case くさ => △
      case じめん => ×
      case ひこう => ◯
      case ドラゴン => △
      case _ => 等倍
    }
  }

  case object こおり extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => △
      case みず => △
      case くさ => ◯
      case こおり => △
      case じめん => ◯
      case ひこう => ◯
      case ドラゴン => ◯
      case はがね => △
      case _ => 等倍
    }
  }

  case object かくとう extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ノーマル => ◯
      case こおり => ◯
      case どく => △
      case ひこう => △
      case エスパー => △
      case むし => △
      case いわ => ◯
      case ゴースト => ×
      case あく => ◯
      case はがね => ◯
      case _ => 等倍
    }
  }

  case object どく extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case くさ => ◯
      case どく => △
      case じめん => △
      case いわ => △
      case ゴースト => △
      case はがね => ×
      case フェアリー => ◯
      case _ => 等倍
    }
  }

  case object じめん extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => ◯
      case でんき => ◯
      case くさ => △
      case どく => ◯
      case ひこう => ×
      case むし => △
      case いわ => ◯
      case はがね => ◯
      case _ => 等倍
    }
  }

  case object ひこう extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case でんき => △
      case くさ => ◯
      case かくとう => ◯
      case むし => ◯
      case いわ => △
      case はがね => △
      case _ => 等倍
    }
  }

  case object エスパー extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case かくとう => ◯
      case どく => ◯
      case エスパー => △
      case あく => ×
      case はがね => △
      case _ => 等倍
    }
  }

  case object むし extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => △
      case くさ => ◯
      case かくとう => △
      case どく => △
      case ひこう => △
      case エスパー => ◯
      case ゴースト => △
      case あく => ◯
      case はがね => △
      case フェアリー => △
      case _ => 等倍
    }
  }

  case object いわ extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => ◯
      case こおり => ◯
      case かくとう => △
      case じめん => △
      case ひこう => ◯
      case むし => ◯
      case はがね => △
      case _ => 等倍
    }
  }

  case object ゴースト extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ノーマル => ×
      case エスパー => ◯
      case ゴースト => ◯
      case あく => △
      case _ => 等倍
    }
  }

  case object ドラゴン extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ドラゴン => ◯
      case はがね => △
      case フェアリー => ×
      case _ => 等倍
    }
  }

  case object あく extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case かくとう => △
      case エスパー => ◯
      case ゴースト => ◯
      case あく => △
      case フェアリー => △
      case _ => 等倍
    }
  }

  case object はがね extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => △
      case みず => △
      case でんき => △
      case こおり => ◯
      case いわ => ◯
      case はがね => △
      case フェアリー => ◯
      case _ => 等倍
    }
  }

  case object フェアリー extends タイプ {
    override def 倍率(防御側のタイプ: タイプ): Float = 防御側のタイプ match {
      case ほのお => △
      case かくとう => ◯
      case どく => △
      case ドラゴン => ◯
      case あく => ◯
      case はがね => △
      case _ => 等倍
    }
  }
}
