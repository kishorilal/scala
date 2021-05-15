package oops

object Coun extends App {
  var counter = new Counter()
  counter.increment
  println(counter.currentCount())
  println(counter.increment(4).currentCount())
}
class Counter(count: Int = 5) {
  def currentCount()  = this.count
  def increment() = new Counter(this.count + 1)
  def decrement() = new Counter(this.count - 1)
  def increment(a: Int):Counter = {
    if(a <= 0) this
    else increment.increment(a-1)
  } //snew Counter(this.count + a)
  def decrement(a: Int) = new Counter(this.count - a)
}
