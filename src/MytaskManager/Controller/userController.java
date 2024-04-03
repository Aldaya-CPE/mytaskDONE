
package MytaskManager.Controller;

import MytaskManager.Model.ModelUser;


public class userController {
SignIn_LogIn DAO;
    public userController() {
        this.DAO = new SignIn_LogIn();
    }
    public boolean registerUser(ModelUser data){
        String encrypPassWord = DAO.Encryption(new String(data.getPassWord()));
        data.setPassWord(encrypPassWord.toCharArray());
        return DAO.addUserToDatabase(data);
    }
    public ModelUser Login(ModelUser data){
      String encrypPassWord = DAO.Encryption(new String(data.getPassWord()));
      data.setPassWord(encrypPassWord.toCharArray());
      return this.DAO.login(data);
    }
  
    
}
