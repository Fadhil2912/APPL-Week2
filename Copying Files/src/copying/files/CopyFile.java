/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copying.files;

/**
 *
 * @author Fadhil
 */
import java.io.*;
import java.util.Scanner;

public class CopyFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws FileNotFoundException{
        // TODO code application logic here
        String lokasi_nama_file = "C:\\Copying Files\\src\\copying\\files\\CopyingFile.txt";
        String nama_file = lokasi_nama_file.substring(89);
        Scanner scan_input = new Scanner(System.in);
        String input = "";
        //System.out.println(nama_file);
        while(!(nama_file.equals(input))){
             try{
                System.out.print("Masukkan nama file : ");
                input = scan_input.nextLine();
                
                if(nama_file.equals(input)){
                    File file = new File(lokasi_nama_file);
                    Scanner scan_file = new Scanner(file);
                    
                    while(scan_file.hasNextLine()){
                       String line = scan_file.nextLine();
                       System.out.println(line);             
                    }
                }
                
                else{
                   throw new FileNotFoundException();
                }
           }
    
            catch(FileNotFoundException ex){
                System.out.println("File Tidak Ditemukan");
            }
        }
    } 
}
