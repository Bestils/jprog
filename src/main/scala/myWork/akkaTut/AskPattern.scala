package myWork.akkaTut

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future
import scala.util.{Failure, Success}

object AskPattern extends App{
  case object  AskName // jesli nie uzywamy rzadnego parametru to zamiast class lepiej uzyc obiekt
  case class NameResponse (name:String)
  case class AskNameOf(other: ActorRef)



  class AskActor(val name:String) extends Actor {
     def receive = {
       case AskName => sender ! NameResponse(name)
         case AskNameOf(other) =>
           implicit val timeout = Timeout(3.seconds)
         val f = other ? AskName
           f.onComplete {
             case Success(NameResponse(n)) =>
               println("They said ther name was " + n)
               case Success(s)=>
               println("The didn't tell us their name.")
               case Failure(ex) =>
               println("Asking tgheir name failed.")
           }
           val currentSender = sender
         Future {
           currentSender ! "message"
         }
     }

  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props(new AskActor("Pat") ),"AskActor1")
  val actor2 = system.actorOf(Props(new AskActor("val") ),"AskActor2")


  implicit val timeout = Timeout(3.seconds)
  implicit  val ec = system.dispatcher
  val answer = actor ? AskName
  answer.foreach(n => println("Name is " +n))

  actor ! AskNameOf(actor2)

system.terminate()

}


