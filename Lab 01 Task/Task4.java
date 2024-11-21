import java.util.Scanner;

public class IllegalArgumentexception {
    public static void main(String[] args){
        try{
            int a =Integer.valueOf("ten");
        }
        catch (IllegalArgumentException ilar){
            System.out.println("Illegal Argument");
        }
    }
}
