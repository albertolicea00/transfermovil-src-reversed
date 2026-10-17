package cu.etecsa.transfermovil.data;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.ZNRpoHwtLXM.MZUDJuUoMJL.ITMDataDatabase
 * @fingerprint single method getMetadata() returning TableMetadata (obfuscated: gwHFUMMDRu)
 *
 * Contract for ORMLite entities that expose their table schema descriptor.
 */
public interface ITMDataDatabase {

    /**
     * Returns the table schema descriptor for this entity.
     *
     * @return TableMetadata (obfuscated: gwHFUMMDRu) describing table name,
     *         primary key, and field roles
     */
    TableMetadata getMetadata();
}
