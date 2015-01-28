package dtw.test

/**
 * Created by david on 09.01.15.
 */
object DTW extends App {

  DTWDistances(List(1,1,1,1,1,1,50,3,3,3,4,4),List(1,2,3))
  def DTWDistances(a: List[Int], b: List[Int]): Array[Array[Double]] = {
    var dtw = Array.ofDim[Double](a.length+1, b.length+1)

    println("Created array:")
    println (dtw.deep.mkString("\n"))

    0 to a.length foreach {i =>
      dtw(i)(0) = Double.PositiveInfinity
    }

    0 to b.length foreach {i =>
      dtw(0)(i) = Double.PositiveInfinity
    }
    dtw(0)(0) = 0

    println("Initialized start values: ")
    println (dtw.deep.mkString("\n"))

    0 to a.length-1 foreach {i => {
      0 to b.length-1 foreach {j => {
        val cost = d(a(i), b(j))

        dtw(i)(j) = cost + minimum( dtw(i)(j+1),
                                    dtw(i+1)(j),
                                    dtw(i)(j))
      }}
    }}

    println("Computation done:")
    println (dtw.deep.mkString("\n"))
    dtw
  }

  def d(s: Double, d: Double): Double = Math.abs(s-d)

  def minimum(a: Double, b: Double, c: Double) = Math.min(a,Math.min(b,c))
}
