package montecarlo.test

import scala.util.Random

/**
 * Created by david on 05.01.15.
 */
object Main extends App{

  test()

  def test() {
    println("Simple Monte Carlo to compute integral...")

    print(averageEps(1000, 100000))
  }

  def mc_classical(f: Double => Double, n: Int): Double = {
    var m: Double = 0


    0 to n map {_ => m = m + f(Random.nextDouble())}

    m/n
  }

  def averageEps(n: Int, nMc: Int) = {
    var m: Double = 0

    0 to n map {_ => m = m + Math.abs(mc_classical(x => x, nMc) - 0.5)}
    m/n
  }
}
