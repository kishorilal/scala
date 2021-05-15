package oops

object OopsExample extends App{
    val writer = new Writer("robert", "smith", 1985)
    val novel = new Novel("rich poor dad", 2000,writer)
    println(novel.isWrritenBy(writer))
  println(novel.authorAge())

}

class Writer(name: String, surname: String, val year: Int) {
  def fullName(): String = this.name +" "+this.surname
}
class Novel(name: String, year_of_release: Int, author: Writer) {
  def authorAge() = year_of_release - author.year
  def isWrritenBy(auther: Writer): Boolean = auther == this.author
  def copy(new_year_of_release: Int) = new Novel(name, new_year_of_release, author)
}