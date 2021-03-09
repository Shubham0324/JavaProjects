package encryptdecrypt;

import java.util.HashMap;

public class Application{
    HashMap<String, String> hashMap = new HashMap<>();
    {
        hashMap.put("-mode","enc");
        hashMap.put("-key","0");
        hashMap.put("-data"," ");
    }

    public void execute(String[] userArgs){
        for (int i = 0; i <= userArgs.length-1 ; i+=2) {
            hashMap.put(userArgs[i], userArgs[i+1]);
        }
        checkWhatToDo();
    }

    private void checkWhatToDo(){
        if(hashMap.get("-mode").equals("enc"))encrypt();
        else decrypt();
    }

    private void encrypt() {
        int number = Integer.parseInt(hashMap.get("-key"));
        char[] message = hashMap.get("-data").toCharArray();
        for(int i = 0; i < hashMap.get("-data").length(); i++){
            message[i] = (char) (message[i] + number);
        }
        System.out.println(message);
    }

    private void decrypt() {
        int number = Integer.parseInt(hashMap.get("-key"));
        char[] message = hashMap.get("-data").toCharArray();
        for(int i = 0; i < hashMap.get("-data").length(); i++){
            message[i] = (char) (message[i] - number);
        }
        System.out.println(message);
    }

}
