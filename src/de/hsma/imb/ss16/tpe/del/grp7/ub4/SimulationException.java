package de.hsma.imb.ss16.tpe.del.grp7.ub4;

/**
 * Exception for errors in the Simulation.
 * 
 * @author Gruppe 7
 *
 */
public class SimulationException extends Exception {

	/**
	 * Contructor of the Exception.
	 */
	public SimulationException() {
	}

	/**
	 * Contructor of the Exception. Gives a given message
	 * to the super class.
	 */
	public SimulationException(String message) {
		super(message);
	}
}