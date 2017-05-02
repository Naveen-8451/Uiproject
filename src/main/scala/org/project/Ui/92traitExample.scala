package org.project.Ui

/*
 * Scala solves the problem of single implementation inheritance in Java using traits
 * Traits are like Interfaces in Java with concrete methods or partial implementation, and do more!!  
 * Trait avoid method collision by late binding with the method of class that mixes them in
 * Traits can declare fields and maintain state
 */

/*
 * Keyword trait is used in definition and does not accept class parameters
 */
trait Friend {
  val name: String
  def listen() = println(s"Your friend $name is listening")
}

/* 
 * Mixing the friend trait with human
 * If the class does not extend from any other class, extend keyword is used to mix in the trait
 */
class Human(val name: String) extends Friend

/*
 * If the class already extends a class, with keyword is used to mix in the trait
 * Multiple traits can be added by more with clauses
 * A class can override the method of of the trait as shown below
 */
class Animal
trait HasLegs
class Dog(val name:String) extends Animal with Friend with HasLegs {
  override def listen() = println(s"$name's listening quietly")
}

object UseFriend extends App {
  val john = new Human("John")
  val comet = new Dog("Comet")
  
  john.listen
  comet.listen
}
