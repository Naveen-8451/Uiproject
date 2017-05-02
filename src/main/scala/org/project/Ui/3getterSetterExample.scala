package org.project.Ui

/*
 * Whenever a variable is defined, getters and setters are automatically created in Scala
 * The variable is declared as private and getters and setters are publicaaly exposed
 * If the variable is defined as private then getters and setters are private
 * For val declaration only getters are provided, since the variable is immutable
 */

class SimpleCar(val year: Int) {	
 var miles = 0
}

/*
 * The miles variable is incremented using getter and setter method
 * Second time the default miles setter is called using method name miles_= 
 */
object classGSApp {
  def main(args:Array[String]) {
    val car = new SimpleCar(2016)
    println("Car made in year " + car.year)
    println("Miles driven by the Car " + car.miles)
    car.miles += Math.abs(10)
    println("Miles driven by the Car " + car.miles)
    car.miles_=(car.miles + 1000)
    println("Miles driven by the Car " + car.miles)
  }
}