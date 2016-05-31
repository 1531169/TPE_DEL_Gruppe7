package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import org.junit.Assert;
import org.junit.Test;

public class BlockTest extends Assert {

	@Test(expected = SimulationException.class)
	public void testBlockNegativLength() throws SimulationException {
		@SuppressWarnings("unused")
		Block b = new Block(-1);
	}
	@Test
	public void testBlock() throws SimulationException {
		int expected = 1;
		Block b = new Block(1);
		int actual = b.getLength();
		Assert.assertEquals(expected,actual);
	}
	@Test
	public void testIsFree() throws SimulationException {
		boolean expected = true;
		Block b = new Block(1);
		boolean actual = b.isFree();
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void testSetNotFree() throws SimulationException {
		boolean expected = false;
		Block b = new Block(10);
		b.setNotFree();
		boolean actual = b.isFree();
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void testGetStartPos() throws SimulationException {
		int expected = 0;
		Block b = new Block(10);
		b.setStartPos(0);
		int actual = b.getStartPos();
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void testGetEndPos() throws SimulationException {
		int expected = 10;
		Block b = new Block(10);
		b.setEndPos(10);
		int actual = b.getEndPos();
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void testGetLength() throws SimulationException {
		int expected = 10;
		Block b = new Block(10);
		int actual = b.getLength();
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void testSetStartPos() throws SimulationException {
		int expected = 0;
		Block b = new Block(10);
		b.setStartPos(0);
		int actual = b.getStartPos();
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void testSetEndPos() throws SimulationException {
		int expected = 10;
		Block b = new Block(10);
		b.setEndPos(10);
		int actual = b.getEndPos();
		Assert.assertEquals(expected,actual);
	}

}
