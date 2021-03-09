package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Application{
    HashMap<String, String> hashMap = new HashMap<>();
    {
        hashMap.put("-mode","enc");
        hashMap.put("-key","0");
        hashMap.put("-data","");
    }

    protected void execute(String[] userArgs) throws IOException {
        for (int i = 0; i <= userArgs.length-1 ; i+=2) {
            hashMap.put(userArgs[i], userArgs[i+1]);
        }
        encryptDecrypt();
    }

    private void encryptDecrypt() throws IOException {
        int number = Integer.parseInt(hashMap.get("-key"));
        char[] message;
        if(whatToWrite()){
            message = message(hashMap.get("-data"));
        }
        else message = message(readFileAsString(hashMap.get("-in")));
        int length = message.length;

        if(checkWhatToDo()){
            changeState(message, length, number);
        }
        else changeState(message, length, -number);

    }

    private boolean checkWhatToDo(){
        return hashMap.get("-mode").equals("enc");
    }

    private void changeState(char[] message, int length, int number) throws IOException {
        for(int i = 0; i < length; i++){
            message[i] = (char) (message[i] + number);
        }
        writeMethod(message);
    }

    private char[] message(String message){
        return message.toCharArray();
    }

    private void writeMethod(char[] message) throws IOException {
        if(whereToWrite()){
            File file = new File(hashMap.get("-out"));
            FileWriter writer = new FileWriter(file, false);
            writer.write(message);
            writer.close();

        }else System.out.println(message);
    }

    private boolean whatToWrite(){
        return !hashMap.get("-data").equals("");
    }

    private boolean whereToWrite(){
        return hashMap.containsKey("-out");
    }

    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
