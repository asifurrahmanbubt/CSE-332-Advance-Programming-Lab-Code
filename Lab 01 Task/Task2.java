public class No_Such_Method {
    public static void main(String args[]){
        int a=5;
        try{

            System.out.println(sum(a,10));
        }
        catch(NoSuchMethodException nome){
            System.out.println("No Such Method exists");
        }

    }
}
