package de.hsma.imb.ss16.tpe.del.grp7.ub4.simulationtest;

import java.util.ArrayList;

import de.hsma.imb.ss16.tpe.del.grp7.ub4.Block;
import de.hsma.imb.ss16.tpe.del.grp7.ub4.Simulation;
import de.hsma.imb.ss16.tpe.del.grp7.ub4.SimulationException;
import de.hsma.imb.ss16.tpe.del.grp7.ub4.Strecke;
import de.hsma.imb.ss16.tpe.del.grp7.ub4.Zug;

class SimulationTest {

	public static void main(String[] args) throws SimulationException {
		testSimulation();
	}
	
	/**
	 * This method shows an example scenario. First of all a track is created
	 * and blocks are added to this track. After that different trains are 
	 * created and added to the track as well. Then threads are created
	 * using the trains. These threads are started to let the trains drive
	 * on the track and print their process.
	 * @throws SimulationException 
	 */
	public static void testSimulation() throws SimulationException {
		ArrayList <Block> blocksList = new ArrayList<>();
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		blocksList.add(new Block(10));
		blocksList.add(new Block(10));
		blocksList.add(new Block(15));
		blocksList.add(new Block(10));
		blocksList.add(new Block(5));
		blocksList.add(new Block(5));
		Strecke strecke = new Strecke(blocksList);
		
		
		Zug z1 = new Zug(strecke, 'A', 5, 6);
		Zug z2 = new Zug(strecke, 'B', 15, 11);
		Zug z3 = new Zug(strecke, 'C', 5, 20);
		Zug z4 = new Zug(strecke, 'D', 10, 30);
		Zug z5 = new Zug(strecke, 'E', 6, 45);
		
		strecke.addZug(z1);
		strecke.addZug(z2);
		strecke.addZug(z3);
		strecke.addZug(z4);
		strecke.addZug(z5);
		
		Simulation.startSimulation(strecke);
	}
}
