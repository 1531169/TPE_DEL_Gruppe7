package de.hsma.imb.ss16.tpe.del.grp7.ub4;

/**
 * This class includes the main method and it is the place
 * where the simulation is started.
 * 
 * @author Gruppe 7
 *
 */
public class Simulation {

	public static void main(String[] args) {
		
		testSimulation();
		
	}
	
	/**
	 * This method shows an example scenario. First of all a track is created
	 * and blocks are added to this track. After that different trains are 
	 * created and added to the track as well. Then threads are created
	 * using the trains. These threads are started to let the trains drive
	 * on the track and print their process.
	 */
	public static void testSimulation() {
		
		Strecke strecke = new Strecke(70);
		strecke.addBlock(new Block(10));
		strecke.addBlock(new Block(5));
		strecke.addBlock(new Block(10));
		strecke.addBlock(new Block(10));
		strecke.addBlock(new Block(15));
		strecke.addBlock(new Block(10));
		strecke.addBlock(new Block(5));
		strecke.addBlock(new Block(5));
		
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
		
		System.out.println(strecke);
		
		Thread t1 = new Thread(z1);
		Thread t2 = new Thread(z2);
		Thread t3 = new Thread(z3);
		Thread t4 = new Thread(z4);
		Thread t5 = new Thread(z5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
