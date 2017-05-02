package org.project.Ui

/* 
 * This application demonstrates Companion objects
 * Singletons as seen in example, are stand-alone objects
 * Companion objects belong a a class and share same name with the class
 * Companion class and objects can access each others private fields
 */


import scala.collection.mutable._

/*
 * The constructor of the class Markers is defined private
 * But the companion object can access it
 */
class Markers private(val color: String) { 
  println(s"Creating ${this}")
  override def toString = s"marker color $color"
}

object Markers {  
  private val markers = Map(
    "red" -> new Markers("red"),
    "blue" -> new Markers("blue"),
    "yellow" -> new Markers("yellow"))
  def getMarker(color: String) = markers.getOrElseUpdate(color, new Markers(color))  
}

/*
 * You cannot create the instance of the Marker class directly unlike Singleton example
 */
object CompanionApp {
  def main(args:Array[String]) {
    println(Markers getMarker "blue")
    println(Markers getMarker "blue")
    println(Markers getMarker "red")
    println(Markers getMarker "green")
  }

}