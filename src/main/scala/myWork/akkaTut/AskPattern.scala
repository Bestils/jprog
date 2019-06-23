package myWork.akkaTut

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern._
import scala.concurrent.duration._
import  scala.concurrent.ExecutionContext.Implicits._

object AskPattern extends App{
  case object  AskName // jesli nie uzywamy rzadnego parametru to zamiast class lepiej uzyc obiekt
  case class NameResponse (name:String)

  class AskActor(val name:String) extends Actor {
     def receive = {
       case AskName => sender ! NameResponse(name)

     }

  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props(new AskActor("Pat") ),"AskActor")


  implicit val timeout = Timeout(3.seconds)
 val answer = actor ? AskName
  answer.foreach(n => println("Name is " +n))

system.terminate()

}
