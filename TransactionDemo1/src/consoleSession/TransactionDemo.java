package consoleSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

//=== Demo: System Transaction using JDBC
//=== Sets autocommit off
//=== Executes 2 update statements
//=== Commit or rollback  
//=== hau/2015
public class TransactionDemo
{

    public static void main(String[] args)
    {
        String id = "cphrh110";     // insert your ORACLE id and password
        String pw = "cphrh110";
        Statement statement = null;
        Connection conn = null;

        try
        {
            //-- prepare db communication
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);
            String SQLstring = "update parts set qoh = qoh + 1 where pno = 10506";
            statement = conn.createStatement();

            //-- start transaction
            conn.setAutoCommit(false);

            //-- execute 1. statement
            statement.executeUpdate(SQLstring);

            //-- wait for go
            JOptionPane.showMessageDialog(null, "Press to continue");

            //-- execute 2. statement
            statement.executeUpdate(SQLstring);

            //-- commit transaction
            conn.commit();

        } catch (SQLException ee)
        {
            System.out.println("Fail during update");
            System.err.println(ee);
            try
            {
                conn.rollback();
                System.out.println("Transaction rolled back!");
            } catch (SQLException e)
            {
                System.out.println("Fail during rollBack");
            }

        } finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                } catch (SQLException e)
                {
                }
            }
            if (conn != null)
            {
                try
                {
                    conn.close();
                } catch (SQLException e)
                {
                }
            }
        }
    }
}
