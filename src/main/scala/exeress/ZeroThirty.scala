// Advanced Programming, A. Wąsowski, IT University of Copenhagen
//
// Group number: _____
//
// AUTHOR1: __________
// TIME1: _____ <- how much time have you used on solving this exercise set
// (excluding reading the book, fetching pizza, and going out for a smoke)
//
// AUTHOR2: __________
// TIME2: _____ <- how much time have you used on solving this exercise set
// (excluding reading the book, fetching pizza, and going out for a smoke)
//
// You should work with the file by following the associated exercise sheet
// (available in PDF from the course website).
//
// The file shall always compile and run after you are done with each exercise
// (if you do them in order).  Please compile and test frequently. Of course,
// some tests will be failing until you finish. Only hand in a solution that
// compiles and where tests pass for all parts that you finished.  The tests
// will fail for unfnished parts.  Comment such out.

package exeress

import jdk.nashorn.internal.ir.BreakableNode


// Try the following (and similar) tests in the repl (sbt console):
// val p = new java.awt.Point(0,1) with OrderedPoint
// val q = new java.awt.Point(0,2) with OrderedPoint
// assert(p < q)

sealed trait Tree[+A]
case class Leaf[A] (value: A) extends Tree[A]
case class Branch[A] (left: Tree[A], right: Tree[A]) extends Tree[A]



object Tree extends App{

  // Exercise 2

  val t = new Branch[Int](Branch(Leaf(1),Leaf(2)), Leaf(3))

  print(t)


  def size[A] (t :Tree[A]): Int = t match {
    case Leaf(x) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }


  // Exercise 3

  def maximum (t: Tree[Int]): Int = t match {
    case Leaf(x) => x
    case Branch(l, r) => maximum(l) max maximum(r)
  }





  // Exercise 4

  def map[A,B] (t: Tree[A]) (f: A => B): Tree[B] = t match {
    case Leaf(x) => Leaf(f(x))
    case Branch(l, r) => Branch(map (l) (f), map (r) (f))
  }

  // Exercise 5

  def fold[A,B] (t: Tree[A]) (f: (B,B) => B) (g: A => B): B = t match {
    case Leaf(x) => g(x)
    case Branch(l, r) => f(fold(l) (f) (g), fold(r) (f) (g))
  }


  def size1[A] (t: Tree[A]): Int =
    fold(t) ((l: Int, r: Int) => l+r) (_ => 1)

  def maximum1 (t: Tree[Int]): Int =
    fold(t) ((l: Int, r: Int) => l max r) ((p: Int) => p)

  def map1[A,B] (t: Tree[A]) (f: A=>B): Tree[B] =
    fold(t) ((l: Tree[A], r: Tree[A]) => Branch(f(l), f(r))) ((p: A) => Leaf(f(p)))

}
