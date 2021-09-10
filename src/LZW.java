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
		size = 5;
		for (int i = 0; i < size; i++) {
			dictionary.put(i, input.substring(i, i + 1));
		}
		curr = dictionary.get(0);
		for (int i = 0; i < dictionary.size(); i++) {
			next = dictionary.get(i + 1);
			if (dictionary.containsValue(curr + next)) {
				curr = curr + next;
			} else {
				Object key = null;
				Object value = null;
				for (Entry<Integer, String> e : dictionary.entrySet()) {
					key = e.getKey();
					value = e.getValue();
				}
//				return toBinary((int) key);
				return Integer.toBinaryString((int) key);
			}
			dictionary.put(size++, curr + next);
			curr = next;
		}
		Object key = null;
		Object value = null;
		for (Entry<Integer, String> e : dictionary.entrySet()) {
			key = e.getKey();
			value = e.getValue();
		}
		//return toBinary((int) key);
		return Integer.toBinaryString((int) key);
	}


}
