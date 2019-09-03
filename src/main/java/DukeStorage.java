import java.io.*;
import java.util.ArrayList;

public class DukeStorage {

    protected static File dir;

    public DukeStorage(String filepath){
        dir = new File(filepath);
        dir.mkdirs();
    }

    public static ArrayList<Task> readFile() throws DukeException{
        try{
            FileInputStream fis = new FileInputStream(dir);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Task> list = (ArrayList<Task>) ois.readObject();
            ois.close();
            return list;
        }  catch (IOException e) {
            throw new DukeException("Error: IO exception when reading file", e);
        } catch (ClassNotFoundException e) {
            throw new DukeException("The supporting Duke class file could not be found", e);
        }

    }

    public static void writeFile(ArrayList<Task> list) throws DukeException{
        try {
            FileOutputStream fout = new FileOutputStream(dir);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new DukeException("Unable to create file to save the list", e);
        } catch (IOException e){
            throw new DukeException("Error: IO exception when writing file", e);
        }
    }
}
