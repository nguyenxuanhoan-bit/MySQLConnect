package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiCSDL {
    public Connection conn = null;

    public void connect() {
        try {
            String userName = "sa";
            String passWord = "123";
            String URL = "jdbc:sqlserver://HungPhan:1433;databaseName=CTDTGT;user=sa;password=123;encrypt=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, userName, passWord);
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            System.err.println("Kết nối thất bại");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đã đóng kết nối");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        KetNoiCSDL ketNoiCSDL = new KetNoiCSDL();
        ketNoiCSDL.connect();
        // Sau khi thực hiện các thao tác với cơ sở dữ liệu, đảm bảo đóng kết nối
        ketNoiCSDL.disconnect();
    }
}
