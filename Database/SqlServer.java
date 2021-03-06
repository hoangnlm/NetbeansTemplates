<#if package?? && package != "">
package ${package};

</#if>
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Connect to SqlServer database.
 * @created on ${date}, ${time}
 * @author ${user}
 */
public class ${name} {

    private String server = "10.211.55.10";
    private String port = "1433";
    private String database = "WEA";
    private String username = "sa";
    private String password = "1";

    public String getUrl() {
        return "jdbc:sqlserver://" + server + ":" + port + ";database=" + database;
    }

    /**
     * Get a singleton connection from DriverManager
     * @return Connection
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(getUrl(), username, password);
    }

    /**
     * Set parameters for PreparedStatement
     *
     * @param ps
     * @param args
     * @throws Exception
     */
    public static void setParameters(PreparedStatement ps, Object... args) throws Exception {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].getClass() == Integer.class) {
                    ps.setInt(i + 1, (int) args[i]);
                } else if (args[i].getClass() == Long.class) {
                    ps.setLong(i + 1, (long) args[i]);
                } else if (args[i].getClass() == Float.class) {
                    ps.setFloat(i + 1, (float) args[i]);
                } else if (args[i].getClass() == Double.class) {
                    ps.setDouble(i + 1, (double) args[i]);
                } else if (args[i].getClass() == String.class) {
                    ps.setString(i + 1, (String) args[i]);
                } else if (args[i].getClass() == Boolean.class) {
                    ps.setBoolean(i + 1, (boolean) args[i]);
                } else if (args[i].getClass() == java.util.Date.class) {
                    java.util.Date origin = (java.util.Date) args[i];
                    java.sql.Date convert = new java.sql.Date(origin.getTime());
                    ps.setDate(i + 1, convert);
                } else if (args[i].getClass() == java.sql.Date.class) {
                    ps.setDate(i + 1, (java.sql.Date) args[i]);
                } else {
                    throw new Exception("Unsupported type of ps.setXXX().");
                }
            }
        }
    }

    /**
     * Get a CachedRowSet
     *
     * @param query
     * @return CachedRowSet
     */
//    public CachedRowSet getCachedRowSet(String query) {
//        CachedRowSet cachedRowSet = null;
//        try {
//            cachedRowSet = new CachedRowSetImpl();
//            cachedRowSet.setUrl(getUrl());
//            cachedRowSet.setUsername(username);
//            cachedRowSet.setPassword(password);
//            cachedRowSet.setCommand(query);
//        } catch (SQLException e) {
//            Logger.getLogger(MySql2.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return cachedRowSet;
//    }
    
    /**
     * Set parameters for CachedRowSet
     *
     * @param crs
     * @param args
     * @throws Exception
     */
//    public static void setParametersCrs(CachedRowSet crs, Object... args) throws Exception {
//        if (args.length > 0) {
//            for (int i = 0; i < args.length; i++) {
//                if (args[i].getClass() == Integer.class) {
//                    crs.setInt(i + 1, (int) args[i]);
//                } else if (args[i].getClass() == Long.class) {
//                    crs.setLong(i + 1, (long) args[i]);
//                } else if (args[i].getClass() == Float.class) {
//                    crs.setFloat(i + 1, (float) args[i]);
//                } else if (args[i].getClass() == Double.class) {
//                    crs.setDouble(i + 1, (double) args[i]);
//                } else if (args[i].getClass() == String.class) {
//                    crs.setString(i + 1, (String) args[i]);
//                } else if (args[i].getClass() == Boolean.class) {
//                    crs.setBoolean(i + 1, (boolean) args[i]);
//                } else if (args[i].getClass() == java.util.Date.class) {
//                    java.util.Date origin = (java.util.Date) args[i];
//                    java.sql.Date convert = new java.sql.Date(origin.getTime());
//                    crs.setDate(i + 1, convert);
//                } else if (args[i].getClass() == java.sql.Date.class) {
//                    crs.setDate(i + 1, (java.sql.Date) args[i]);
//                } else {
//                    throw new Exception("Unsupported type of ps.setXXX().");
//                }
//            }
//        }
//    }
   
}
