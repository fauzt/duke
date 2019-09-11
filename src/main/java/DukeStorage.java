import java.io.*;
import java.util.ArrayList;

/**
* This class handles the data storage and handling function of Duke.
*/

public class DukeStorage {
    protected static File dir;

    /**
     * This constructor initialises the file to be read/written and create the directory if it doesn't exist yet.
     * @param filepath This string is the designated file directory path for the data to be stored in.
     */

    public DukeStorage(String filepath){
        dir = new File(filepath);
        dir.getParentFile().mkdirs();
    }

        /**
         * This method retrieves and read the data from the initialised file path.
         * @return The method returns the list data if found
         * @throws DukeException
         */

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

        /**
         * This method writes the data after user modifications into the file.
         * @param list This is the data that needs to be written to the file
         * @throws DukeException
         */

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
