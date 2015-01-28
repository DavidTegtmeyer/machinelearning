val a = List(12,3,5,6)
val b = List(1,2,3)

var dtw = Array.ofDim[Double](a.length, b.length)

0 to a.length-1 foreach {i =>
  dtw(i)(0) = Double.PositiveInfinity
}

0 to b.length-1 foreach {i =>
  dtw(0)(i) = Double.PositiveInfinity
}
print(dtw)
dtw