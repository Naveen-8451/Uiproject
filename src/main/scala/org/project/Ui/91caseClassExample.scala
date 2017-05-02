package org.project.Ui

/* 
 * This application demonstrates Case classes in scala
 * Case classes do not have constructor body
 * These are widely used in Spark because of syntactic conveniences in modeling records
 * By default all the variables are defined as val and hence only getter methods
 */


case class Person(lastname: String, firstname: String, birthYear: Int)


/*
 * Scala creates companion class and companion object automatically
 * Hence case classes are defined without using new keyword as shown below
 */
object caseClassApp {
  def main(args:Array[String]) {
    val p = Person("Lacava", "Alessandro", 1976)
    print(p.lastname )
  }
}