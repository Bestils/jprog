package myWork

object Mapowanko extends App {

  def add(network: Map[String,List[String]],person: String):Map[String,List[String]] = network + (person-> List())

//  def friend(network: Map[String, List[String]], a: String,b:String): Map[String,List[String]]={
//    val friendA = network(a)
//    val friendB = network(b)
//
//    network + (a -> friendA + b)
//  }
}
