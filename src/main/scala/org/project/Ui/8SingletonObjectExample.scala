package org.project.Ui

/*
 * This application demonstrates Singletons in Scala
 * Scala takes Significant departure from Java in how it deals with static objects
 * Singleton is a class that has only one instance
 * To create a singleton use the keyword object instead of class
 */



import scala.collection.mutable._

class Marker(val color: String) {  
  println(s"Creating ${this}" )
  override def toString = s"marker color $color" 
}

/* 
 * The Singleton object MarkerFactory demonstrated below
 * It helps reuse pre-created instance of class Marker 
 */
object MarkerFactory {  
  private val markers = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "yellow" -> new Marker("yellow"))
  def getMarker(color: String) = markers.getOrElseUpdate(color, new Marker(color))  
}

/* 
 * Singletons can be accessed by it's name directly as shown below
 */
object SingletonApp {
  def main(args:Array[String]) {
    println(MarkerFactory getMarker "blue")
    println(MarkerFactory getMarker "blue")
    println(MarkerFactory getMarker "red")
    println(MarkerFactory getMarker "green")
  }

}