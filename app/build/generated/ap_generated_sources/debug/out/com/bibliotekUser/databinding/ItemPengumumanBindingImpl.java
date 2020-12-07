package com.bibliotekUser.databinding;
import com.bibliotekUser.R;
import com.bibliotekUser.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemPengumumanBindingImpl extends ItemPengumumanBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemPengumumanBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ItemPengumumanBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvDescPengumuman.setTag(null);
        this.tvJudulPengumuman.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.pengumuman == variableId) {
            setPengumuman((com.bibliotekUser.model.Pengumuman) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPengumuman(@Nullable com.bibliotekUser.model.Pengumuman Pengumuman) {
        updateRegistration(0, Pengumuman);
        this.mPengumuman = Pengumuman;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.pengumuman);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePengumuman((com.bibliotekUser.model.Pengumuman) object, fieldId);
        }
        return false;
    }
    private boolean onChangePengumuman(com.bibliotekUser.model.Pengumuman Pengumuman, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.judul) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.deskripsi) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
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
        java.lang.String pengumumanDeskripsi = null;
        com.bibliotekUser.model.Pengumuman pengumuman = mPengumuman;
        java.lang.String pengumumanJudul = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (pengumuman != null) {
                        // read pengumuman.deskripsi
                        pengumumanDeskripsi = pengumuman.getDeskripsi();
                    }
            }
            if ((dirtyFlags & 0xbL) != 0) {

                    if (pengumuman != null) {
                        // read pengumuman.judul
                        pengumumanJudul = pengumuman.getJudul();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDescPengumuman, pengumumanDeskripsi);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvJudulPengumuman, pengumumanJudul);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): pengumuman
        flag 1 (0x2L): pengumuman.judul
        flag 2 (0x3L): pengumuman.deskripsi
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}