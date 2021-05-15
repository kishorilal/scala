package basic

object CaseClasses extends  App {
/*
* equal, hashcode, toString
* */
  case class Person(name: String, age: Int)
  //1. class parametres
  val jim =new Person("Jim",25)
  println(jim.name)
  //sensible to string
  //println(instance) ==println(instance.toString) //syntactic sugar
  println(jim)
  val jim2 = new Person("Jim",26)
  println(jim == jim2)
  val jim3 = jim.copy(age = 24)
  println(jim3)

  //classes have companion object
  val thePerson = Person

}
