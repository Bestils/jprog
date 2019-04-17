package UG.cw6

object zadanie5 extends App{

// . Stwórz generyczne funkcje rekurencyjne:
  //size - liczy elementów.
  //reverse - zwraca odwróconą sekwencję.
  //applyForAll - wykona funkcję dla wszystkich elementów sekwencji.
  //filter - zwraca sekwencję zawierającą elementy zgodne z predykatem.
  //forall - sprawdza czy wszystkie elementy spełniają predykat.
  //które wykorzystają funckję compute. Zdefiniuj funkcję z użyciem rekurencji ogonowej.

  def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = {
    @tailrec
    def aux (seq: Seq[A], out: B ): B = seq match {
      case e +: r => aux(r, op(e, out))
      case Seq() => out
    }
    aux (seq, init)
  }

  //a.
  def size[A](a: Seq[A]): Int = compute(a)(0)((_,n: Int)=> n+1)

  //b.
  def reverse[A](a: Seq[A]): Seq[A] = compute(a)(Seq(): Seq[A])((e: A, out: Seq[A]) => e +: out)

  //c.
  def applyforall[A, B](a: Seq[A], f: A => B): Seq[B] = compute(a)(Seq(): Seq[B])((a: A, out: Seq[B]) => f(a) +: out).reverse

  //d.
  def filter[A](a: Seq[A], pred: A=>Boolean): Seq[A] = compute(a)(Seq(): Seq[A])((a: A, out: Seq[A]) =>
    if(pred(a)) a +: out else out).reverse

  //e.
  def forall[A](a: Seq[A], pred: A=>Boolean): Boolean = compute(a)(true)((a: A, out: Boolean) =>
    if (pred(a)) out else false)
//21708623