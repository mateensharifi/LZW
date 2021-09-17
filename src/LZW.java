import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LZW {
	private static String file = null;
	private static double maxSize;
	private static String fileName;
	private static HashMap<String, Integer> dictionary;

	public LZW() {
		dictionary = new HashMap<String, Integer>();
		for (int i = 0; i < 255; i++) {
			dictionary.put("" + (char) i, i);
		}
	}

	public ArrayList encode(String input) throws IOException {
		maxSize = 10;
		int start = 0;
		int end = 1;
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String curr = reader.readLine();
		ArrayList<String> encoded = new ArrayList<String>();
		for (int i = 0; i < input.length() - 1; i++) {
			String next = reader.readLine();
			String comb = curr + next;
			if (dictionary.containsKey(comb)) {
				curr = comb;
			} else {
				encoded.add(curr);
			}
			encoded.add(comb);
		}
		return encoded;
		// return Integer.toBinaryString(dictionary.get(curr));
	}
}
