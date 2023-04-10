import java.io.*;
import java.util.ArrayList;

public class Stores {
    private ArrayList<String> stores = new ArrayList<String>();
    public Stores(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/stores.txt")));
            String l;
            while((l = br.readLine()) != null) {
                stores.add(l);
                l = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getStores() {
        return stores;
    }
    public void writeStores(ArrayList<String> storesNew) {
        try{
            FileWriter fw = new FileWriter(new File("src/stores.txt"));
            PrintWriter pw = new PrintWriter(fw);
            int size = (storesNew != null) ? storesNew.size() : 0;

            for(String store : storesNew) {
                pw.println(store);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}