package codewars

object ReplaceWithAlphabetPosition extends  App {
  def alphabetPosition(str: String) : String = {

str.toLowerCase().map(x=>x +0).filter(_ > 96).filter(_ < 123).map(x=>x -'a'+1)mkString(" ")
    // zamienic filtr pozycjami z map


  }

}
