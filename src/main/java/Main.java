public class Main {

    public static void main(String args[])
    {
        try {
            Producer producer = new Producer();
            for (int i = 0; i < 5; i++) {
                producer.sendMessage("string_" + i);
            }
        }catch(Exception e){
            e.printStackTrace();
            }
    }
}
