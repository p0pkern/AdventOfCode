package adventofcode2015;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		String message = "iwrupvqb";
		int end = 1;

		while (true) {
			md.update(StandardCharsets.UTF_8.encode(message + end));

			String updated = String.format("%032x", new BigInteger(1, md.digest()));

			int count = 0;

			for (int i = 0; i < 6; i++) {
				if (updated.charAt(i) != '0')
					break;
				else
					count++;
			}
			
			System.out.println(count);
			System.out.println(updated);
			System.out.println(end);
			if (count == 6)
				break;

			end++;
			md.reset();
		}

	}

}
