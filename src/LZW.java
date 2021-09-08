import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LZW {
	private BufferedReader reader;
	private HashMap<Integer, String> dictionary;
	private String first;
	private String next;
	public LZW(String inputFileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(inputFileName));
		dictionary = new HashMap<Integer, String>();
	}
	public String encode () {
		first = dictionary.get(0); //input character
		int counter = 0;
		while (counter != dictionary.size() - 1) {
			next = dictionary.get(counter++); //input character
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
