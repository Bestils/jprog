package myWork

object SortowaniePatryka extends App{
  val r = scala.util.Random
  val randomArray = (for (i <- 1 to 100000000) yield r.nextInt(1000)).toArray

  // do the sorting
  var reference = System.nanoTime
  val sortedArray = quickSort(randomArray)

  var finishm = System.nanoTime
  System.out.println((finishm - reference).toDouble / 1000000000.0) //in seconds
   reference = System.nanoTime
  val sortedArray2 = patSort(randomArray)

   finishm = System.nanoTime

  System.out.println((finishm - reference).toDouble / 1000000000.0) //in seconds

  // the fp/recursive algorithm
  def quickSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        quickSort(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSort(xs filter (pivot <)))
    }
  }

  def patSort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs.sum/xs.length
      Array.concat(
        quickSort(xs filter (pivot >)),
        xs filter (pivot ==),
        quickSort(xs filter (pivot <)))
    }
  }


}
