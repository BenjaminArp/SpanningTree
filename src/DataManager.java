import java.io.*;
import java.util.ArrayList;
public class DataManager {
    public ArrayList<Node> nodeList = new ArrayList<>();

    //Singelton pattern

    //instance which gets initialized once
    private static final DataManager instance = new DataManager();

    //constructor which loads file
    private DataManager()
    {
        loadFile();
    }
    //Singelton Pattern
    public static DataManager getInstance()
    {
        return instance;
    }

    public void loadFile()
    {

        //Filepath is absolute and not dynamic
        final String Path = new File("").getAbsolutePath() + "\\import.txt";
        File file = new File(Path);

        try
        {
            var fr = new FileReader(file);
            var reader = new BufferedReader(fr);
            String line;
            int counter = 0;

            //reads all lines until end of file
            while((line=reader.readLine()) != null)
            {

                //if line is start of new Element skip line and change function call
                if(line.startsWith("New_Entity"))
                {
                    counter++;
                    continue;
                }

                String[] variables = line.split("[,]");

                //calls the needed function
                switch (counter) {
                    case 1 -> nodeList.add(new Node(variables));
                    case 2 -> addConnection(variables);
                }
            }
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println("The file does not exist");
        }
        catch (IOException ex)
        {
            System.err.println("The file is not readable");
        }
        catch (Exception exx){
            System.err.println(exx.getMessage());
        }
    }
    private void addConnection(String[] var){
        Node nodeA = null;
        Node nodeB = null;
        for (Node o: nodeList) {
            if(o.name.equals(var[0])){
                nodeA = o;
            }
            else if(o.name.equals(var[1])){
                nodeB = o;
            }
        }
        try {
            new Connection(nodeA,nodeB, Integer.parseInt(var[2]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
