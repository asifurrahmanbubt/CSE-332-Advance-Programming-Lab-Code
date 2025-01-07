import java.util.*;
public class String_Index_Out_of_Bound {
    public static void main(String[] args){
        String s ="Asifur Rahman";
        try {
            System.out.println(s.charAt(22));
        }
        catch (StringIndexOutOfBoundsException stob){
            System.out.println("Index out of bound");
        }
    }
}
