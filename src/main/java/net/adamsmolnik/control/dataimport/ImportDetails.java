package net.adamsmolnik.control.dataimport;

/**
 * @author ASmolnik
 *
 */
public class ImportDetails {

    private final String importedObjectKey;

    private final String version;

    private final String internalFootprint;

    public ImportDetails(String importedObjectKey, String version, String internalFootprint) {
        this.importedObjectKey = importedObjectKey;
        this.version = version;
        this.internalFootprint = internalFootprint;
    }

    public String getImportedObjectKey() {
        return importedObjectKey;
    }

    public String getVersion() {
        return version;
    }

    public String getInternalFootprint() {
        return internalFootprint;
    }

}
