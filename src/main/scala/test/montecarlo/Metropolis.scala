package montecarlo.test

import breeze.linalg._
import breeze.plot._

import scala.util.Random

/**
 * Created by david on 07.01.15.
 */
object Metropolis extends App {

  start()

  def start(): Unit = {
    standardGaussian = breeze.stats.distributions.Gaussian(0, 1)
    val n: Int = 2500000
    var xs = Array.fill(n)(0.0)
    xs(0) = 0.5

    var x_c: Double = 0
    0 to (n - 2) map {
      i => {
        x_c = normrnd(xs(i), 0.05)

        if (random < min(normpdf(x_c) / normpdf(xs(i))))
          xs(i + 1) = x_c
        else
          xs(i + 1) = xs(i)
      }
    }

    val f = Figure()
    val p = f.subplot(0)
    val x = linspace(0.0,1.0)
    p += hist(xs, 400)
    p.xlabel = "x axis"
    p.ylabel = "y axis"
    f.saveas("lines.png")

  }

  def normrnd(mu: Double, sigma: Double): Double = {
    breeze.stats.distributions.Gaussian(mu, sigma).draw()

  }

  var standardGaussian: breeze.stats.distributions.Gaussian = null

  def normpdf(x: Double) = {
    standardGaussian.pdf(x)
  }

  def min(b: Double) = Math.min(1, b)

  def random = Random.nextDouble()
}
