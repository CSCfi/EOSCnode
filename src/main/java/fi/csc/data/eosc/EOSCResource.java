package fi.csc.data.eosc;

import fi.csc.data.eosc.model.*;
import io.agroal.api.AgroalDataSource;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static fi.csc.data.eosc.ApplicationLifecycle.leug;


@Path("/v1/")
public class EOSCResource {

    @Inject
    AgroalDataSource defaultDataSource;

    @RunOnVirtualThread
    @Path("service")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EOSCPalvelu> list() {
        return palveluksi(EOSCEntity.listAll());
    }

    private List<EOSCPalvelu> palveluksi(List<PanacheEntityBase> eoscentlist) {
        return eoscentlist.stream().map(e -> new EOSCPalvelu((EOSCEntity) e)).toList();
    }

    @RunOnVirtualThread
    @Path("services")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EOSCResult eoscnode(@QueryParam("from") Integer from, @QueryParam("quantity") Integer quantity) {
        if (null == quantity) {
            quantity = 10;
        }
        if (null == from) {
            from = 0;
        }
        List<EOSCFrame> lef = kehystä(eoscservice(EOSCEntity.listAll()));
        int to = from + quantity;
        if (to > lef.size()) {
            to = lef.size();
        }
        return new EOSCResult(lef.size(), from, to, lef);
    }

    private List<EOSCFrame> kehystä(List<EOSCService> les) {
        return les.stream().filter(e -> e.iseosc == 1).map(EOSCFrame::new).toList();
    }

    private List<EOSCService> eoscservice(List<PanacheEntityBase> eoscentlist) {
        return eoscentlist.stream().map(e -> new EOSCService((EOSCEntity) e)).toList();
    }


    @RunOnVirtualThread
    @Path("endUserGroups")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EndUserGroups> esgsanasto() {
        return leug;
    }

    @RunOnVirtualThread
    @Path("customerSegment")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerSegment> cgsanasto() {
        return CustomerSegment.listAll();
    }

    @RunOnVirtualThread
    @Path("nodes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EOSCNodes> nodesanasto() {
        return EOSCNodes.listAll();
    }

    @RunOnVirtualThread
    @Path("accessTypes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccessTypes> accesssanasto() {
        return AccessTypes.listAll();
    }

    @RunOnVirtualThread
    @Path("purposes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Purpose> purposesanasto() {
        return Purpose.listAll();
    }

}
