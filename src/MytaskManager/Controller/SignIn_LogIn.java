
package MytaskManager.Controller;

import MytaskManager.Database.Database;
import MytaskManager.Model.ModelUser;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class SignIn_LogIn {

    public SignIn_LogIn() {
         try {
            Database.getInstance().ConnectToDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addUserToDatabase(ModelUser data){
        try {
            String sql = "INSERT INTO userdata(userId,userName,passWord,timestamp)values (?,?,?,?)";
            PreparedStatement p = Database.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, data.getUserId());
            p.setString(2, data.getUserName());
            p.setString(3, new String(data.getPassWord()));
            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            p.setTimestamp(4, timestamp);
            
            p.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ModelUser login(ModelUser data){
        try {
            String sql = "SELECT * FROM userdata WHERE userName LIKE ? AND passWord LIKE ?";
            PreparedStatement p = Database.getInstance().getConnection().prepareCall(sql);
            p.setString(1, data.getUserName());
            p.setString(2, new String(data.getPassWord()));
            ResultSet rs = p.executeQuery();
             if (rs.next()) {
                return new ModelUser(rs.getString("userId"), rs.getString("userName"), rs.getString("passWord").toCharArray());
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public String Encryption(String password){
        try {
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");
            byte [] encodeHash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodeHash.length);
            for (int i = 0; i < encodeHash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodeHash[i]);
                if (hexVal.length()==1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
            return encryptionValue.toString();
        } catch (Exception e) {
           return e.getMessage();
        }
    }
 
}

