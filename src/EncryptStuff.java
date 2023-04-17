import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncryptStuff {
	
	
	private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        final String secretKey = "SomeSecretPasswordHere";

        String originalString = "SomeTextHereToHide";

        EncryptStuff encryptStuff = new EncryptStuff();
        String encryptedString = encryptStuff.encrypt(originalString, secretKey);
        String decryptedString = encryptStuff.decrypt(encryptedString, secretKey);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
	
	
	////////////
	
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	
	public static SecretKey getKeyFromPassword(String password, String salt)
		    throws NoSuchAlgorithmException, InvalidKeySpecException {
		    
		    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		    SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
		        .getEncoded(), "AES");
		    return secret;
		}
	
	public static IvParameterSpec generateIv() {
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	
	public static String encrypt(String algorithm, String input, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    byte[] cipherText = cipher.doFinal(input.getBytes());
		    return Base64.getEncoder()
		        .encodeToString(cipherText);
		}
	
	public static String decrypt(String algorithm, String cipherText, SecretKey key,
		    IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
		    InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    byte[] plainText = cipher.doFinal(Base64.getDecoder()
		        .decode(cipherText));
		    return new String(plainText);
		}
	
	/*@Test
	void givenPassword_whenEncrypt_thenSuccess() 
	    throws InvalidKeySpecException, NoSuchAlgorithmException, 
	    IllegalBlockSizeException, InvalidKeyException, BadPaddingException, 
	    InvalidAlgorithmParameterException, NoSuchPaddingException {
	    
	    String plainText = "www.baeldung.com";
	    String password = "baeldung";
	    String salt = "12345678";
	    IvParameterSpec ivParameterSpec = EncryptStuff.generateIv();
	    SecretKey key = EncryptStuff.getKeyFromPassword(password,salt);
	    String cipherText = EncryptStuff.encryptPasswordBased(plainText, key, ivParameterSpec);
	    String decryptedCipherText = EncryptStuff.decryptPasswordBased(
	      cipherText, key, ivParameterSpec);
	    Assertions.assertEquals(plainText, decryptedCipherText);
	}*/
	
	@Test
	void givenString_whenEncrypt_thenSuccess()
	    throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
	    BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException { 
	    
	    String input = "baeldung";
	    SecretKey key = EncryptStuff.generateKey(128);
	    IvParameterSpec ivParameterSpec = EncryptStuff.generateIv();
	    String algorithm = "AES/CBC/PKCS5Padding";
	    String cipherText = EncryptStuff.encrypt(algorithm, input, key, ivParameterSpec);
	    String plainText = EncryptStuff.decrypt(algorithm, cipherText, key, ivParameterSpec);
	    Assertions.assertEquals(input, plainText);
	}

	public static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv,
		    File inputFile, File outputFile) throws IOException, NoSuchPaddingException,
		    NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException,
		    BadPaddingException, IllegalBlockSizeException {
		    
		    Cipher cipher = Cipher.getInstance(algorithm);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    FileInputStream inputStream = new FileInputStream(inputFile);
		    FileOutputStream outputStream = new FileOutputStream(outputFile);
		    byte[] buffer = new byte[64];
		    int bytesRead;
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
		        byte[] output = cipher.update(buffer, 0, bytesRead);
		        if (output != null) {
		            outputStream.write(output);
		        }
		    }
		    byte[] outputBytes = cipher.doFinal();
		    if (outputBytes != null) {
		        outputStream.write(outputBytes);
		    }
		    inputStream.close();
		    outputStream.close();
	}
	
	/*@Test
	void givenFile_whenEncrypt_thenSuccess() 
	    throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, 
	    InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, 
	    NoSuchPaddingException {
	    
	    SecretKey key = EncryptStuff.generateKey(128);
	    String algorithm = "AES/CBC/PKCS5Padding";
	    IvParameterSpec ivParameterSpec = EncryptStuff.generateIv();
	    Resource resource = new ClassPathResource("inputFile/baeldung.txt");
	    File inputFile = resource.getFile();
	    File encryptedFile = new File("classpath:baeldung.encrypted");
	    File decryptedFile = new File("document.decrypted");
	    EncryptStuff.encryptFile(algorithm, key, ivParameterSpec, inputFile, encryptedFile);
	    EncryptStuff.decryptFile(
	      algorithm, key, ivParameterSpec, encryptedFile, decryptedFile);
	    assertThat(inputFile).hasSameTextualContentAs(decryptedFile);
	} */
}
