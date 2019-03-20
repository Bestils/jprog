package myWork

object OOBasics extends App{

  val person = new Person("John",26)
  println(person)
}
//constructor
class Person(name : String, age :Int)
{

}
class writer (val name:String, val surname:String,val age:Int){
  def fullname(): String = s"My name is ${this.name} $this.surname"

}
class novel (name : String,val time:Int,author:writer){
  def authorAge ():Int=author.age
  def isWritenBy=author.fullname()
//  def copy(year : Int) = this(year)
}
class Counter(val n: Int){
  def increase =new Counter(n+1)
  def decrease =new Counter(n-1)

  def increase(count: Int) =new Counter(n+count)
  def decrease(count: Int) =new Counter(n+count)

}