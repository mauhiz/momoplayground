package net.mauhiz.util

object Graph {
	object Triangle {

		/**
		 * Takes 2 lists, where bl.size is 1 greater than sl.size. It will process pairs of rows
		 * from the triangle in the reverse order, that will satisfy the size constraint, since
		 * Row i contains 1 less element than Row (i+1).
		 *
		 * Hence, if row(i) contains k elements, row(i+1) will contain (k+1) elements.
		 * A meld(row(i+1), row(i)) will produce a new row(i)(call nrow(i)) with
		 * k elements and nrow(i, j) = row(i, j) + max(row(i+1, j), row(i+1, j+1)).
		 *
		 * In summary, meld merges the two rows and increments every element in the smaller row
		 * with the algebraic value of the bigger of its two adjacent elements.
		 */
		def meld(bl: List[Int], sl: List[Int]): List[Int] = {
			(bl, sl) match {
				case (bf :: bs :: brest, sf :: srest) ⇒ sf + math.max(bf, bs) :: meld(bs :: brest, srest)
				case (bf :: brest, s) if (brest.size == 1 && s.size == 1) ⇒ List(s.head + math.max(bf, brest.head))
				case (b, Nil) ⇒ Nil
			}
		}

		/**
		 * Iterates recursively over the triangle and melds all rows to reduce to the maximum sum.
		 */
		def reduce(trng: List[List[Int]]): List[List[Int]] = {
			trng match {
				case f :: s :: tail ⇒ reduce(meld(f, s) :: tail)
				case f :: Nil ⇒ List(f)
				case Nil => Nil
			}
		}

	}
}