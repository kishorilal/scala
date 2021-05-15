package basic

object Expressions extends App {
    val x = 1 + 2  //expression
    val y = 1.+(4)
    println(x == y)
    var z = 6
    z+=4
    print(z)
    val aCodition = if(true) 4 else 5;  //expression
    println(aCodition)
   val codeBlock = {
     val y = 3
     val x = y +1
     if(z > 2) "hello" else "good block"
   }
  println(codeBlock)
  val someValue = {
    2 < 3
  }
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
