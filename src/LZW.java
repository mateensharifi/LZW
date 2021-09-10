import java.util.ArrayList;
import java.util.HashMap;
import java.lang.*;

public class LZW {
	private HashMap<Integer, String> dictionary;
	private ArrayList<Integer> encoded;
	private String curr;
	private String next;

	public LZW() {
		dictionary = new HashMap<Integer, String>();
//		curr = ' ';
//		next = ' ';
		encoded = new ArrayList<Integer>();
	}

	public ArrayList<Integer> createDictionary(String input) {
		int size = 300;
		for (int i = 0; i < size; i++) {
			dictionary.put(i, (char) i + "");
		}
		curr = dictionary.get(0);
		for (int i = 0; i < dictionary.size(); i++) {
			next = dictionary.get(i + 1);
			if (dictionary.containsValue(curr + next)) {
				curr = curr + next;
			} else {
				return convertToBinary(next);
			}
			dictionary.put(dictionary.size(), curr + next);
			curr = next;
		}
		return toBinary(curr);
	}

	public static String toBinary(int x, int len) {
		if (len > 0) {
			return String.format("%" + len + "s", Integer.toBinaryString(x)).replaceAll(" ", "0");
		}

		return null;
	}
}
