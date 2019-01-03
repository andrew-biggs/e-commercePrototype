import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    public static String AlgMD5(String pass){
        String encry_pass = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes()); //get password and converts to bytes using MD5
            byte[] bytes = md.digest(); //converts to an array of bytes

            StringBuilder sb = new StringBuilder(); //used to keep adding things to string
            for(int i = 0; i < bytes.length; i++){ //as long as i is smaller than the length of the bytes array
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                System.out.println(sb.toString());
            }

            encry_pass = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encry_pass;
    }

}
