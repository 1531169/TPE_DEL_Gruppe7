package de.hsma.imb.ss16.tpe.del.grp7.ub4;

/**
 * This class represents a train, which can drive on a track.
 * Each train has a name and a certain pace. A train also knows
 * his current position on the track as well as the block he is
 * in at a time and the next block. A train can only enter its
 * next block, when it is at the end of its current block and when
 * the next block is free. A train can also crash with
 * an other train in which case both trains will stop moving and
 * a SimulationException will be thrown.
 * 
 * @author Gruppe 7
 *
 */
public class Zug implements Runnable {
	
	private Strecke track;
	private int tracklength;
	private Block currentBlock;
	private Block nextBlock;
	private int nextBlockNr;
	private char name;
	private int pace;
	private int currentPos;
	private boolean crashed = false;
	
	/**
	 * Constructor of class Zug
	 * A block is the trains current block, when the trains
	 * current position is within the blocks borders. The tracks
	 * blocklist is used to determine the current as well as
	 * the next block. Also the current block will be set to not
	 * free and the train will be added to the blocks queue.
	 * 
	 * @param str  the track, where the train will drive on
	 * @param name  the name of the train
	 * @param pace  the trains pace
	 * @param pos  the trains starting position
	 */
	public Zug(Strecke str, char name, int pace, int pos) {
		this.name = name;
		this.pace = pace;
		currentPos = pos;
		track = str;
		tracklength = track.getLength();
		for(Block b : track.getBlockList()) {
			if(b.getStartPos() <= currentPos && b.getEndPos() >= currentPos) {
				currentBlock = b;
				currentBlock.setNotFree();
				currentBlock.getTrains().add(this);
				nextBlockNr = track.getBlockList().indexOf(b) + 1;
				nextBlock = track.getBlockList().get(nextBlockNr);
			}
		}
	}
	
	/**
	 * In the run-method the train will drive on the track as long
	 * as its end is not reached or as long as the train has not crashed
	 * with an other train. With a higher pace a train will drive faster.
	 */
	@Override
	public void run(){
		try{
			while(!targetReached() && !hasCrashed()) {				
				Thread.sleep(1000/pace);
				if(!hasCrashed()) {
					move();
				}
				checkCrashed();
			}
			if(targetReached()) {
				synchronized(currentBlock) {
					currentBlock.leave();
					currentBlock.notifyAll();
				}
			}
		}
		catch(InterruptedException e) {			
		}
	}
	
	/**
	 * This method is its class key method. The trains current position
	 * is increased by one and after updating the tracks map trainPosition
	 * the track is printed. If the trains next position is the
	 * starting position of the trains nextblock, the train will wait until
	 * the next block is free before processing. After waiting the current block
	 * is left and currentBlock and nextBlock are updated.
	 * 
	 * @throws InterruptedException
	 */
	void move() throws InterruptedException{		
		if(currentPos + 1 == nextBlock.getStartPos()) {
			while(!nextBlock.isFree()) {
				synchronized(nextBlock) {
					nextBlock.wait();
				}
			}
			
			synchronized(currentBlock) {
				currentBlock.leave();
				currentBlock.notifyAll();
			}
			currentBlock = nextBlock;
			if(nextBlockNr < track.getBlockList().size() - 1) {
				nextBlockNr++; 
				nextBlock = track.getBlockList().get(nextBlockNr);
			}
			currentBlock.setNotFree();
		}
				
		synchronized(track) {
			track.getTrainPosition().remove(currentPos, this);		
			currentPos++;
			track.getTrainPosition().put(currentPos, this);
			System.out.println(track);
		}
	}
	
	/**
	 * In this method it is checked whether the trains position
	 * is equal to the position of an other train on the track.
	 * In this case those trains crash and crashed is set true.
	 */
	void checkCrashed() {
		synchronized(track) {
			for(Zug z : track.getTrainList()) {
				if(!z.equals(this) && currentPos == z.getCurrentPos()) {
					setCrashed();
					z.setCrashed();
				}
			}
		}
	}
	
	/**
	 * Getter method for attribute crashed
	 * 
	 * @return  true, if train crashed
	 */
	boolean hasCrashed() {
		return crashed;
	}
	
	/**
	 * Setter method for attribute crashed.
	 * Sets crashed true.
	 */
	void setCrashed() {
		crashed = true;
	}
	
	/**
	 * method to check if end of the track is reached.
	 * 
	 * @return  true, if end reached.
	 */
	boolean targetReached() {
		return currentPos == tracklength;
	}
	
	/**
	 * Getter method for currentPos
	 * 
	 * @return  the trains current position
	 */
	public int getCurrentPos() {
		return this.currentPos;
	}
	
	/**
	 * Getter method for name
	 * 
	 * @return  the trains name
	 */
	public char getName() {
		return this.name;
	}
	
	/**
	 * Getter method for pace
	 * 
	 * @return the trains pace
	 */
	public int getPace() {
		return this.pace;
	}
}