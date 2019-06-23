package myWork

class colkolcop {
  object Main extends App {
    import scala.io.Source

    val dane = Source.fromResource("napisy.txt").getLines.toList.map((s: String) => s.toString)


    val slowaNaK = (dane.filter((n: String) => n.head=='k')).size
    val palindromy = (dane.filter((n: String) => n==n.reverse)).size
    val slowaZ2A = {
      dane.map(_.toString().toList.groupBy(identity).mapValues(_.size))}
    val slowaZ2Ai = {
      dane.map(_.groupBy(identity).mapValues(_.size).filter((pair: (Char, Int)) => pair._1=='a'&& pair._2 >1)).filter(x=>x.isEmpty==false).size }

    val slowa200 = {
      dane.map(_.map(_.toInt))}


    //  println(slowaNaK)
    //  println(palindromy)
    //  println(slowaZ2Ai)
    println(slowa200)



  }


}
