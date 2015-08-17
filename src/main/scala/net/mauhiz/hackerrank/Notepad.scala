package net.mauhiz.hackerrank

object Solution extends App {

	def nextMove(m: Int, r: Int, c: Int, grid: Array[String]) = {
		val matrix = grid.map { _.toCharArray }
		def locate(matrix: Array[Array[Char]], what: Char): Tuple2[Int, Int] = {
			for (i <- 0 until m; j <- 0 until m) {
				if (matrix(i)(j) == what) {
					return (i, j)
				}
			}
			throw new IllegalStateException
		}
		val me = locate(matrix, 'm');
		val princess = locate(matrix, 'p');
		def nextStep(myPos: Tuple2[Int, Int]) {
			myPos._1 - princess._1 match {
				case x if x > 0 =>
					println("UP");
				case x if x < 0 =>
					println("DOWN");
				case 0 => {
					myPos._2 - princess._2 match {
						case x: Int if x > 0 =>
							println("LEFT");
						case x: Int if x < 0 =>
							println("RIGHT");
						case 0 =>
					}
				}
			}
		}
		nextStep(me)
	}
}