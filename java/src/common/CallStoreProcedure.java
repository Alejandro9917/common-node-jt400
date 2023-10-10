package common;

import com.ibm.as400.access.AS400JDBCDriver;

import java.io.Reader;
import java.sql.*;

public class CallStoreProcedure {    
    public String example(){
        return "It's work";
    }

    public String SimpleConnection(String host, String username, String password, String sql) {
        try {
            DriverManager.registerDriver(new AS400JDBCDriver());
            Connection conn = DriverManager.getConnection("jdbc:as400://" + host, username, password);
            System.out.println("[INFO] Connected.");
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1, Types.CLOB);
            callableStatement.executeUpdate();
            Clob result = callableStatement.getClob(1);
            Reader r = result.getCharacterStream();
            StringBuffer buffer = new StringBuffer();
            int ch;
            while ((ch = r.read())!=-1) {
                buffer.append(""+(char)ch);
            }
            System.out.println("[INFO] Return buffer.");
            return buffer.toString();
        } catch (Exception e) {
            System.out.println("[ERROR] Error: " + e);
        }
        return null;
    }
}