package backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountTotal implements IFile{
    
    private FileIO fileIO;
    private double gelir;
    private double gider;
    

    public AccountTotal() {
        fileIO=new FileIO("Muhasebe.txt");
    }

    @Override
    public void create(List<String> s) {
        try {
            fileIO.fileWrite(s, "Muhasebe.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> read() {
        List<String> s=new ArrayList<>();
        try {
            s=fileIO.fileRead("Muhasebe.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    @Override
    public void delete(int id) {
        try {
            fileIO.fileDelete("Muhasebe.txt", id);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
