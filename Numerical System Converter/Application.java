package converter;


public class Application extends Main {

    //Variables for the class Application
    private String userInput;
    private int sourceBase;
    private int targetBase;


    // SETTERS FOR THE CLASS APPLICATION
    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    public void setSourceBase(int sourceBase) {
        this.sourceBase = sourceBase;
    }
    public void setTargetBase(int targetBase) {
        this.targetBase = targetBase;
    }



    // GETTERS FOR THE CLASS APPLICATION
    public String getUserInput() {
        return userInput;
    }
    public int getSourceBase() {
        return sourceBase;
    }
    public int getTargetBase() {
        return targetBase;
    }


    // Driving Function That Runs Program
    protected void execute() {

        setSourceBase(sc.nextInt());
        setUserInput(sc.next());
        setTargetBase(sc.nextInt());

        if (getSourceBase() == 1 || getTargetBase() == 1 ) specialRadixOneConversion();

        numericalConverter();

    }

    private void numericalConverter() {

        if (!getUserInput().contains(".")){
            System.out.println(convertInteger(getUserInput()));
        }else{

            String whateverToDecimal = getUserInput().substring(getUserInput().lastIndexOf(".") + 1);
            String integerPart = getUserInput().substring(0,getUserInput().lastIndexOf("."));

            System.out.println(convertInteger(integerPart) + "."+ floatConversion(whateverToDecimal));
        }
        System.exit(0);
    }

    private StringBuilder floatConversion(String whateverToDecimal){

        StringBuilder stringBuilder = new StringBuilder();
        double fractionInDecimal = 0;

        for (int i = 0; i < whateverToDecimal.length(); i++) {
            double tempDigit = Integer.parseInt(whateverToDecimal.substring(i, i+1), getSourceBase());
            fractionInDecimal += tempDigit / Math.pow(getSourceBase(), i+1);
        }

        for (int i = 0; i < 5; i++) {
            fractionInDecimal = fractionInDecimal * getTargetBase();
            int tempInteger = (int) Math.floor(fractionInDecimal);
            fractionInDecimal -= tempInteger;
            stringBuilder.append(Integer.toString(tempInteger, getTargetBase()));
        }
        return stringBuilder;
    }

    private void specialRadixOneConversion() {
        if(getSourceBase() == 1){
            int decimalRepresentation = String.valueOf(Integer.parseInt(getUserInput())).length();
            System.out.println(Integer.toString(decimalRepresentation, getTargetBase()));
        }
        else{
            for (int i = 0; i < Integer.parseInt(getUserInput()); i++) {
                System.out.print("1");
            }
        }
        System.exit(0);
    }

    private String convertInteger(String userInputIntegerPart){
        String decimalString = String.valueOf(Integer.parseInt(userInputIntegerPart, getSourceBase()));
        return Integer.toString(Integer.parseInt(decimalString), getTargetBase());
    }

}