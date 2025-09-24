package fi.csc.data.eosc;

import fi.csc.data.eosc.model.*;
import io.agroal.api.AgroalDataSource;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/v1/")
public class EOSCResource {

    @Inject
    AgroalDataSource defaultDataSource;

    @Path("service")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EOSCPalvelu> list() {
        return palveluksi(EOSCEntity.listAll());
    }

    private List<EOSCPalvelu> palveluksi(List<PanacheEntityBase> eoscentlist) {
        return eoscentlist.stream().map(e -> new EOSCPalvelu((EOSCEntity) e)).toList();
    }

    @Path("nodes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> noodit() {
        return EOSCNodes.listAll();
    }

    @Path("purposes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> tarkoitukset() {
        return Purpose.listAll();
    }

    @Path("accesstypes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> accesstyopes() {
        return AccessTypes.listAll();
    }

    @Path("customersegments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> customersegments() {
        return CustomerSegment.listAll();
    }

    @Path("endusers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> endusers() {
        return EndUserGroups.listAll();
    }

}
