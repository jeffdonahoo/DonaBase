package donabase;

import java.util.List;

/**
 * Example program to print all rows from specified table
 */
public class DonaBaseExample {
  public static void main(String[] args) throws NumberFormatException, DonaBaseException {
    // Check parameters
    if (args.length != 6) {
      System.err.println("Parameter(s): <server> <port> <dbname> <user> <password> <table>");
      System.exit(1);
    }
    
    // Connect, execute select query from specified table, and dump results to console
    try (DonaBaseConnection dbConn =
                 new DonaBaseConnection(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4])) {
      for (List<String> row : dbConn.query("SELECT * from " + args[5])) {
        for (String value : row) {
          System.out.print(value + ",");
        }
        System.out.println();
      }
    }
  }
}
