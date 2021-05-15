package basic

object Generics extends {
    //use the type A
  class MyList[+T] {
      def add[B >: T](element: B):MyList[B] = ???
    }
  val listOfInterger = new MyList[Int]
  val string = new MyList[String]
  //generic method
  object  MyList {
    def empty[A]: MyList[A]= ???
    val emptyListInteger =MyList.empty[Int]
  }
  //variance probelm
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  //1. yes , List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ???
  //No = invariance
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]
  //3. Hell no:Contra variant
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded type
  class Cage[A <: Animal](animal: A)


}
