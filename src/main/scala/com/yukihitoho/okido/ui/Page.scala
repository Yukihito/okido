package com.yukihitoho.okido.ui

import java.io.PrintWriter

case class Page(title: String, content: String) {
  val basePath = "C:\\Users\\Yukihito\\Documents\\thinkings\\pokemon"

  def fileName: String = s"$title.md"

  def write(): Unit = {
    val file = new PrintWriter(s"$basePath\\$fileName")
    try {
      file.write(content)
    } finally {
      file.close()
    }
  }
}