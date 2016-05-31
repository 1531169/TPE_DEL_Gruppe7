package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import java.util.LinkedList;
import java.util.Queue;


/**
 * This class represents a block, which can be part
 * of a track. When a block is added on a track its
 * start and end position are set depending on the position
 * on the track. A block has a certain length and
 * the state free or not free. A block also keeps information
 * about the trains on it.
 * 
 * @author Gruppe 7
 *
 */
public class Block {
	/**
	 * Message for the exception.
	 */
	private static final String EX_NOT_ALLOWED_LENGTH = "length of Block can't be null or negative";
	/**
	 * Defines the state of the signal.
	 */
	private boolean isFree = true;
	/**
	 * Contains the start position of a block.
	 */
	private int startPos;
	/**
	 * Contains the end position of a block.
	 */
	private int endPos;
	/**
	 * Contains the length of a block.
	 */
	private int length;
	/**
	 * Contains the trains which are on this block.
	 */
	private Queue<Zug> trains;
	
	/**
	 * Constructor of class Block
	 * 
	 * @param length  Length of the block
	 * @throws SimulationException 
	 */
	public Block(int length) throws SimulationException {
		if (length < 0) {
			throw new SimulationException(EX_NOT_ALLOWED_LENGTH);
		}
		
		this.length = length;
		trains = new LinkedList<>();
	}
	
	/**
	 * Getter method for isFree
	 * 
	 * @return  whether block is free or not free
	 */
	boolean isFree() {
		return this.isFree;
	}

	/**
	 * This method will be used by a train, when it
	 * is at the end of the block, to leave the block.
	 * If after leaving there is no train on this block 
	 * left, the state of the block will be set to isFree
	 * and a waiting train can enter this block.
	 */
	void leave() {
		getTrains().poll();
		if(getTrains().isEmpty()) {
			setFree();
		}
	}
	
	/**
	 * Set the signal to true ("green").
	 */
	private void setFree() {
		this.isFree = true;
	}
	
	/**
	 * Set the signal to false ("red").
	 */
	void setNotFree() {
		this.isFree = false;
	}
	
	/**
	 * Getter method for startPos
	 * 
	 * @return  the blocks starting position
	 */
	public int getStartPos() {
		return this.startPos;
	}
	
	/**
	 * Getter method for endPos
	 * 
	 * @return  the blocks ending position
	 */
	public int getEndPos() {
		return this.endPos;
	}
	
	/**
	 * Getter method for length
	 * 
	 * @return  the blocks length
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * Setter method for startPos
	 * Will be used when block is added to track
	 * 
	 * @param pos  the blocks starting position
	 */
	void setStartPos(int pos) {
		this.startPos = pos;
	}
	
	/**
	 * Setter method for endPos
	 * Will be used when block is added to track
	 * 
	 * @param pos  the blocks ending position
	 */
	void setEndPos(int pos) {
		this.endPos = pos;
	}
	
	/**
	 * Returns the list of the trains of the block.
	 * @return
	 */
	Queue<Zug> getTrains() {
		return trains;
	}
}