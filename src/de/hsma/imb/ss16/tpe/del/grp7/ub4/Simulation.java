package de.hsma.imb.ss16.tpe.del.grp7.ub4;

/**
 * This class includes the main method and it is the place
 * where the simulation is started.
 * 
 * @author Gruppe 7
 *
 */
public class Simulation {
	public static void startSimulation(Strecke track) {
		for(Zug zug : track.getTrainList()) {
			new Thread(zug).start();
		}
	}
}