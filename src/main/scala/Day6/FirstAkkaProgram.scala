package Day6

import akka.actor.{Actor, ActorSystem, Props}

class FirstAkkaProgram extends Actor {
  override def receive: Receive = {
    case msg: String => println(msg+" "+self.path.name)
    case _ => println("Invalid msg")
  }
}

  object Main extends App{
    var actorSystem = ActorSystem("ActorSystem")
    var actor = actorSystem.actorOf(Props[FirstAkkaProgram],"FirstAkkaProgram")
    actor ! "Hello Akka world"
    actor ! 1000
  }

