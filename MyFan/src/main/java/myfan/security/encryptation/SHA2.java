package myfan.security.encryptation;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA2 {
	private MessageDigest messageDigest;
	private byte [] byteData;
	private StringBuffer stringBuffer;
	
	public SHA2(){
		stringBuffer = new StringBuffer();
	}
	
	public void beginEncryption(String password){
		initMD(password);
	}
	
	private void initMD(String password){
		try {
			messageDigest = messageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			byteData = messageDigest.digest();
			processEncryption();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No se pudo inicializar el MD");
			}
		}
	private void processEncryption(){
		for (int i = 0; i < byteData.length; i++) { 
			stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			} 
		System.out.println("Encrypt: " + stringBuffer.toString()); 
		}
	
}
