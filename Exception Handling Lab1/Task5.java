public class Array_Index_Out_of_Bound {
    public static void main(String[] args){
        int arr[] =new int[10];
        try{
            System.out.println(arr[14]);
        }
        catch (ArrayIndexOutOfBoundsException arbs){
            System.out.println("Array index out ");
        }
    }
}
