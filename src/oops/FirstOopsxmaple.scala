package oops

object FirstOopsxmaple extends App{
   val person = new Person(name = "jhon", age=20)
  println(person.x)
  person.greet("kishor")
}

class Person(name: String, val age: Int){
  val x  =4
  println(x +9)
  def greet(name: String) = println(s"${this.name} says: Hi $name")
}
