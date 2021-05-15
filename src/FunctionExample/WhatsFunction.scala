package FunctionExample

object WhatsFunction extends App {
  //dream; use functions as first class elements
  //problems
  var doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 5
  }
  println(doubler(4))
  val adder =new ((Int, Int, Int) => Double) {
    override def apply(element: Int, element1: Int,element2: Int =0): Double = element + element1 + element2
  }

  println(adder(4,5,3))
  val stringConcate = new ((String,String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(stringConcate("hello ","scala world"))

//  override def sum(a: Int, b: Int): (Int,Int)=> Int {
//    def add(c: Int,acc: Int = 0):Int = {
//      if(c > b) acc
//      else add(c+1,acc+a)
//    }
//    add(a)
//  }
}

trait  MyFunction[A,B] {
  def apply(element: A):B
}
trait MyFunction2[A,B,C,D] {

  def apply(element: A, element1: B,element2: C): D
}
