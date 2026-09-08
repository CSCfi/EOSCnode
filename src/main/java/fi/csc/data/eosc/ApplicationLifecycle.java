package fi.csc.data.eosc;

import fi.csc.data.eosc.model.*;
import io.agroal.api.AgroalDataSource;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Startup
@ApplicationScoped
public class ApplicationLifecycle {

    private static final Logger LOG = Logger.getLogger(ApplicationLifecycle.class);
     public static Hashtable<Integer, List<Integer>> datapurpose = new Hashtable<>();
     public static Hashtable<Integer, Purpose> htpurpose = new Hashtable<>();
     public static Hashtable<Integer, CustomerSegment> htcg  = new Hashtable<>();
     public static Hashtable<Integer, List<Integer>> htbrcg = new Hashtable<>();
     public static Hashtable<Integer, List<Integer>>  htbreug = new Hashtable<>();
     public static Hashtable<Integer, EndUserGroups> hteug = new Hashtable<>();
     public static Hashtable<Integer, String> eosctarget = new Hashtable<>();
     public static Hashtable<Integer, Category> eosccategory = new Hashtable<>();
     public static List<EndUserGroups> leug;
     public static final String[] languages ={"EN", "FI"};

     @Inject
     AgroalDataSource defaultDataSource;
     /**
     * Run when program starts. Store vocabularies to memory as hastables
      * =Ajetaan ohjelman käynnistyessä. Alustaa jotkut taulut muistiin.
     *
     * @param event (NOT in use! ei käytetä!)
     */
    void onStart(@Observes StartupEvent event) {
        List<Purpose> lpurpose = Purpose.listAll();
        lpurpose.forEach(p -> htpurpose.put(p.id, p));
        leug = EndUserGroups.listAll();
        leug.forEach(eug-> hteug.put(eug.id, eug));
        try {
            SQL sql = new SQL(defaultDataSource.getConnection());
            List<BrEOSCDataPurpose> ldatapurpose = sql.haeTarkoitukset();
            ldatapurpose.forEach(this::taulutaP);
            //ldatapurpose.forEach(e -> System.out.println("Purpose " + e.purpose()));
            List<CustomerSegment> lcg = CustomerSegment.listAll();
            lcg.forEach(cs -> htcg.put(cs.id, cs));
            List<BrEOSCDataCustomerSegment> ldatacs = sql.haeAsiakssJoukko();
            ldatacs.forEach(this::taulutaCS);
            List<BrEOSCDataEndusergroups> lserviceeug = sql.loadendusers();
            lserviceeug.forEach(this::toTable);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Store end user vocabulary database values to hashtable
     * desc br_eoscdata_end_user_groups;
+--------+---------+------+-----+---------+-------+
| Field  | Type    | Null | Key | Default | Extra |
+--------+---------+------+-----+---------+-------+
| id     | int(11) | NO   |     | NULL    |       |
| eug_id | int(11) | NO   |     | NULL    |       |
+--------+---------+------+-----+---------+-------+
     *  desc end_user_groups;
     * +-------+--------------+------+-----+---------+----------------+
     | Field | Type         | Null | Key | Default | Extra          |
     +-------+--------------+------+-----+---------+----------------+
     | id    | int(11)      | NO   | PRI | NULL    | auto_increment |
     | en    | varchar(255) | NO   |     | NULL    |                |
     | fi    | varchar(255) | YES  |     | NULL    |                |
     +-------+--------------+------+-----+---------+----------------+
     *
     * @param p BrEOSCDataEndusergroups record
     */
    private void toTable(BrEOSCDataEndusergroups p) {
        List<Integer> li = htbreug.get(p.palvelu());
        if (null == li) {
            li = new ArrayList<>();
            li.add(p.eug_id());
            LOG.info("EUG initial add " + p.palvelu() + "+" + p.eug_id());
            htbreug.put(p.palvelu(), li);
        }   else {
            li.add(p.eug_id());
        }

    }

    /**
     * Store purpose vocabulary database values to hashtable
     *palvelu=service
     *+---------+---------+------+-----+---------+-------+
| Field   | Type    | Null | Key | Default | Extra |
+---------+---------+------+-----+---------+-------+
| palvelu | int(11) | NO   | PRI | NULL    |       |
| purpose | int(11) | NO   | PRI | NULL    |       |
+---------+---------+------+-----+---------+-------+
     *
     *
     * @param p BrEOSCDataPurpose record
     */
    private void taulutaP(BrEOSCDataPurpose p) {
        List<Integer> li = datapurpose.get(p.palvelu());
        if (null == li) {
            li = new ArrayList<>();
            li.add(p.purpose());
            datapurpose.put(p.palvelu(), li);
        } else {
            li.add(p.purpose());
            LOG.info("Purpose add "+ p.palvelu() +"+"+ p.purpose());
        }
    }


    /**
     * Store database values to hashtable
     *
     *  desc customer_segment;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | int(11)      | NO   | PRI | NULL    | auto_increment |
| en    | varchar(255) | NO   |     | NULL    |                |
| fi    | varchar(255) | YES  |     | NULL    |                |

     * @param cs BrEOSCDataCustomerSegment record
     */
    private void taulutaCS(BrEOSCDataCustomerSegment cs) {
        List<Integer> lcs = htbrcg.get(cs.id());
        if (null == lcs) {
             lcs = new ArrayList<>();
             lcs.add(cs.cs_id());
            htbrcg.put(cs.id(), lcs);
        } else {
            lcs.add(cs.cs_id());
        }

    }

    /**
     * EOSC vocabularies
     * https://docs.google.com/document/d/1CcUfiJCttIqN40Y-F84-mphu7Ao8nJTm/edit#heading=h.hqrxf2he8vr
     */
    static {
        eosccategory.put(1, new Category("category-access_physical_and_eInfrastructures-compute"));
        eosccategory.put(2, new Category("category-access_physical_and_eInfrastructures-data_storage"));
        eosccategory.put(3, new Category("category-access_physical_and_eInfrastructures-data_storage"));
        eosccategory.put(4, new Category("category-sharing_and_discovery-data"));
        eosccategory.put(5, new Category("category-access_physical_and_eInfrastructures-network"));
        eosctarget.put(1, "target_user-research_groups");
        eosctarget.put(2, "target_user-students");
        eosctarget.put(3, "target_user-other");
        eosctarget.put(4, "target_user-business");
        eosctarget.put(5, "target_user-providers");
        eosctarget.put(6, "target_user-research_infrastructure_managers");
        eosctarget.put(7, "target_user-innovators");
        eosctarget.put(8, "target_user-business");
        eosctarget.put(9, "target_user-research_organisations");
    }


}
