package Utility;

import java.util.List;

public interface IFile {
    void create(List<String> s);
    List<String> read();
    void delete(int id);
}
