package test;

public class StringToInt extends Exception {


    public static final long serialVersionUID = 700l;

    public StringToInt(String message){
        super(message);
    }

    public static int checkerPort (String string) throws StringToInt {
        try {
            int result = Integer.parseInt(string);
            if(result>0){
                return result;
            }else {
                throw new StringToInt("El usuario digito un puerto negativo");
            }
        }catch (NumberFormatException ex){
            throw new StringToInt("El usuario no digito un numero");
        }
    }
}


