/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utility.FileIO;
import Utility.IFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import entity.Storage;

/**
 *
 * @author ACE
 */
public class StorageController implements IFile{
    private FileIO fileIO;
    private Storage storage;

    public StorageController() {
        this.fileIO = new FileIO("Stok.txt");
    }
    
    @Override
    public void create(List<String> s) {
        try {
            fileIO.fileWrite(s, "Stok.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> read() {
        List<String> s=new ArrayList<>();
        try {
            s=fileIO.fileRead("Stok.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    @Override
    public void delete(int id) {
        try {
            fileIO.fileDelete("Stok.txt", id);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
