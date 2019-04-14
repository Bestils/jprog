package UG.cw4

object zadanie2 extends App{
  type Pred[A] = A => Boolean
  def and[A](p: Pred[A], q: Pred[A]): Pred[A] = {n:A => p(n)&& p(q)}
  def or[A](p: Pred[A], q: Pred[A]): Pred[A] = {n:A => p(n)|| p(q)}
  def not[A](p: Pred[A]): Pred[A] = {n:A => !p(n)}
  def imp[A](p: Pred[A], q: Pred[A]): Pred[A] = {n:A => (p(n)&& p(q))||(!p(n)&& p(q))}

}
