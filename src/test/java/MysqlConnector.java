import java.sql.*;

import static java.lang.Thread.sleep;

public class MysqlConnector {

    //private static final String dbDriver = "com.mysql.jdbc.Driver";
    private static final String dbURL = "jdbc:mysql://localhost:3306/cwd_db?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useAffectedRows=true";
    public static final int frequency =1000;
    public static final int A =1000;
    public static void main(String[] args) throws SQLException, InterruptedException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbURL, "root", "1");

        String sql1 = "insert into Motor1 values (8,?,?,0,0,0,0,?)";
        PreparedStatement psMotor1 = connection.prepareStatement(sql1);
        String sql2 = "insert into Motor2 values (8,?,?,0,0,0,0,?)";
        PreparedStatement psMotor2 = connection.prepareStatement(sql2);
        String sql3 = "insert into Motor3 values (8,?,?,0,0,0,0,?)";
        PreparedStatement psMotor3 = connection.prepareStatement(sql3);

        int i=0;
        int k=100;
        while (k-->0){
            sleep(100);
            if (i++>frequency) i=0;
            double v = A * Math.sin(2 * Math.PI * i / frequency);
            psMotor1.setInt(1, (int) v);
            psMotor1.setInt(2, (int) (v+Math.random()*50));
            psMotor1.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            psMotor1.executeUpdate();

            psMotor2.setInt(1, (int) v);
            psMotor2.setInt(2, (int) (v+Math.random()*50));
            psMotor2.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            psMotor2.executeUpdate();

            psMotor3.setInt(1, (int) v);
            psMotor3.setInt(2, (int) (v+Math.random()*50));
            psMotor3.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            psMotor3.executeUpdate();
        }

    }
}
