package com.bibliotekUser.databinding;
import com.bibliotekUser.R;
import com.bibliotekUser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBukuBindingImpl extends ItemBukuBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBukuBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemBukuBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            );
        this.ivFotoProfil.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvJudulBuku.setTag(null);
        this.tvPenerbit.setTag(null);
        this.tvPengarang.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.buku == variableId) {
            setBuku((com.bibliotekUser.model.Buku) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBuku(@Nullable com.bibliotekUser.model.Buku Buku) {
        this.mBuku = Buku;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.buku);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String bukuPengarang = null;
        java.lang.String bukuJudul = null;
        java.lang.String bukuImgURL = null;
        com.bibliotekUser.model.Buku buku = mBuku;
        java.lang.String bukuPenerbit = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (buku != null) {
                    // read buku.pengarang
                    bukuPengarang = buku.getPengarang();
                    // read buku.judul
                    bukuJudul = buku.getJudul();
                    // read buku.imgURL
                    bukuImgURL = buku.getImgURL();
                    // read buku.penerbit
                    bukuPenerbit = buku.getPenerbit();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.bibliotekUser.model.Buku.loadImage(this.ivFotoProfil, bukuImgURL);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvJudulBuku, bukuJudul);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvPenerbit, bukuPenerbit);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvPengarang, bukuPengarang);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): buku
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}