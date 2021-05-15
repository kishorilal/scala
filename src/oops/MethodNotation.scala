package oops

//import jdk.nashorn.internal.runtime.OptimisticReturnFilters

object MethodNotation extends  App {
  class Person(val name: String, favourateMovie: String ,val age: Int = 10){
    def likes(movie: String) : Boolean = movie == favourateMovie
    def hangoutwith(person: Person) :String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person) :String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = this.name
    def isAlive() : Boolean = true
    def apply() :String = "this is jhon"
    def unary_+ : Person = new Person(this.name, this.favourateMovie, this.age + 1)
    def +(nickName: String) : Person = new Person(s"${this.name}("+nickName+")", favourateMovie)
    def learn(language: String): String = s"${this.name} is learn ${language}"
    def learnScala(): String = learn("Scala")
    def apply(n: Int): String =
      s"${this.name} watched ${this.favourateMovie} ${n} times"

  }
  val mary = new Person("mary", "interstaller")
  println(mary.likes("interstaller"))
  println(mary likes "in")
  val tom  = new Person("tom", "fight club")
  println(mary + tom)
  println(!mary)
  println(mary.unary_!)
  println(mary.isAlive)
  println(mary isAlive)
  println(mary.apply())
  println(mary learnScala )
  println((+mary).age)
  println((mary + "rockstar").name)
  println(mary apply 2)
}
