import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    private static final String SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String SQL_CON_URL = "jdbc:sqlserver://localhost:1434; user=sa; password=Yashas@003";

    public static void main(String[] args) {
        Statement stm;
        Connection con;

        try {
            Class.forName(SQL_DRIVER);
            con = DriverManager.getConnection(SQL_CON_URL);

            if (con != null) {
                System.out.println("Connected");

                stm = con.createStatement();
                stm.execute("use [Android Apps];");
                ResultSet set = stm.executeQuery("select * from App;");

                while (set.next()) System.out.println(
                        set.getInt(1) + "    " +
                                set.getString(2) + "    " +
                                set.getInt(3));

                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
