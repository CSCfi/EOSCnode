package fi.csc.data.eosc;

import fi.csc.data.eosc.model.BrEOSCDataCustomerSegment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.csc.data.eosc.model.BrEOSCDataEndusergroups;
import fi.csc.data.eosc.model.BrEOSCDataPurpose;
import org.jboss.logging.Logger;

public class SQL {

    private static final Logger LOG = Logger.getLogger(SQL.class);
    private static final String ASIAKASQUERY = "SELECT * FROM br_eoscdata_customer_segment";
    private static final String TARKOITUSQUERY = "SELECT * FROM br_eoscdata_purpose";
    private static final String ENDUSERQUERY = "SELECT * FROM br_eoscdata_end_user_groups";

    Connection conn;

    public SQL(Connection conn) {
        this.conn = conn;
    }

    /**
     * Read  service br_eoscdata_customer_segment from database
     *
     * @return List<BrEOSCDataCustomerSegment> List of records
     */
    List<BrEOSCDataCustomerSegment> haeAsiakssJoukko() {
        try {
          Statement stmt =  conn.createStatement();
          ResultSet rs = stmt.executeQuery(ASIAKASQUERY);
          List<BrEOSCDataCustomerSegment> lbedcg = new ArrayList<>();
          while(rs.next()) {
              lbedcg.add(new BrEOSCDataCustomerSegment(rs.getInt(1), rs.getInt(2)));
          }
          rs.close();
          stmt.close();
          return lbedcg;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            return null;
            //throw new RuntimeException(e);
        }

    }

    /**
     * Read  br_eoscdata_purpose from database
     *
     * @return List<BrEOSCDataPurpose> List of records
     */
    public List<BrEOSCDataPurpose> haeTarkoitukset() {
       try {
          Statement stmt =  conn.createStatement();
          ResultSet rs = stmt.executeQuery(TARKOITUSQUERY);
          List<BrEOSCDataPurpose> lbedp = new ArrayList<>();
          while(rs.next()) {
              lbedp.add(new BrEOSCDataPurpose(rs.getInt(1), rs.getInt(2)));
          }
          return lbedp;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    /**
     * Read  br_eoscdata_end_user_groups from database
     *
     * @return List<BrEOSCDataEndusergroups>  List of records
     */
     List<BrEOSCDataEndusergroups> loadendusers() {
        try {
          Statement stmt =  conn.createStatement();
          ResultSet rs = stmt.executeQuery(ENDUSERQUERY);
          List<BrEOSCDataEndusergroups> lbedeug = new ArrayList<>();
          while(rs.next()) {
              lbedeug.add(new BrEOSCDataEndusergroups(rs.getInt(1), rs.getInt(2)));
          }
          rs.close();
          stmt.close();
          return lbedeug;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            return null;
        }

    }

}
