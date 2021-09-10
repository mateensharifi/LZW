import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.lang.*;

public class LZW {
	private HashMap<Integer, String> dictionary;
	private ArrayList<Integer> encoded;
	private String curr;
	private String next;
	private int size;

	public LZW() {
		dictionary = new HashMap<Integer, String>();
//		curr = ' ';
//		next = ' ';
		encoded = new ArrayList<Integer>();
		size = 0;
	}

	public String encode(String input) {
		size = 256;
		for (int i = 0; i < size; i++) {
			dictionary.put(i, "" + (char)i);
		}
		curr = dictionary.get(0);
		for (int i = 0; i < dictionary.size(); i++) {
			next = dictionary.get(i + 1);
			if (dictionary.containsValue(curr + next)) {
				curr = curr + next;
			} else {
				int place = 0;
				for(Entry<Integer, String> entry: dictionary.entrySet()) {
					 if(((Entry<Integer, String>) dictionary).getValue() == next) {
						 place = ((Entry<Integer, String>) dictionary).getKey();
					 }
				}
				return Integer.toBinaryString(place);
			}
			dictionary.put(size++, curr + next);
			curr = next;
		}
		int place = 0;
		for(Entry<Integer, String> entry: dictionary.entrySet()) {
			 if(((Entry<Integer, String>) dictionary).getValue() == curr) {
				 place = ((Entry<Integer, String>) dictionary).getKey();
			 }
		}
		return Integer.toBinaryString(place);
	}


}
