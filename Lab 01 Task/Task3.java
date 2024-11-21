public class Negative_array
{
    public static void main(String[] args) {
        try {
            int arr[] = new int[-10];
        }
        catch (NegativeArraySizeException neg){
            System.out.println("Negativ array size");
        }
    }
}
