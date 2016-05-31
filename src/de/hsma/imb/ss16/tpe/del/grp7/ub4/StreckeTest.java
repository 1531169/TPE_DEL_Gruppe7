package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StreckeTest {

	@Test(expected = SimulationException.class)
	public void testStreckeNullBlocklistt() throws SimulationException {
		ArrayList<Block> blocksList = null;
		@SuppressWarnings("unused")
		Strecke testTrack = new Strecke(blocksList);
	}

	@Test
	public void testAddZug() throws SimulationException {
		ArrayList<Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		Strecke testTrack = new Strecke(blocksList);
		boolean actual = testTrack.addZug(new Zug(testTrack, 'A', 1, 1));
		boolean expected = true;
		assertEquals(expected, actual);
	}

}
