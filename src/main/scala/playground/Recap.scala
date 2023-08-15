package playground

object Recap extends App {

  val partialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 64
    case _ => 666
  }

  val pf = (x: Int) => x match {
    case 1 => 3
    case _ => 5
  }

  println(pf(1))

}
