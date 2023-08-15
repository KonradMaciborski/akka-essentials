package part2actors

import akka.actor.{Actor, ActorSystem, Props}

import java.lang.Thread

object ActorCapabilities extends App {

  class SimpleActor extends Actor {
    override def receive: Receive = {
      case message: String => println(s"[simple actor] I have received a: $message")
      case message: Int => println(s"[simple actor] I have received a: $message")
    }
  }

  val system = ActorSystem("actorCapabilitiesDemo")

  val simpleActor = system.actorOf(Props[SimpleActor], "simpleActor")

  simpleActor ! "hello, actor"
  simpleActor ! 2137

  class Counter extends Actor {
    var c: Int = 0
    override def receive: Receive = {
      case num: Int => {
        c += 1
        println(s"Counter is now equal: $c.")
      }
    }
  }

  val counter = system.actorOf(Props[Counter], "counter")

  (0 to 8).foreach(_ =>
    counter ! 1
  )

}
