package cu.etecsa.transfermovil.ui.home;

/**
 * @original_apk_version 1.260416
 * @obfuscated_class cu.etecsa.cubacel.tr.tm.V3QHJhzixi7i.j5DsTHaKx5I
 * @fingerprint Adapter contract for ItemTouchHelper drag/swipe operations.
 *              notificarCambio persists reorder to DB after drop.
 */
public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
    void notificarCambio(int originalPosition, int destinyPosition);
}
