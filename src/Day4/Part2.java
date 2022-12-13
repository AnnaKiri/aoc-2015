package Day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part2 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String secretKey = "iwrupvqb";
		
		for (long i = 1; i < 1_000_000_000_000l; i++) {
			String tempSecretKey = secretKey + String.valueOf(i);
			
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(tempSecretKey.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			while(hashtext.length() < 32 ){
			  hashtext = "0" + hashtext;
			}

			if (hashtext.substring(0, 6).equals("000000")) {
				System.out.println(tempSecretKey);
				return;
			}

		}
	}
}