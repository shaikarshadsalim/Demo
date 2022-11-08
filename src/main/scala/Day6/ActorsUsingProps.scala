package Day6

import akka.actor.{Actor, ActorSystem, Props}

class ActorsUsingProps extends Actor{
  override def receive: Receive = {
    case msg=>println(msg+" "+self.path.name)
  }
}

object Main2 extends App{
  var actorSystem=ActorSystem()
  var actor1=actorSystem.actorOf(Props[ActorsUsingProps],"Actor1")
  var props = Props[ActorsUsingProps]
  var actor2=actorSystem.actorOf(props,"Actor2")
  var actor3=actorSystem.actorOf(Props(classOf[ActorsUsingProps]),"Actor3")
  var actor4=actorSystem.actorOf(Props(new ActorsUsingProps()),name = "Actor4")//Not recommended

  actor1 ! "Hello"
  actor2 ! 1000
  actor3 ! 100.000
  actor4 ! 'a'
}
