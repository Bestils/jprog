package myWork.akkaTut

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object HierarchyExample extends App{

  case object CreateChild
  case object  SignalChildren
  case object  PrintSignal

  class ParentActor extends  Actor {
    private var number = 0
    private  val children = collection.mutable.Buffer[ActorRef]()
    def receive ={
      case CreateChild =>
       children+= context.actorOf(Props[ChildActor],"child"+number)
        number += 1
      case SignalChildren =>
        children.foreach( _ ! PrintSignal)

    }
  }
class ChildActor extends Actor{
    def receive ={
      case PrintSignal => println(self)
    }

  }


  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor],"Parent1")


  implicit val timeout = Timeout(3.seconds)
  implicit  val ec = system.dispatcher
  actor ! CreateChild
  actor ! SignalChildren
  actor ! CreateChild
  actor ! CreateChild
  actor ! SignalChildren

system.terminate()

}


