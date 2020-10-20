package test;

public class Handler {
    Handler()
    {

    }
    public static void funcion (Object object) throws CustomException {

        boolean condition = false, condition2 = false;
        //Logic for progrman
        if(condition){
            throw new CustomException("No funciona por ...");
        }else if(condition2){
            throw new CustomException("No funciona por ...");

        }else {
           throw  new CustomException("No funciona por ...");
        }
    }
}
