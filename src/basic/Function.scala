package basic

import scala.annotation.tailrec

object Function extends  App {
  def aFunction(a: String, b: Int): String =
    a+" "+b
  println(aFunction("scala", 3))
  def aparameterLess() = 34
  println(aparameterLess())
  println(aparameterLess)

  def repeatFunction(aString: String, n: Int, acc: String): String = {
    if(n ==1) acc
    else repeatFunction(aString,n-1, acc + aString)
  }
//  val t1 = System.currentTimeMillis();
//  println(repeatFunction("Hello", 30000,""))
//  val t2 = System.currentTimeMillis();
//  println(t2-t1)
  def greetingFunction(name: String, age: Int): String = s"Hi, my name is $name and i am $age years old"
  println(greetingFunction("james", 12))
  @tailrec
  def fact(n : Int, acc: Int): Int ={
    if(n == 1) acc
    else fact(n-1, n * acc)
  }
  println(fact(10,1))
  def isPrime(n: Int ,incremetCounter: Int, Limit: Int):Boolean = {
    if(n % incremetCounter == 0) false
    else if(incremetCounter >= Limit) true
    else isPrime(n,incremetCounter+1,Limit)
  }
  println(if(isPrime(53,2,7)) "given number is prime" else "not prime")

  def finbonacci(n1: Int): Int  = {
    if(n1 <= 2) 1
    else finbonacci(n1-1) + finbonacci(n1-2)

  }
  println(5)

}
