package cu.etecsa.tm.ecommerce.qHBfDCWv13G;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class vKpy0PpFx7 implements Key {
    private int currentVersion;

    public vKpy0PpFx7(int currentVersion) {
        this.currentVersion = currentVersion;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object o) {
        if (!(o instanceof vKpy0PpFx7)) {
            return false;
        }
        vKpy0PpFx7 other = (vKpy0PpFx7) o;
        return this.currentVersion == other.currentVersion;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.currentVersion;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest md) {
        md.update(ByteBuffer.allocate(32).putInt(this.currentVersion).array());
    }
}
