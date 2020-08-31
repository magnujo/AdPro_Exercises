package exeress


object ZeroTwenty extends App with ExercisesInterface {





  def tail[A](as: List[A]): List[A] = as match {
    case fNil => Nil
    case Cons(x, xs) => xs
  }
  val t = new Cons[Int](1, List(2,3,4))


  def drop[A] (l: List[A], n: Int) : List[A] = {
    @annotation.tailrec
    def loop (l: List[A], n:Int): List[A] = l match {
      case Nil => Nil
      case Cons(x, xs) =>
        if (n==0) l
        else loop(xs, n-1)
    }
    loop(l, n)
  }

  print(drop(List(1,2,3,4), 3))

  // Exercise 4

  def dropWhile[A](as: List[A], f: A => Boolean): List[A] = as match {
    case Nil => as
    case Cons(x, xs) => if (f(x)) dropWhile(xs, f) else Cons(x, dropWhile(xs, f))
  }

 // print(dropWhile(List(3,2,1,5), (a: Int) => a == 3))

  /*def dropWhileCur[A] (as: List[A]) (f: A => Boolean): List[A] = as match {
    case Cons(h,t) if f(h) => dropWhileCur(t)(f)
    case _ => as
  }

//val t = dropWhileCur(List(1,2,3))*/

    /*
    append(List(1,2), List(4,5)
    Cons(1, Cons(2, Cons(4,Cons(5,nil)
    Cons(2, nil) => Cons(2, Cons(4,Cons(5,nil)
    Cons(nil) => Cons(4,Cons(5,nil)
     */


  // Exercise 5

  def init[A] (l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }

 // print(init(List(2,3,23,10)))

  // Exercise 6
  def foldRight[A,B] (as :List[A], z: B) (f : (A,B)=> B) :B = as match {
    case Nil => z
    case Cons (x,xs) => f (x, foldRight (xs,z) (f))
  }

  def length[A] (as: List[A]): Int = {
    foldRight(as, 0) ((x, y) => 1+y)

  }
 // print(length(List(1,2,3,4)))

  def tailSum (as: Array[Int]): Int = {
    @annotation.tailrec
    def loop(n: Int, acc: Int): Int = {
      if (n>=as.length) acc
      else loop(n+1, acc+as(n))
    }
    loop(0, 0)
  }


  //print(tailSum(Array(1,2,5,34)))

  // Exercise 7
  def foldLeft[A,B] (as: List[A], z: B) (f: (B, A) => B): B = as match {
    case Nil => z
    case Cons (x,xs) => foldLeft(xs, f(z, x)) (f)

    }

 // print(foldLeft(List(1,2,3),0) ((y,x)=>y+x))


  /*
  foldleft(Cons(1, Cons(2, Cons(3, Nil))), 0) (y, x) = > y+x
  go(Cons(1, Cons(2, Cons(3, Nil)) => go Cons(2, Cons(3, Nil)) + 1)

   */

  // Exercise 8
    def product (as: List[Int]): Int =
      foldLeft(as, 1) ((y,x)=>y*x)

 //print(product(List(1,3,4)))


 def length1[A] (as: List[A]): Int =
   foldLeft(as, 0) ((x,y)=>x+1)


//print(length1(List(1,23,4,5)))

  // Exercise 9

  def reverse[A] (as: List[A]): List[A] = ???




  // Exercise 10

  def foldRight1[A,B] (as: List[A], z: B) (f: (A, B) => B): B = ???

  // Exercise 11

  def foldLeft1[A,B] (as: List[A], z: B) (f: (B,A) => B): B = ???

  // Exercise 12

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2))
  }

  def concat[A] (as: List[List[A]]): List[A] = ???

  // Exercise 13

  def filter[A] (as: List[A]) (f: A => Boolean): List[A] = ???

  // Exercise 14

  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] = ???

  // Exercise 15

  def filter1[A] (l: List[A]) (p: A => Boolean) :List[A] = ???

  // Exercise 16

  def add (l: List[Int]) (r: List[Int]): List[Int] = ???

  // Exercise 17

  def zipWith[A,B,C] (f: (A,B)=>C) (l: List[A], r: List[B]): List[C] = ???

  // Exercise 18

  def hasSubsequence[A] (sup: List[A], sub: List[A]): Boolean = ???

  // Exercise 19

  def pascal (n: Int): List[Int] = ???

}