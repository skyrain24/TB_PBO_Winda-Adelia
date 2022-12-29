import java.sql.*;

//INTERFACE
public interface Pembelian {
    public void ID();
    public void Nama();
    public void JangkaWaktu()throws SQLDataException;
    public void NamaLayanan()throws SQLDataException;
    public void Harga()throws SQLDataException;
    public void TotalBayar()throws SQLDataException;
}
