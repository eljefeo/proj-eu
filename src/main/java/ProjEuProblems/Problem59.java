package ProjEuProblems;

public class Problem59 implements Problem { //Took 3.428538 seconds
	
	/*
	 Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.

For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes. The user would keep the encrypted message and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.

Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key. If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message. The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.

Your task has been made easy, as the encryption key consists of three lower case characters. Using p059_cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
	 */

	public static void main(String[] args) {
		Problem p = new Problem59();
		p.runProblem();
		
		//char e = 'e';
		//System.out.println("char " + (int)e);
		
		/*
		 * for(int i=97; i<123; i++) { System.out.println(i); }
		 */
	}

	public String problem() {
		
		//97 - 122 = lower case a - z in ascii
		int[] lowerCaseAsciiChars = new int[] {
				97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122
		};
		
		int[] cipherText = Problem59Helper.getCipherText();
		System.out.println("cipher text length :" + cipherText.length);
		// key is 3 lower case characters...
		// key is duplicated over and over to cover the 1455 characters in the text..
		
		int[] key = new int[3];

		for(int i = 0; i < lowerCaseAsciiChars.length; i++) {
			for(int j = 0; j < lowerCaseAsciiChars.length; j++) {
				for(int k = 0; k < lowerCaseAsciiChars.length; k++) {
					//123 then 234 then 345
					key[0] = lowerCaseAsciiChars[i];
					key[1] = lowerCaseAsciiChars[j];
					key[2] = lowerCaseAsciiChars[k];
					
					long res = decipherTextContainsEulerText(cipherText, key);
					if(res != 0) {
						System.out.println(" with key : " + key[0] + ", " + key[1] + ", " + key[2] + "  --- with sum: " + (key[0]+key[1] + key[2]));
						return "" + res;
					}
				}
			}	
		}
		
		return null;
		
	}
	
	
	private static long decipherTextContainsEulerText(int[] cipherText,int[] key) {
		String deciphered = "";
		
		boolean mightBeGood = false;
		long runningTotal = 0;
		
		for(int i = 0; i < cipherText.length; i+=key.length) {
			for(int j = 0; j < key.length; j++) {
				int oneChar = cipherText[i+j] ^ key[j];
				runningTotal += oneChar;
				deciphered += Character.toString((char) oneChar);
				if (oneChar == (int) 'r'  && !mightBeGood ) {
					mightBeGood = stringEndsWithEulerText(deciphered);
				}
			}
		}
		
		
		  if(mightBeGood) { 
			  System.out.println("Try this : " + runningTotal + " if this text makes sense: " + deciphered);
			  return runningTotal;
		  }
		 
		
		return 0;
	}
	
	private static boolean stringEndsWithEulerText(String text) {
		//Euler
		return text.charAt(text.length()-1) == (int)'r'
				&& text.charAt(text.length()-2) == (int)'e'
				&& text.charAt(text.length()-3) == (int)'l'
				&& text.charAt(text.length()-4) == (int)'u'
				&& (text.charAt(text.length()-5) == (int)'E');
			
		
	}

}
