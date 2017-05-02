package org.project.Ui

/*
 * This app demonstrates redefinition of getters and setters automatically created by scala
 */

class overwriteCar(val year: Int) {	
 private var milesdriven = 0
 def miles = milesdriven
 def miles_=(distance: Int) {milesdriven += Math.abs(distance)}
}


object classGSPApp {
  def main(args:Array[String]) {
    val car = new overwriteCar(2016)
    println("Car made in year " + car.year)
    println("Miles driven by the Car " + car.miles)
    car.miles = 10
    println("Miles driven by the Car " + car.miles)
    car.miles = 100
    println("Miles driven by the Car " + car.miles)
  }
}