package UG.cw8

object zadanie5 {
//Zadanie 5. Korzystając z ciągu wszystkich stref czasowych (postaci Kontynent/Strefa):
  //val strefy: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
  //oraz oparacji na ciągach i zasugerowanej we wskazówce operacji stripPrefix na napisach, wyszukaj strefy znajdujące się w Europie i posortuj rosnąco ich nazwy względem długości. Strefy, których nazwy mają taką samą długość posortuj w kolejności alfabetycznej.
  //Podpowiedź: wykorzystaj między innymi metody: map, filter oraz standardową operację na napisach:
  //def stripPrefix(prefix: String): String
  //która usuwa podany prefiks z napisu, np.
  //"ala ma kota".stripPrefix("ala ") -> "ma kota"

  def europeanZonesSorted(): Seq[String] = {
    val zones: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
    println(zones)
    zones.filter( (s: String) => s.startsWith("Europe") ).map((s: String) => s.stripPrefix("Europe/"))
      .sortWith((a: String, b: String) => if(a.length == b.length) { a < b } else a.length < b.length)
      .map((s: String) => "Europe/" + s)
  }

}
