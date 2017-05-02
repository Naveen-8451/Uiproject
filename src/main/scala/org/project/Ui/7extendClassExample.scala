package org.project.Ui


import org.project.Ui.CreditCard

/*
 * Extending the base class in Scala is very similar to Java, with two contraints
 * One constraint is override keyword is required, unlike optional in java
 * The constraint helps in avoiding errors if overriden accidently
 * Constraint on Auxiliary constructors as seen in previous example is second one 
 */

/*
 * In the example below method toString which is overridden as per requirement
 */
class extCreditCard(val number: Int, var creditLimit: Int) {
	override def toString = "Card Number:" + number + "\n" + "creditLimit:" + creditLimit
}

/*
 * As in aux example, separate println is not required since toString is overridden
 */
object extClassApp {
  def main(args:Array[String]) {
       println(new CreditCard (123456789,100000))
       println("after overiding....")
       println(new extCreditCard (123456789,100000))
  }
}  