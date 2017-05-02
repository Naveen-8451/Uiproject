package org.project.Ui

/*
 * This application demonstrates how to instantiate a existing class in Scala
 * If the constructor of the class is parameter-less, parenthesis can be avoided
 */


object classInstApp {
  def main(args:Array[String]) {
    new StringBuilder("Hello")
    new StringBuilder()
    new StringBuilder
  }
}