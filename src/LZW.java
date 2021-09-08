import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LZW {
	//private BufferedReader reader;
	private HashMap<Integer, String> dictionary;
	private String first;
	private String next;
	public LZW(String inputFileName) throws FileNotFoundException {
		//reader = new BufferedReader(new FileReader(inputFileName));
		dictionary = new HashMap<Integer, String>();
	}
	public String encode (String input) {
		int start = 0;
		int end = 1;
		first = input.substring(start, end);
		int counter = 0;
		while (counter != dictionary.size() - 1) {
			next = input.substring(start + 1, end + 1);
			if (dictionary.containsValue(first + next)) {
				first = first + next;
			}
			else {
				return next;
			}
			dictionary.put(dictionary.size() - 1, first + next);
			first = next;
			counter++;
		}
		return first;
	}
}
