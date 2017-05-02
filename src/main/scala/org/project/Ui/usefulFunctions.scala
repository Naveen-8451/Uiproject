package org.project.Ui

object usefulFunctions {
  def main(args:Array[String]) {
    println("**********Starting with foreach**************")
    "Hello".foreach(x => println(x))
    
    println("**********Now the map************")
    (0 to 9).map(_*0.2).foreach(println)
    
    println("**********Now the map filter************")
    (0 to 100).filter(_ % 9 ==0).foreach(println)
    
    println("**********Split and sortwith************")
    "That is a snippet that demonstrates max wordcount"
      .split(" ")
      .sortWith(_.length > _.length)
      .foreach(println _)
  }
}