package org.project.Ui

/*
 * This class demonstrates auxiliary constructors in scala
 * Every auxiliary constructor will call auxiliary constructor that comes texually before it
 * The first auxiliary constructor will call the primary constructor
 * In turn primary constructor will be called every time
 */

/*
 * A class definition without braces and body
 * This is just to highlight that class definition can be without it
 * Does not have relation to primary constructor
 */
class auxCreditCard(val number: Int, var creditLimit: Int) {
	def this(number:Int) = this(number,0)
	def this() = this(1111111111)
}

/*
 * Since Scala creates private variables and public Getters and Setters no body is required
 */
object auxConstructorApp {
  def main(args:Array[String]) {
       val card = new auxCreditCard (123456789,100000)
       println("The limit of credit card #" + card.number + " is " + card.creditLimit)
       val card1 = new auxCreditCard (123456788)
       println("The limit of credit card #" + card1.number + " is " + card1.creditLimit)
       val card2 = new auxCreditCard
       println("The limit of credit card #" + card2.number + " is " + card2.creditLimit)
  }
}  