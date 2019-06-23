package myWork.akkaTut

import akka.actor.{Actor, ActorSystem, Props}

object SimpleActorExample extends App{
  class SimpleActor extends Actor {
     def receive = {
       case s:String => println("String : "+ s)
       case i:Int => println("number : "+ i)
     }
    def foo = println("normal method")
  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SimpleActor],"SimpleActor")

println("Before message")
  actor ! " Hi there."
  println("After String")
  actor ! 42
  println("After Int")
  actor ! 'a'
  println("After Char")


}
