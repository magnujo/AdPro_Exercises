package exeress

import scala.annotation.tailrec

object Exercises extends App {

  def fib(i: Int): Int = {
    @annotation.tailrec
    def go(i: Int, a: Int, b: Int): Int = {
      if (i==1) a
      else go(i-1, b, a+b)
    }
    go(i, 0, 1)
  }



  def findFirst[A] (as: Array[A], p: A => Boolean): Int = {
    def go(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else go(n+1)
    }
    go(0)
  }

  //print(findFirst(Array("sa","p","t"),(x: String) => x == "p"))

  def isSorted[A] (as: Array[A], ordered: (A,A) =>  Boolean): Boolean = {
    def loop(n: Int): Boolean = {
      if (n>=as.length) true
      else if (ordered(as(n-1), as(n))) loop(n+1)
      else false
    }
    loop(1)
  }

  //print(isSorted(Array(1,0,3), (x: Int, y: Int) => y >= x))

  def ordered (a: Int, b: Int): Boolean = {
    if (a<b) true
    else false
  }

  val myList = Array(1,2,3)
 // println(isSorted(Array(1,6,3),(a: Int, b: Int) => a<b))

 def isSorted2[A] (as: Array[A], ordered: (A,A) =>  Boolean): Boolean = {
    def loop(n: Int): Boolean = {
      if (n>=as.length) true
      else if (ordered(as(n-1), as(n))) loop(n+1)
      else false
    }
    loop(1)
  }




  def curry[A,B,C] (f: (A,B)=>C): A => (B => C) =
    (a:A)=>(b:B)=>f(a,b)

  def uncurry[A,B,C] (f: A => B => C): (A,B) => C = {
    (a:A, b:B) => f(a)(b)
  }


  def compose[A,B,C] (f: B => C, g: A => B) : A => C =
    (a:A) => f(g(a))

}
