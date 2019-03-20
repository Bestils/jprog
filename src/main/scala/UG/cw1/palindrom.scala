package UG.cw1

object Main extends App {
  def isPalindrome[A](l: List[A]): Boolean = l match {
    case Nil => true
    case List(a) => true
    case list => (list.head == list.last && isPalindrome(list.tail.init))
  }
  def removeNth[A](myList: List[A], n: Int): List[A] =
    myList.zipWithIndex.collect { case (x,i) if (i + 1) % 2 != 0 => x }

  if (isPalindrome("ta".toList)) println("Git")

}