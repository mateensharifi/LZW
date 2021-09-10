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

	public static void encode(String input, int length) throws IOException {
		maxSize = Math.pow(2, length);
		int size = 255;
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		for (int i = 0; i < size; i++) {
			dictionary.put("" + (char) i, i);
		}
		String curr = "";
		ArrayList<Integer> encoded = new ArrayList<Integer>();
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
		if (!curr.equals("")) {
			encoded.add(dictionary.get(curr));
		}
		buildFile(encoded);
	}
	private static void buildFile(ArrayList<Integer> encoded) throws IOException {
		BufferedWriter output = null;
		fileName = file.substring(0, file.indexOf(".")) + ".lzw";
		try {
			output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF_16BE"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Iterator<Integer> itr = encoded.iterator();
			while (itr.hasNext()) {
				output.write(itr.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		output.flush();
		output.close();

	}

	public static void main(String[] args) throws IOException {

		file = args[0];
		int Bit_Length = Integer.parseInt(args[1]);

		StringBuffer input_string1 = new StringBuffer();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8)) {
			for (String line = null; (line = br.readLine()) != null;) {

				input_string1 = input_string1.append(line);
			}
		}

		encode(input_string1.toString(), Bit_Length);

	}
}
