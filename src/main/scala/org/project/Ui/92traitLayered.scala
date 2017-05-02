package org.project.Ui

import scala.collection.mutable.ArrayBuffer


class BasicIntQueue {
  private val buf=new ArrayBuffer[Int]
  def get = buf.remove(0)
  def put(x: Int) {buf+=x}
}

trait Doubling extends BasicIntQueue{
  override def put(x: Int) {super.put(2*x)}
}

trait Incrementing extends BasicIntQueue{
  override def put(x: Int) {super.put(x+1)}
}

trait Filtering extends BasicIntQueue{
  override def put(x: Int) { if(x>=0) super.put(x)}
}

/*
 * Traits further to the right are executed first
 * This could be useful in scenarios where you want to transform in stages
 * Multiple traits can be attached to objects unlike Java interfaces are only at the level of class 
 * Super calls next trait in the hierarchy, pass control to the left, it's not parent hierarchy
 */
object traitLayeredApp extends App {
  val queue=new BasicIntQueue with Doubling with Incrementing with Filtering
  queue.put(10)
  queue.put(20)
  queue.put(-1)
  queue.put(0)
  println(queue.get)
  println(queue.get)
  println(queue.get)
  //println(queue.get)
}