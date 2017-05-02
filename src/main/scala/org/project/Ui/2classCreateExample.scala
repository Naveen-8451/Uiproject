package org.project.Ui


/*
 * This application demonstrates Class creation in scala
 * A typically Java equivalent of the class is provided 
 * 
 ******** Java Version of the Class   
public class Car {  
  private final int year;
  private int miles;
  public Car(int yearOfMake) { year = yearOfMake; } 
  public int getYear() { return year; }
  public int getMiles() { return miles; }
  public void drive(int distance) {miles += Math.abs(distance);}
}
******* Needs creation of member fields, constructor, getters, methods 
 * 
 */


/*
 *In Scala class is not defined public
 *If define it without private keyword it is can be access in package or application
 *The name of the file and class can be different, there can be any number f classes
 *In Scala the entire class body is a constructor, hence no explicit constructor required
 *Classes can take parameters unlike Java, where methods take parameters
 *Code can directly be part of the class body in scala, since the body is constructor
 *In above example year is immutable, milesDriven in mutable
 * 
 */

class Car(val year: Int) {  
 private var milesDriven: Int = 0
 def miles = milesDriven 
 def drive(distance: Int) {milesDriven += Math.abs(distance)}
}


object classCreateApp {
  def main(args:Array[String]) {
    val car = new Car(2016)
    println("Car made in year " + car.year)
    println("Miles driven by the Car " + car.miles)
    car.drive(10)
    println("Miles driven by the Car " + car.miles)
    car.drive(100)
    println("Miles driven by the Car " + car.miles)
  }
}