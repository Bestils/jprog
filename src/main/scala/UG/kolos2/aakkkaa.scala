package UG.kolos2

import akka.actor._

object Komunikaty {
  case class Init(liczbaUczniow : Int, liczbaNauczycieli : Int);
  case class Przyjmij(uczniowie : Set[ActorRef]);
  case class Odpowiedzi(odp : Seq[Boolean]);
  case object Pytania;
  case class Wynik(uczen : ActorRef, ocena : Int)
  case object Koniec
}


class Wychowawca extends Actor {
  import Komunikaty._
  def receive : Receive = {
    case Init(liczbaUcz, liczbaNau) =>
      val uczniowie = for {
        i <-1 to liczbaUcz
      } yield (context.actorOf(Props[Uczen], "uczen" + i))
      context.actorOf(Props[Nauczyciel], "nauczyciel") ! Przyjmij(uczniowie.toSet)
      context.become(zbieranieOcen(uczniowie.toSet, 1, 0, liczbaNau))
  }

  def zbieranieOcen(uczniowie : Set[ActorRef], sumaOcen : Double, stworzonychNauczycieli : Int, liczbaNauczycieli : Int) : Receive = {
    case Wynik(uczen, ocena) =>
      context.become(zbieranieOcen(uczniowie, sumaOcen + ocena, stworzonychNauczycieli, liczbaNauczycieli))
    case Koniec if (liczbaNauczycieli  == stworzonychNauczycieli + 1) =>
      println("Srednia ocen uczniow to " + (sumaOcen / (liczbaNauczycieli * uczniowie.size)));
    case Koniec =>
      context.actorOf(Props[Nauczyciel], s"nauczyciel$stworzonychNauczycieli") ! Przyjmij(uczniowie)
      context.become(zbieranieOcen(uczniowie, sumaOcen, stworzonychNauczycieli + 1, liczbaNauczycieli))
  }
}



class Nauczyciel extends Actor {
  import Komunikaty._
  def receive : Receive = {
    case Przyjmij(uczniowie) =>
      uczniowie.foreach(_ ! Pytania)
      context.become(przyjmijOdpowiedzi(sender(), uczniowie.size));
  }
  def przyjmijOdpowiedzi(wychowawca : ActorRef, liczbaUczniow : Int) : Receive = {
    case Odpowiedzi(seq) if (liczbaUczniow - 1 == 0)=>
      wychowawca ! Wynik(sender(), seq.filter(_ == true). size + 1)
      wychowawca ! Koniec
      context.stop(self)
    case Odpowiedzi(seq) =>
      wychowawca ! Wynik(sender(), seq.filter(_ == true). size + 1)
      context.become(przyjmijOdpowiedzi(wychowawca, liczbaUczniow - 1))
  }
}


class Uczen extends Actor {
  import Komunikaty._
  def getAnswer(): Boolean = {
    Math.random() > 0.5
  }
  def receive : Receive = {
    case Pytania =>
      val seq : Seq[Boolean] = for {
        i<-1 to 5
      } yield getAnswer();
      sender() ! Odpowiedzi(seq)
  }
}

object Main extends App {
  import Komunikaty._
  import scala.io.Source

  val system = ActorSystem("sys");
  val wychowawca = system.actorOf(Props[Wychowawca], "wych");
  println();
  wychowawca ! Init(10,10)
}