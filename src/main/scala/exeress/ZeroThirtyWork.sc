sealed trait Tree[+A]
case class Leaf[A] (value: A) extends Tree[A]
case class Branch[A] (left: Tree[A], right: Tree[A]) extends Tree[A]



object Tree extends App{

  // Exercise 2

  val t = new Branch[Int](Leaf(1), Leaf(2))


  def size[A] (t :Tree[A]): Int = ???
 1+1

  // Exercise 3

  def maximum (t: Tree[Int]): Int = ???

  // Exercise 4

  def map[A,B] (t: Tree[A]) (f: A => B): Tree[B] = ???

  // Exercise 5

  def fold[A,B] (t: Tree[A]) (f: (B,B) => B) (g: A => B): B = ???

  def size1[A] (t: Tree[A]): Int = ???

  def maximum1 (t: Tree[Int]): Int = ???

  def map1[A,B] (t: Tree[A]) (f: A=>B): Tree[B] = ???

}