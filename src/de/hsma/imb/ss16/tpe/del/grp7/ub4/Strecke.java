package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a railroad track.
 * Every track has a certain length, which is set,
 * when the track is created. Any number of trains
 * can drive on a track, but they all drive in the
 * same direction. To coordinate the trains a track
 * consists of blocks. Blocks can have a different
 * length, but in total they can not exceed the tracks
 * length. A train can only enter a block, when this
 * block is free.
 * 
 * @author Gruppe 7
 *
 */
public class Strecke {
	/**
	 * Defines the sign which is used to display that the signal is red.
	 */
	private static final Character SIGN_BLOCKED = '|';
	/**
	 * Defines the sign which is used to display that the signal is green.
	 */
	private static final Character SIGN_UNBLOCKED = '_';
	/**
	 * Defines the sign which is used to display a kilometer of the track.
	 */
	private static final Character SIGN_TRACKPOINT = '-';
	/**
	 * Defines the start value of some vars in the class.
	 */
	private static final int START_VALUE = 1;
	/**
	 * Defines the shift which is use to edit the edpositions of blocks.
	 */
	private static final int ARRAY_SHIFT = 1;
	/**
	 * Defines the minimum position on the track.
	 */
	private static final int MINIMUM_POSITION = 0;
	private static final String EX_NULL_BLOCKLIST = "null blocklist not allowed";

	/**
	 * Length of the full track.
	 */
	private int length;
	/**
	 * List of the trains on the track.
	 */
	private List<Zug> trainlist;
	/**
	 * List of the block of the track.
	 */
	private List<Block> blocklist;
	/**
	 * Positions of the trains.
	 */
	private Map<Integer, Zug> trainPosition;
	/**
	 * Contains information about the positions of block barriers.
	 */
	private Map<Integer, Block> blockBarrier;
	
	/**
	 * Constructor for class Strecke
	 * pointer: indicates the start position of a new block
	 * trainlist: keeps information about all trains on the track
	 * blocklist: keeps information about all blocks on the track
	 * trainPosition: keeps information about the train positions on the track
	 * blockBarrier: keeps information about the positions of block barriers
	 * 
	 * @param length  Length of the track
	 * @throws SimulationException 
	 */
	public Strecke(ArrayList<Block> blocklist) throws SimulationException {
		if(blocklist == null){
			throw new SimulationException(EX_NULL_BLOCKLIST);
		}
		length = START_VALUE;
		trainlist = new ArrayList<>();
		trainPosition = new HashMap<>();
		blockBarrier = new HashMap<>();
		blocklist.stream().forEach((block) -> {
			block.setStartPos(getLength());
			addToLength(block.getLength());
			block.setEndPos(getLength() - ARRAY_SHIFT);
			getBlockBarrier().put(block.getStartPos(), block);
		});
		this.blocklist = blocklist;
	}
	
	/**
	 * With this method trains can be added to the track.
	 * Adding trains is only possible when their starting
	 * positions are on the track.
	 * The train is added to trainlist and the trains starting
	 * position and the train itself are put to trainPosition.
	 * 
	 * @param zug  zug, which should be added
	 * @return  true, if adding was successful
	 * @throws SimulationException 
	 */
	public boolean addZug(Zug zug) throws SimulationException {
		if(zug == null){
			throw new SimulationException();
		}
		if(zug.getCurrentPos() > MINIMUM_POSITION 
				&& (zug.getCurrentPos() <= this.getLength())) {
			getTrainPosition().put(zug.getCurrentPos(), zug);
			getTrainList().add(zug);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the length of the track
	 * @return  track length
	 */
	int getLength() {
		return length;
	}
	
	/**
	 * Adds the given value to the length.
	 * @param toAdd	value to add
	 */
	void addToLength(int toAdd) {
		length += toAdd;
	}
	
	/**
	 * Returns the list of the blocks.
	 * @return	list of blocks
	 */
	List<Block> getBlockList() {
		return blocklist;
	}
	
	/**
	 * Returns the list of the positions of the trains.
	 * @return	positions of trains
	 */
	Map<Integer, Zug> getTrainPosition() {
		return trainPosition;
	}
	
	/**
	 * Returns the list of the trains on the track.
	 * @return	list of trains
	 */
	List<Zug> getTrainList() {
		return trainlist;
	}
	
	/**
	 * Returns the list of the barriers.
	 * @return	list of barriers
	 */
	Map<Integer, Block> getBlockBarrier() {
		return blockBarrier;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = START_VALUE; i <= this.getLength(); i++) {
			if(getBlockBarrier().containsKey(i)) {
				if(getBlockBarrier().get(i).isFree()) {
					result += SIGN_UNBLOCKED;
				}
				else{
					result += SIGN_BLOCKED;
				}
			}
			if(getTrainPosition().containsKey(i)) {
				result += getTrainPosition().get(i).getName();
			}
			else{
				result += SIGN_TRACKPOINT;
			}
		}
		return result;
	}
}