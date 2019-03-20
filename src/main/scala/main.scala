object main extends App {
  var tab = new Array[String](2)
  for (i <- 0 to 1) {
    print("Podaj " + i + " element: ")
    tab(i) = io.StdIn.readLine.reverse
  }
  var tab1 = tab
  var sum = ""


  while (tab1(1).length() > 0 || tab1(0).length() > 0) {
    var x: Int = 0
    var y: Int = 0
    var i=0
    if (tab1(0).length() > 0 && tab1(0).length()>=tab1(1).length()-1) {
      x = tab1(0).charAt(i).toInt-'0'
      tab1(0) = tab1(0).drop(1)
    }
    if (tab1(1).length() > 0&&tab1(0).length()<=tab1(1).length()-1)  {
      y = tab1(1).charAt(i).toInt-'0'
      tab1(1) = tab1(1).drop(1)
    }
    var z=x+y
    if(z>9&&sum.length>0){

      var temp= sum.charAt(sum.length()-1)-'0'+z/10
      sum = sum.substring(0, sum.length - 1)
      sum+=temp
      z=z%10
    }


    sum += (z)
    i+=1
  }

  println(sum.reverse)
}