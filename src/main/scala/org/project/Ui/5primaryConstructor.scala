package org.project.Ui

/*
 * This class demonstrates primary constructors in scala
 * Earlier examples also had primary constructors, this is no different
 * The class definition in scala is itself a constructor
 * It is called primary construtor because we would be looking at auxillary instructors next
 */

/*
 * A class definition without braces and body
 * This is just to highlight that class definition can be without it
 * Does not have relation to primary constructor
 */
class CreditCard(val number: Int, var creditLimit: Int)

/*
 * Since Scala creates private variables and public Getters and Setters no body is required
 */
object primaryConsApp {
  def main(args:Array[String]) {
       val card = new CreditCard (123456789,100000)
       println("The limit of credit card #" + card.number + " is " + card.creditLimit)
       card.creditLimit = 500000
       println("The revised limit of credit card #" + card.number + " is " + card.creditLimit)
  }
}  