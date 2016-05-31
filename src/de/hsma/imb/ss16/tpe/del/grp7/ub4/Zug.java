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
	/**
	 * Defines the message for the exception.
	 */
	private static final String EX_NEGATIV_VALUE = "negativ value of velocity or position not allowed";
	/**
	 * Describes the shift.
	 */
	private static final int SHIT = 1;
	/**
	 * Defines one second in milliseconds.
	 */
	private static final int ONE_SECOND = 1000;
	/**
	 * Contains the track on which the block is.
	 */
	private Strecke track;
	/**
	 * Contians the length of the track.
	 */
	private int tracklength;
	/**
	 * Contains the block where the train is on.
	 */
	private Block currentBlock;
	/**
	 * Contains the next block of the current block.
	 */
	private Block nextBlock;
	/**
	 * Contains the index of the block of the track.
	 */
	private int nextBlockNr;
	/**
	 * Contains the name of the train.
	 */
	private char name;
	/**
	 * Contains the speed of the train.
	 */
	private int velocity;
	/**
	 * Contains the current position on the track.
	 */
	private int currentPos;
	/**
	 * Defines if the train is crashed into an other train.
	 */
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
	 * @param velocity  the trains pace
	 * @param position  the trains starting position
	 * @throws SimulationException 
	 */
	public Zug(Strecke str, char name, int velocity, int position) throws SimulationException {
		if(velocity < 0 || position < 0){
			throw new SimulationException(EX_NEGATIV_VALUE);
		}
		this.name = name;
		this.velocity = velocity;
		currentPos = position;
		track = str;
		tracklength = getTrack().getLength();
		for(Block b : getTrack().getBlockList()) {
			if(b.getStartPos() <= getCurrentPos() 
					&& b.getEndPos() >= getCurrentPos()) {
				currentBlock = b;
				getCurrentBlock().setNotFree();
				getCurrentBlock().getTrains().add(this);
				nextBlockNr = getTrack().getBlockList().indexOf(b) + SHIT;
				nextBlock = getTrack().getBlockList().get(getNextBlockNr());
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
				Thread.sleep(ONE_SECOND / getVelocity());
					move();
				checkCrashed();
			}
			if(targetReached()) {
				synchronized(getCurrentBlock()) {
					getCurrentBlock().leave();
					getCurrentBlock().notifyAll();
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
		if(getCurrentPos() + SHIT == getNextBlock().getStartPos()) {
			while(!getNextBlock().isFree()) {
				synchronized(getNextBlock()) {
					getNextBlock().wait();
				}
			}
			
			synchronized(getCurrentBlock()) {
				getCurrentBlock().leave();
				getCurrentBlock().notifyAll();
			}
			currentBlock = getNextBlock();
			if(getNextBlockNr() < getTrack().getBlockList().size() - SHIT) {
				nextBlockNr++; 
				nextBlock = getTrack().getBlockList().get(getNextBlockNr());
			}
			getCurrentBlock().setNotFree();
		}
				
		synchronized(getTrack()) {
			getTrack().getTrainPosition().remove(getCurrentPos(), this);		
			currentPos++;
			getTrack().getTrainPosition().put(getCurrentPos(), this);
			System.out.println(getTrack());
		}
	}
	
	/**
	 * In this method it is checked whether the trains position
	 * is equal to the position of an other train on the track.
	 * In this case those trains crash and crashed is set true.
	 */
	void checkCrashed() {
		synchronized(getTrack()) {
			for(Zug z : getTrack().getTrainList()) {
				if(!z.equals(this) && getCurrentPos() == z.getCurrentPos()) {
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
	public int getVelocity() {
		return this.velocity;
	}
	
	/**
	 * @return the track
	 */
	Strecke getTrack() {
		return track;
	}

	/**
	 * @return the tracklength
	 */
	int getTracklength() {
		return tracklength;
	}

	/**
	 * @return the currentBlock
	 */
	Block getCurrentBlock() {
		return currentBlock;
	}

	/**
	 * @return the nextBlock
	 */
	Block getNextBlock() {
		return nextBlock;
	}

	/**
	 * @return the nextBlockNr
	 */
	int getNextBlockNr() {
		return nextBlockNr;
	}
	
	/**
	 * @param velocity the velocity to set
	 */
	void setVelocity(int velocity) {
		this.velocity = velocity;
	}
}