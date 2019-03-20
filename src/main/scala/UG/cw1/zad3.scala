package UG.cw1

object zad3 extends App
{var a =1
  var sumOfN=0
  var sumOfP=0
  while(a!=0){
   a= io.StdIn.readInt()
    if (a<0)
      sumOfN+=1
    else if (a>0)
      sumOfP+=1
  }
  println("Number of negative is "+sumOfN)
  println("Number of positive is "+sumOfP)


}
