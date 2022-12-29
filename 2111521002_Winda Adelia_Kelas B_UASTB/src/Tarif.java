import java.util.Scanner;

import java.sql.*;

import java.sql.SQLDataException;

public class Tarif extends Akun{
    static Connection conn;
    String url = "jdbc:mysql://localhost:3306/dbakunpremium";
    Scanner input = new Scanner(System.in);

    // CONSTRUCTOR
    public Tarif (){

    }

    // METHOD
    @Override
    public void NamaLayanan() throws SQLDataException {
        System.out.println("\n Nama Layanan ");
        System.out.println("    1. Spotify");
        System.out.println("    2. Joox");
        System.out.println("    3. Resso");

        System.out.print("\nPilihan Layanan [1-3] : ");
        x = input.nextInt();
        // PERCABANGAN
        if (x == 1) {
            layanan = "Spotify";
        } else if (x == 2) {
            layanan = "Joox";
        } else if (x == 3) {
            layanan = "Resso";
        } else {
            System.out.println("Pilihan tidak tersedia");
        }
        System.out.println("Nama Layanan         : " + layanan);
    }

    // METHOD
    @Override
    public void Harga() throws SQLDataException {
        if (layanan == "Spotify") {
            tarif = 55000;
        } else if (layanan == "Joox") {
            tarif = 49000;
        } else if (layanan == "Resso") {
            tarif = 50000;
        }
        System.out.println("Tarif/bulan          : " + tarif);
    }

    public void JangkaWaktu() throws SQLDataException {
        System.out.print("Jangka Waktu/bulan   : ");
        jangkawaktu = input.nextInt();

    }
    // METHOD
    @Override
    public void TotalBayar() throws SQLDataException {
        total = jangkawaktu * tarif;
        System.out.println("Total Pembayaran    : " + total);
    }

    //CRUD
    public void lihatdata() throws SQLException {
        System.out.println("................................................");
        String t1 = ".............. Data Transaksi ..................";
        System.out.println(t1.toUpperCase());
        System.out.println("................................................");
        

        String sql = "SELECT * FROM tblbeliakun";
        conn = DriverManager.getConnection(url, "root", "");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        // PERULANGAN
        while (result.next()) {
            System.out.print("\nID\t                : ");
            System.out.print(result.getInt("id"));
            System.out.print("\nNama\t                : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nNama Layanan\t        : ");
            System.out.print(result.getString("layanan"));
            System.out.print("\nTarif/bulan\t        : ");
            System.out.print(result.getInt("tarif"));
            System.out.print("\nJangka Waktu\t        : ");
            System.out.print(result.getInt("jangkawaktu"));
            System.out.print("\nTotal Pembayaran\t: ");
            System.out.print(result.getInt("total"));
            System.out.print("\n");
        }
    }

    public void tambahdata() throws SQLException {
        System.out.println("................................................");
        String t2 = "........... Tambah Data Transaksi ..............";
        System.out.println(t2.toUpperCase());
        System.out.println("................................................");
        
        try {

            ID();
            Nama();
            NamaLayanan();
            JangkaWaktu();
            Harga();
            TotalBayar();

            conn = DriverManager.getConnection(url, "root", "");
            String sql = "INSERT INTO tblbeliakun (id,nama,layanan,tarif,jangkawaktu,total) VALUES ('" + id + "','" + nama + "','"
                    + layanan + "','" + tarif + "','" + jangkawaktu + "','" + total + "')";
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Berhasil input data!!!");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan dalam input data!");
        }

    }

    public void ubahdata() throws SQLException {
        System.out.println("................................................");
        String t2 = "............ Ubah Data Transaksi ...............";
        System.out.println(t2.toUpperCase());
        System.out.println("................................................\n");
        

        try {
            lihatdata();
            System.out.print("\n Masukkan ID yang akan di update : ");
            Integer id = Integer.parseInt(input.nextLine());

            String sql = "SELECT * FROM tblbeliakun WHERE id = " + id;
            conn = DriverManager.getConnection(url, "root", "");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {

                System.out.print("Nama  [" + result.getString("nama") + "]\t: ");
                String nama = input.nextLine();
                
                sql = "UPDATE tblbeliakun SET nama='" + nama + "' WHERE id='" + id + "'";

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("Berhasil memperbaharui data transaksi (id " + id + ")");
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }

    }

    public void hapusdata() throws SQLException {
        System.out.println("................................................");
        String t3 = "............ Hapus Data Transaksi ...............";
        System.out.println(t3.toUpperCase());
        System.out.println("................................................");
        

        try {
            lihatdata();
            System.out.print("\nKetik ID pemesanan yang akan Anda Hapus : ");
            int id = input.nextInt();

            String sql = "DELETE FROM tblbeliakun WHERE id = " + id;
            conn = DriverManager.getConnection(url, "root", "");
            Statement statement = conn.createStatement();
            // ResultSet result = statement.executeQuery(sql);

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil menghapus data transaksi ( nomor id " + id + ")");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam menghapus data");
        }

    }

    public void caridata() throws SQLException {
        System.out.println("................................................");
        String t4 = "............. Cari Data Transaksi ..............";
        System.out.println(t4.toUpperCase());
        System.out.println("................................................");
     

        System.out.print("Masukkan Nama Pembeli : ");
        String keyword = input.nextLine();

        String sql = "SELECT * FROM tblbeliakun WHERE nama LIKE '%" + keyword + "%'";
        conn = DriverManager.getConnection(url, "root", "");
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nID\t                : ");
            System.out.print(result.getInt("id"));
            System.out.print("\nNama\t                : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nNama Layanan\t        : ");
            System.out.print(result.getString("layanan"));
            System.out.print("\nTarif/bulan\t        : ");
            System.out.print(result.getInt("tarif"));
            System.out.print("\nJangka Waktu\t        : ");
            System.out.print(result.getInt("jangkawaktu"));
            System.out.print("\nTotal Pembayaran\t: ");
            System.out.print(result.getInt("total"));
            System.out.print("\n");
        }
    }

}
