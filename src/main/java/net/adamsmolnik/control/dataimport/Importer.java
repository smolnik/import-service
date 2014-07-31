package net.adamsmolnik.control.dataimport;

import java.nio.file.Paths;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import net.adamsmolnik.entity.EntityDetails;
import net.adamsmolnik.entity.EntityReferenceDest;
import net.adamsmolnik.entity.EntityReferenceSource;
import net.adamsmolnik.provider.EntityProvider;
import net.adamsmolnik.setup.ServiceNameResolver;
import net.adamsmolnik.util.Configuration;

@Dependent
public class Importer {

    @Inject
    private Configuration conf;

    @Inject
    private EntityProvider entityProvider;

    @Inject
    private ServiceNameResolver snr;

    public ImportDetails doImport(String srcObjectKey) {
        String internalFolder = conf.getServiceValue(snr.getServiceName(), "import.internal");
        String fileName = Paths.get(srcObjectKey).getFileName().toString();
        String destObjectKey = internalFolder + "/" + fileName;
        EntityDetails ed = entityProvider.move(new EntityReferenceSource(srcObjectKey), new EntityReferenceDest(destObjectKey));
        return new ImportDetails(destObjectKey, ed.getVersion(), ed.getInternalFootprint());
    }

    @Override
    public String toString() {
        return "Importer [conf=" + conf + ", entityProvider=" + entityProvider + ", snr=" + snr + "]";
    }

}
