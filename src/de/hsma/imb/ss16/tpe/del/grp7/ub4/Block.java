package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a block, which can be part
 * of a track. When a block is added on a track its
 * start and endposition are set depending on the position
 * on the track. A block has a certain length and
 * the state free or not free. A block also keeps information
 * about the trains on it.
 * 
 * @author Gruppe 7
 *
 */
public class Block {
	
	private boolean isFree = true;
	private int startPos;
	private int endPos;
	private int length;
	private Queue<Zug> trains;
	
	/**
	 * Constructor of class Block
	 * 
	 * @param length  Length of the block
	 */
	public Block(int length) {
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
	
	private void setFree() {
		this.isFree = true;
	}
	
	/**
	 * method to set isFree to false
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
	
	Queue<Zug> getTrains() {
		return trains;
	}
}