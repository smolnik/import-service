package net.adamsmolnik.boundary.dataimport;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.adamsmolnik.control.dataimport.ImportDetails;
import net.adamsmolnik.control.dataimport.Importer;
import net.adamsmolnik.model.dataimport.ImportRequest;
import net.adamsmolnik.model.dataimport.ImportResponse;

/**
 * @author ASmolnik
 *
 */
@Path("/is")
@RequestScoped
public class ImportService {

    @Inject
    private Importer importer;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("import")
    public String doImport(@FormParam("srcObjectKey") String srcObjectKey, @FormParam("destObjectKey") String destObjectKey) {
        return importer.doImport(srcObjectKey).toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("import")
    public ImportResponse doImport(ImportRequest importRequest) {
        ImportDetails ids = importer.doImport(importRequest.srcObjectKey);
        return new ImportResponse(ids.getImportedObjectKey(), ids.getVersion());
    }

}
