import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LZW {
	// private BufferedReader reader;
	private HashMap<Integer, String> dictionary;
	private String curr;
	private String next;

	public LZW(String inputFileName) throws FileNotFoundException {
		// reader = new BufferedReader(new FileReader(inputFileName));
		dictionary = new HashMap<Integer, String>();
	}

	public String encode(String input) {
		int start = 0;
		int end = 1;
		curr = input.substring(start, end);
		int counter = 0;
		while (counter != dictionary.size() - 1) {
			next = input.substring(start + 1, end + 1);
			if (dictionary.containsValue(curr + next)) {
				curr = curr + next;
			} else {
				dictionary.put(dictionary.size() - 1, curr + next);
				return next;
			}
			// dictionary.put(dictionary.size() - 1, first + next);
			// first = next;
			counter++;
		}
		return curr;
	}

	public static String toBinary(int x, int len) {
		if (len > 0) {
			return String.format("%" + len + "s", Integer.toBinaryString(x)).replaceAll(" ", "0");
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println(toBinary(1000, 16));
	}
}
