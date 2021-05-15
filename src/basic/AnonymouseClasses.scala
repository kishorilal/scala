package basic

object AnonymouseClasses extends App {
  abstract class Animal {
    def eat: Unit
  }
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Anonymous class")
  }
  println(funnyAnimal.getClass)
}
