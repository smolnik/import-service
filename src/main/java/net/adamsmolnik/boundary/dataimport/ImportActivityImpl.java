package net.adamsmolnik.boundary.dataimport;

import net.adamsmolnik.control.dataimport.Importer;
import net.adamsmolnik.model.dataimport.ImportRequest;
import net.adamsmolnik.model.dataimport.ImportResponse;

/**
 * @author ASmolnik
 *
 */
public class ImportActivityImpl implements ImportActivity {

    private final Importer importer;

    public ImportActivityImpl(Importer importer) {
        this.importer = importer;
    }

    @Override
    public ImportResponse doImport(ImportRequest importRequest) {
        return new ImportResponse(this.importer.doImport(importRequest.srcObjectKey, importRequest.destObjectKey));
    }

}
