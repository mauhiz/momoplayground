package net.mauhiz.codechef

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.junit.Assert._

class CMB01Test extends JUnitSuite {

	@Test def test1 = {
		assertEquals(net.mauhiz.codechef.CMB01.cmb01(Array("24", "1")), "34")
	}
}