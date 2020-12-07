package com.bibliotekUser;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bibliotekUser.databinding.FragmentBukuBindingImpl;
import com.bibliotekUser.databinding.FragmentPengumumanBindingImpl;
import com.bibliotekUser.databinding.ItemBukuBindingImpl;
import com.bibliotekUser.databinding.ItemPengumumanBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTBUKU = 1;

  private static final int LAYOUT_FRAGMENTPENGUMUMAN = 2;

  private static final int LAYOUT_ITEMBUKU = 3;

  private static final int LAYOUT_ITEMPENGUMUMAN = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bibliotekUser.R.layout.fragment_buku, LAYOUT_FRAGMENTBUKU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bibliotekUser.R.layout.fragment_pengumuman, LAYOUT_FRAGMENTPENGUMUMAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bibliotekUser.R.layout.item_buku, LAYOUT_ITEMBUKU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.bibliotekUser.R.layout.item_pengumuman, LAYOUT_ITEMPENGUMUMAN);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTBUKU: {
          if ("layout/fragment_buku_0".equals(tag)) {
            return new FragmentBukuBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_buku is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPENGUMUMAN: {
          if ("layout/fragment_pengumuman_0".equals(tag)) {
            return new FragmentPengumumanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_pengumuman is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBUKU: {
          if ("layout/item_buku_0".equals(tag)) {
            return new ItemBukuBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_buku is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPENGUMUMAN: {
          if ("layout/item_pengumuman_0".equals(tag)) {
            return new ItemPengumumanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_pengumuman is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(7);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "activity");
      sKeys.put(2, "buku");
      sKeys.put(3, "data");
      sKeys.put(4, "deskripsi");
      sKeys.put(5, "judul");
      sKeys.put(6, "pengumuman");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/fragment_buku_0", com.bibliotekUser.R.layout.fragment_buku);
      sKeys.put("layout/fragment_pengumuman_0", com.bibliotekUser.R.layout.fragment_pengumuman);
      sKeys.put("layout/item_buku_0", com.bibliotekUser.R.layout.item_buku);
      sKeys.put("layout/item_pengumuman_0", com.bibliotekUser.R.layout.item_pengumuman);
    }
  }
}
