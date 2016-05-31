package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ZugTest {

	@Test(expected = SimulationException.class)
	public void testZugNegativePosition() throws SimulationException {
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		Strecke testTrack = new Strecke(blocksList);
		@SuppressWarnings("unused")
		Zug z = new Zug(testTrack, 'a', 2, -1);

	}

	@Test(expected = SimulationException.class)
	public void testZugNegativeVelocity() throws SimulationException {
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		Strecke testTrack = new Strecke(blocksList);
		@SuppressWarnings("unused")
		Zug z = new Zug(testTrack, 'a', -1, 2);

	}

	@Test
	public void testMove() throws SimulationException, InterruptedException {
		int expected = 16;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'A', 1000, 1);
		new Thread(z).start();
		Thread.sleep(25);
		int actual = z.getCurrentPos();
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testCheckCrashed() throws SimulationException, InterruptedException {
		boolean expected = false;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'a', 1500, 1);
		Zug z2 = new Zug(testTrack, 'B', 1000, 2);
		new Thread(z).start();
		new Thread(z2).start();
		Thread.sleep(1);
		boolean actuals = z.hasCrashed();
		assertEquals(expected, actuals);
	}

	@Test
	public void testHasCrashed() throws SimulationException {
		boolean expected = false;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'a', 1, 1);
		boolean actual = z.hasCrashed();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCrashed() throws SimulationException {
		boolean expected = true;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'a', 1, 1);
		z.setCrashed();
		boolean actual = z.hasCrashed();
		assertEquals(expected, actual);
	}

	@Test
	public void testTargetReached() throws SimulationException {
		boolean expected = false;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'A', 1000, 1);
		boolean actual = z.targetReached();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCurrentPos() throws SimulationException {
		int expected = 10;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'A', 1000, 10);
		int actual = z.getCurrentPos();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetName() throws SimulationException {
		char expected = 'A';
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'A', 1, 1);
		char actual = z.getName();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetVelocity() throws SimulationException {
		int expected = 1;
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		Zug z = new Zug(testTrack, 'A', 1, 1);
		int actual = z.getVelocity();
		assertEquals(expected, actual);
	}

}
