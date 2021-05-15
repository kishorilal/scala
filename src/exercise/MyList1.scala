package exercise

abstract class MyList1[+T] {
  /*
  *
  * */
  def head: T
  def tail: MyList1[T]
  def isEmpty: Boolean
  def add[A>:T](element: A): MyList1[A]
  def printList: String
  override def toString: String = "["+printList+"]"
  def map[B](transformer: MyTransformer[T,B]): MyList1[B]
  def flatMap[B](transformer: MyTransformer[T, MyList1[B]]):MyList1[B]
  def filter(predicate: MyPredicate[T]): MyList1[T]
  def ++[B>:T](list: MyList1[B]): MyList1[B]

}
trait MyPredicate[-T] {
  def test(elememt: T):Boolean
}
trait MyTransformer[-A, B] {
  def transform(elemet: A): B
}
object Empty1 extends MyList1 [Nothing] {
  override def head: Nothing= throw new NoSuchElementException

  override def tail:MyList1[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >:Nothing ](element: B): MyList1[B] = new NonEmpty1(element, Empty1)

  override def printList: String = ""
  def map[B](transformer: MyTransformer[Nothing,B]): MyList1[B] = Empty1
  def flatMap[B](transformer: MyTransformer[Nothing, MyList1[B]]):MyList1[B] = Empty1
  def filter(predicate: MyPredicate[Nothing]): MyList1[Nothing] = Empty1
  def ++[B >: Nothing](list: MyList1[B]): MyList1[B] = list
}

class NonEmpty1[+A](h:A, t: MyList1[A]) extends MyList1 [A]{
  override def head: A = h

  override def tail: MyList1[A] = t

  override def isEmpty: Boolean = false

  override def add[B >:A](element: B): MyList1[B] = new NonEmpty1(element, t)

  override def printList: String = {
    if(t.isEmpty) " "+h
    else h+" "+t.printList

  }

  override def map[B](transformer: MyTransformer[A, B]): MyList1[B] =
    new NonEmpty1[B](transformer.transform(h), t.map(transformer))

  def flatMap[B](transformer: MyTransformer[A, MyList1[B]]): MyList1[B] =
    transformer.transform(h) ++ t.flatMap((transformer))
  def ++[B>:A](list:MyList1[B]):MyList1[B] =new NonEmpty1(h, t ++ list)

  override def filter(predicate: MyPredicate[A]): MyList1[A] = {
    if(predicate.test(h)) new NonEmpty1(h, t.filter(predicate))
    else t.filter(predicate)
  }
}
object ListTest1 extends App {
  val list = new NonEmpty1(4,new NonEmpty1(2,new NonEmpty1(1,Empty1)))
  println(list.map(new MyTransformer[Int, Int] {
    override def transform(elemet: Int): Int = elemet * 2
  }).toString)
  println("even number")
  println(list.filter(new MyPredicate[Int] {
    override def test(elememt: Int): Boolean = elememt % 2 == 0
  }).toString)
  val list1 = new NonEmpty1(4,new NonEmpty1(2,new NonEmpty1(1,Empty1)))
  println(list ++ list1)
  println(list1.flatMap(new MyTransformer[Int, MyList1[Int]] {
    override def transform(elemet: Int): MyList1[Int] = new NonEmpty1(elemet,new NonEmpty1(elemet + 1,Empty1))
  }).toString)
}


