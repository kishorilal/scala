package exercise

abstract class MyList[+T] {
  /*
  *
  * */
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def add[A>:T](element: A): MyList[A]
  def printList: String
  override def toString: String = "["+printList+"]"
}
object Empty extends MyList [Nothing]{
  override def head: Nothing= throw new NoSuchElementException

  override def tail:MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >:Nothing ](element: B): MyList[B] = new NonEmpty(element, Empty)

  override def printList: String = ""
}
class NonEmpty[+A](h:A, t: MyList[A]) extends MyList [A]{
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >:A](element: B): MyList[B] = new NonEmpty(element, this)

  override def printList: String =
      if(t.isEmpty) " "+h
      else h+" "+t.printList
}
object ListTest extends App {
  val list = new NonEmpty("hello",new NonEmpty(1,Empty))
  println(list.toString)

}

