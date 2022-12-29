import java.sql.SQLDataException;
import java.util.Scanner;

//IMPLEMENTS
public class Akun implements Pembelian{
    int id, jangkawaktu, x, harga, tarif,total;
    String nama, layanan;
    Scanner input = new Scanner(System.in);

    // CONSTRUCTOR
    public Akun(){

    }
    
    // METHOD
    public void ID()  {
        System.out.print("Nomor ID   : ");
        id = input.nextInt();

    }

    // METHOD
    public void Nama()  {
        System.out.print("Nama       : ");
        nama = input.next();
        input.nextLine();
        

    }

    public void NamaLayanan() throws SQLDataException {
        
    }

    public void Harga() throws SQLDataException {
        
    }

    public void JangkaWaktu() throws SQLDataException {
       
    }

    public void TotalBayar()throws SQLDataException {
        
    }

    
}