package net.adamsmolnik.control.dataimport;

import java.nio.file.Paths;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import net.adamsmolnik.entity.EntityReferenceDest;
import net.adamsmolnik.entity.EntityReferenceSource;
import net.adamsmolnik.entity.OperationDetails;
import net.adamsmolnik.provider.EntityProvider;
import net.adamsmolnik.util.Configuration;

@Dependent
public class Importer {

    @Inject
    private Configuration conf;

    @Inject
    private EntityProvider entityProvider;

    public ImportDetails doImport(String srcObjectKey) {
        String internalFolder = conf.getServiceValue("import.internal");
        String fileName = Paths.get(srcObjectKey).getFileName().toString();
        EntityReferenceSource ers = new EntityReferenceSource(srcObjectKey);
        String destObjectKey = internalFolder + "/" + fileName;
        OperationDetails opDetails = entityProvider.copy(ers, new EntityReferenceDest(destObjectKey));
        Map<String, String> md = entityProvider.getMetadata(ers);
        md.put("destObjectKey", destObjectKey);
        entityProvider.setNewMetadata(ers, md);
        return new ImportDetails(destObjectKey, opDetails.getVersion(), opDetails.getInternalFootprint());
    }

}
