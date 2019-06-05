package UG.cw7

object zadanie2 extends App{
  def pairPosNeg(seq: Seq[Double]): (Seq[Double], Seq[Double]) = seq.filter((n :Double) => n!=0).partition((n:Double)=>n<0)

  }

//Zadanie 2. Korzystając z metod filter i partition zdefiniuj funkcję:
//  def pairPosNeg(seq: Seq[Double]): (Seq[Double], Seq[Double]) = /* ... */
//  która podzieli sekwencję seq na parę liczb mniejszych i większych od 0.0 (liczby równe 0.0 powinny zostać pominięte).
//}
