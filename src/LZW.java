import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.util.*;

public class LZW {
	private static String file = null;
	private static double maxSize;
	private static String fileName;
	private static HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
	private static HashMap<Integer, String> decodeDictionary = new HashMap<Integer, String>();
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
		System.out.println("encoded: " + encoded);
		if (!curr.equals("")) {
			encoded.add(dictionary.get(curr));
		}
		return Integer.toBinaryString(dictionary.get(curr));
	}
	
	public static String decode(int length) throws IOException {
		maxSize = Math.pow(2, length);
		createDecodeDictionary();
		int size = 256;
		String ans = "";
		String current = "", next = "", lastEntry = "";
		
		for(int i = 0; i < encoded.size() - 1; i++) {
			current = decodeDictionary.get(encoded.get(i));
			next = decodeDictionary.get(encoded.get(i + 1));
			if(!decodeDictionary.containsKey(encoded.get(i + 1))) { //special case
				if(size < maxSize) {
					decodeDictionary.put(size++, lastEntry + lastEntry.charAt(0));
				}
			}
			if (size < maxSize) {
				decodeDictionary.put(size++, current + next.charAt(0));
			}
			lastEntry = current + next.charAt(0);
			
		}
		
		for(int n: encoded) {
			ans += decodeDictionary.get(n);
		}
		PrintWriter out = new PrintWriter(new File("answer.txt"));
		out.print(ans);
		out.close();
		return ans;
	}
		
	public static void createDecodeDictionary() {
		for (int i = 0; i < 256; i++) {
			decodeDictionary.put(i, "" + (char) i);
		}
		//System.out.println(decodeDictionary.toString());
	}
}
