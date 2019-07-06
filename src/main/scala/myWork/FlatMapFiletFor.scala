package myWork

object FlatMapFiletFor extends App {

val numbers = List(1,2,3,4)
  var chars= List('a','b','c','d')
  val colors = List("black","white")

  val combination = numbers.flatMap(n=>chars.map(c=> "" + c + n))
  val combinationColored = numbers.flatMap(n=>chars.flatMap(c=> colors.map( k =>  "" + k + c + n )))

  println(combinationColored)

  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars if  c < 'c'
    color <- colors
  } yield "" + color + c + n

  forCombinations.foreach(println)
}
