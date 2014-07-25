package net.adamsmolnik.control.dataimport;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import net.adamsmolnik.entity.EntityDetails;
import net.adamsmolnik.entity.EntityReferenceDest;
import net.adamsmolnik.entity.EntityReferenceSource;
import net.adamsmolnik.provider.EntityProvider;

@Dependent
public class Importer {

    @Inject
    private EntityProvider entityProvider;

    public String doImport(String srcObjectKey, String destObjectKey) {
        EntityDetails ed = entityProvider.move(new EntityReferenceSource(srcObjectKey), new EntityReferenceDest(destObjectKey));
        return ed.getVersion();
    }
}
