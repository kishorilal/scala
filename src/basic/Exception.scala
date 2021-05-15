package basic


object Exception extends  App {

  val x: String = null
  //println(x.length)
  //throwable classes extends the throwable class
  // Exception and error are the major throwable subtype

  try {
    val ex: String = throw new NullPointerException;
  }catch {
    case ex: NullPointerException =>println("null pointer exception occure")
  }
  finally {
    println("finally blocked executed")
  }


  //stack overflow error
  def fact(x: Int): Int ={
    if(x<=1) 1
    else x * fact(x-1)
  }
  try{
    println(fact(5))
    println(fact(50000))
  }
  catch {
    case ex: StackOverflowError => println("stack over flow error")
  }
  case class OverFlowException(name: String) extends  RuntimeException
  case class UnderFlowException(name: String) extends  RuntimeException
  class PocketCalculator(x: Int, y: Int) {
    def add(x: Int, y: Int): Int ={
      val g = x + y;
      if(x >0 && y > 0 && g < 0) throw new OverFlowException("integer time exceed")
      else if(x < 0 && y < 0 && g >0) throw new UnderFlowException("integer time exceed")
      else g
    }
    def sub(x: Int, y: Int): Int ={
      val g = x - y;
      if(x > 0 && y < 0 && g < 0) throw new OverFlowException("integer time exceed")
      else if(x < 0 && y > 0 && g >0) throw new UnderFlowException("integer time exceed")
      else g
    }
    def div(x: Int, y: Int): Int ={

      if(y == 0 ) throw new OverFlowException("Divide by zero exception")
      else x / y
    }
  }
  val pocketCalculator  = new PocketCalculator(2,3)
  println(pocketCalculator.add(-2,-2000000000))
  println(pocketCalculator.sub(-2000000000,-2000000000))
  println(pocketCalculator.div(2000000000,1))
  //oom
 // val array = Array.ofDim(Int.MaxValue)
  //stack overflow
//  def inifinate : Int = 1 + inifinate
//  val infinit = inifinate
}
