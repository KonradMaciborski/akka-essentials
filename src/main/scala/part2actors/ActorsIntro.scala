package part2actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {

  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)

  class WordCountActor extends Actor {
    var totalWords = 0
    def receive: Receive = {
      case message: String =>
        println(s"I have received message: '$message'")
        totalWords = message.split(" ").length
      case msg => println(s"I can't understand ${msg.toString}")
    }
  }

  val wordCounter = actorSystem.actorOf(Props[WordCountActor], "wordCounter")

  wordCounter ! "I am learning akka and it is cool"

}
