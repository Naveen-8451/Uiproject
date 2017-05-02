package org.project.Ui

/*
 * Higher Order Functions are functions that can take other functions as parameters
 * Function parameter signature specified Input Type => Output Type as shown below
 * Function may be inline defined while calling the high order function
 * Instead the function being passed can be defined with def
 */

object higherOrderFunc {

  def totalResultOverRange(number: Int, codeBlock: Int => Int) = {	
    var result = 0
    for (i <- 1 to number) {
      result += codeBlock(i)
    }
    result
  }
  
  def main(args: Array[String]) {	
    println(totalResultOverRange(11, i => i)) //sum
    println(totalResultOverRange(11, i => if (i % 2 == 0) i else 0)) //sum of even
    println(totalResultOverRange(11, i => if (i % 2 != 0) i else 0)) //sum of odd
  }
  
}