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

	private int length;
	private int pointer;
	List<Zug> trainlist;
	List<Block> blocklist;
	Map<Integer, Zug> trainPosition;
	Map<Integer, Block> blockBarrier;
	
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
	public Strecke(int length) {
		this.length = length;
		pointer = 1;
		trainlist = new ArrayList<>();
		blocklist = new ArrayList<>();
		trainPosition = new HashMap<>();
		blockBarrier = new HashMap<>();
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
	public boolean addBlock(Block block) {
		if((pointer + block.getLength()) <= this.getLength() + 1) {
			block.setStartPos(pointer);
			pointer += block.getLength();
			block.setEndPos(pointer - 1);
			blockBarrier.put(block.getStartPos(), block);
			blocklist.add(block);
			return true;
		}
		System.out.println("Streckenlänge überschritten");
		return false;		
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
	 */
	public boolean addZug(Zug zug) {
		if(zug.getCurrentPos() > 0 && zug.getCurrentPos() <= this.getLength()) {
			trainPosition.put(zug.getCurrentPos(), zug);
			trainlist.add(zug);
			return true;
		}
		return false;
	}
	
	/**
	 * Getter-method for length
	 * 
	 * @return  the tracks length
	 */
	public int getLength() {
		return this.length;
	}
	
	@Override
	public String toString() {
		String anzeige = "";
		
		for(int i = 1; i <= this.getLength(); i++) {
			if(blockBarrier.containsKey(i)) {
				if(blockBarrier.get(i).isFree()) {
					anzeige += '_';
				}
				else{
					anzeige += '|';
				}
			}
			if(trainPosition.containsKey(i)) {
				anzeige += trainPosition.get(i).getName();
			}
			else{
				anzeige += '-';
			}
		}
		
		return anzeige;
	}
}