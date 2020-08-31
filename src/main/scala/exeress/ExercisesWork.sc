def isSorted (as: Array[Int], ordered: (Int,Int) =>  Boolean): Boolean = {

  def loop(n: Int): Boolean = {
    if (n>=as.length) false
    else if (ordered(as(n), as(n+1))) loop(n+1)
    else false
  }
  loop(0)
}

def ordered (a: Int, b: Int): Boolean = {
  if (a<b) true
  else false
}
val myList = Array(1, 2, 3, 4)
isSorted(myList, ordered)