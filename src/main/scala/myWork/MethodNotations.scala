package myWork

object MethodNotations extends App
{
class  Person(val name: String,val  favoriteMovie : String, val age  : Int=10)
  {
    def likes(movie : String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} i hanging out with ${person.name}"
    def +(nickname: String): Person =new Person(nickname,"rocstar")
   def unary_! : String = s"$name, what the heck!?"
   def unary_+(person: Person) : Person = new Person(person.name,person.favoriteMovie,person.age+1)
    def isAlive :  Boolean = true
    def lerns :  String = s"$mary lerns scala"
    def lernScala :  String =  "scala" + lerns
    def apply() : String = s"Hi my name is $name  nad i like $favoriteMovie"
    def apply(n: Int) : String = s"$name watched $favoriteMovie $n times"
  }
  val  mary = new Person("Mary","Inception")
  println(mary.likes("Inception"))
  val tom = new Person("Tom", " fight Club")
  println(mary + tom)
}
