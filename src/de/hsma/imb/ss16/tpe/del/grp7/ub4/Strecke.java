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
	private static final Character SIGN_BLOCKED = '|';
	private static final Character SIGN_UNBLOCKED = '_';
	private static final Character SIGN_TRACKPOINT = '-';
	private static final int ARRAY_SHIFT = 1;
	private static final int MINIMUM_POSITION = 0;

	private int length;
	private int pointer;
	private List<Zug> trainlist;
	private List<Block> blocklist;
	private Map<Integer, Zug> trainPosition;
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
	 */
	public Strecke(ArrayList<Block> blockList2) {
		length = ARRAY_SHIFT;
		trainlist = new ArrayList<>();
		trainPosition = new HashMap<>();
		blockBarrier = new HashMap<>();
		pointer = ARRAY_SHIFT;
		blockList2.stream().forEach((block) -> {
			block.setStartPos(length);
			this.length += block.getLength();
			block.setEndPos(length-ARRAY_SHIFT);
			blockBarrier.put(block.getStartPos(), block);
		});
		blocklist = blockList2;
	}
	
	/**
	 * With this method blocks can be added to the track.
	 * Adding blocks is only possible when the track length
	 * is not exceeded. Depending on the position on the track
	 * a blocks start and endposition are set and the pointer
	 * is increased depending on a blocks length.
	 * The block is added to blocklist and the blocks
	 * start position and the block itself as value are put
	 * to blockBarrier.
	 * 
	 * @param block  block, which should be added
	 * @return  true, if adding was successful
	 */
//	public boolean addBlock(Block block) {
//		if((getPointer() + block.getLength()) 
//				<= (this.getLength() + ARRAY_SHIFT)) {
//			block.setStartPos(getPointer());
//			addToPointer(block.getLength());
//			block.setEndPos(getPointer() - ARRAY_SHIFT);
//			getBlockBarrier().put(block.getStartPos(), block);
//			getBlockList().add(block);
//			return true;
//		}
//		System.out.println("Streckenlänge überschritten");
//		return false;		
//	}
	
	/**
	 * With this method trains can be added to the track.
	 * Adding trains is only possible when their starting
	 * positions are on the track.
	 * The train is added to trainlist and the trains starting
	 * position and the train itself are put to trainPosition.
	 * 
	 * @param zug  zug, which should be added
	 * @return  true, if adding was successful
	 */
	public boolean addZug(Zug zug) {
		if(zug.getCurrentPos() > MINIMUM_POSITION 
				&& (zug.getCurrentPos() <= this.getLength())) {
			getTrainPosition().put(zug.getCurrentPos(), zug);
			getTrainList().add(zug);
			return true;
		}
		return false;
	}
	
	/**
	 * Getter-method for length
	 * 
	 * @return  the tracks length
	 */
	int getLength() {
		return this.length;
	}
	
	List<Block> getBlockList() {
		return this.blocklist;
	}
	
	Map<Integer, Zug> getTrainPosition() {
		return trainPosition;
	}
	
	List<Zug> getTrainList() {
		return trainlist;
	}
	
	Map<Integer, Block> getBlockBarrier() {
		return blockBarrier;
	}
	
	void addToPointer(int toAdd) {
		pointer += toAdd;
	}
	
	int getPointer() {
		return pointer;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = 1; i <= this.getLength(); i++) {
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