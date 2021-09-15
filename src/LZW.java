import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	private static HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
	private static ArrayList<Integer> encoded = new ArrayList<Integer>();

	public static String encode(String input, int length) throws IOException {
		maxSize = Math.pow(2, length);
		int size = 255;
		for (int i = 0; i < size; i++) {
			dictionary.put("" + (char) i, i);
		}
		//System.out.println(dictionary.toString());
		String curr = "";
		for (char next : input.toCharArray()) {
			String comb = curr + next;
			if (dictionary.containsKey(comb)) {
				curr = comb;
			} else {
				encoded.add(dictionary.get(curr));
				if (size < maxSize) {
					dictionary.put(comb, size++);
				}
				curr = "" + next;
			}
		}
		System.out.println("econded: " + encoded);
		if (!curr.equals("")) {
			encoded.add(dictionary.get(curr));
		}
		return Integer.toBinaryString(dictionary.get(curr));
	}
	
	public static String decode() {
		HashMap<Integer, String> dictionary2 = new HashMap<Integer, String>();
		updateDictionary2();
		String ans = "";
		char current = 0, next = 0;
		for(int i = 0; i < encoded.size() - 1; i++) {
			//current = dictionary.get(encoded.get(i));
			
		}
		return "";
	}
	
	public static void updateDictionary2() {
		//for()
	}
}
