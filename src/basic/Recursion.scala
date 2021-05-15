package basic

object Recursion extends App {
  def finbanacci(n: Int): Int ={
    def fib(IncrementCounter: Int, last: Int, nextToLast: Int): Int ={
      if(IncrementCounter >= n) last
      else fib(IncrementCounter +1, last + nextToLast, last)
    }
    fib(2,1,1)
  }
  println(finbanacci(8))
}
