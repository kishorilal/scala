package oops

object abstactDatatype extends App{
  //abstact
  abstract class Animal{
    val creatureType: String
    def eat:Unit
  }
  class Dog extends Animal {
    override val creatureType: String = "canine"
    def eat = println("Dog is eating")
  }
  trait Carnivor {
    def eat(animal: Animal): Unit
  }

  val animal = new Dog
  //animal.eat
  class Crocodile extends Animal with Carnivor {
    override val creatureType: String = "croc"

    override def eat: Unit = "ndvkdjdas"
    override def eat(animal: Animal): Unit = println(animal.creatureType)
  }
  val crocodile = new Crocodile
  crocodile.eat(animal)
}
