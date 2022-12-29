import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.*;

public class App {

    static Connection conn;
	String url = "jdbc:mysql://localhost:3306/dbakunpremium";

    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner (System.in)) {
            String pilihan;
            boolean lanjut=true;
            String url = "jdbc:mysql://localhost:3306/dbakunpremium";
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	conn = DriverManager.getConnection(url,"root","");
            	System.out.println("\nBerhasil Terkoneksi ke Database");


               // PERULANGAN
            	while (lanjut) {
            		System.out.println("\n=================================================================");
                    String judul=        "================== Database Pembelian Akun Premium ================";
            		System.out.println(judul.toUpperCase());
                    System.out.println("=================================================================");
            		System.out.println("    1. Lihat Data Transaksi");
            		System.out.println("    2. Tambah Data Transaksi");
            		System.out.println("    3. Ubah Data Transaksi");
            		System.out.println("    4. Hapus Data Transaksi");
            		System.out.println("    5. Cari Data Transaksi");
            		System.out.println("    6. Playlist");
            		
            		System.out.println("\nPilihan menu [1-6]: ");
            		pilihan = input.next();

            		Tarif tarif = new Tarif ();

            		// PERCABANGAN
            		switch (pilihan) {
            		case "1":
            			tarif.lihatdata();
            			break;
            		case "2":
            			tarif.tambahdata();
            			break;
            		case "3":
            			tarif.ubahdata();
            			break;
            		case "4":
            			tarif.hapusdata();
            			break;
            		case "5":
            			tarif.caridata();
            			break;
            		case "6":
            			MenuPlaylist playlist = new MenuPlaylist();
            			playlist.menuProgram();
            			break;
            		default:
            			System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-6]");
            		}
            		
            		System.out.println("\nApakah Anda yakin ingin melanjutkan [y/n]? ");
            		pilihan= input.next();
            		lanjut = pilihan.equalsIgnoreCase("y"); // Method String

            		// Method Date
            		Date date = new Date();
            		SimpleDateFormat tgl = new SimpleDateFormat("d MMM yyyy");
            		System.out.println("\nTanggal Sekarang   :  " + tgl.format(date));
            		SimpleDateFormat wkt = new SimpleDateFormat("hh:mm:ss a zzz");
            		System.out.println("Waktu Sekarang     :  " + wkt.format(date));

            	}
            	String t = "\n		------------------    Program selesai  ------------------\n";
            	System.out.println(t.toUpperCase());  // Method String
            	
            }
            catch(ClassNotFoundException ex) {
            	System.err.println("Driver Error");
            	System.exit(0);
            }
            catch(SQLException e){
            	System.err.println("Tidak berhasil koneksi");
            }
        }
    }

}