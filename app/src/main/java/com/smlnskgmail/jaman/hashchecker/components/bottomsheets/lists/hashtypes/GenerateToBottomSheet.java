package com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.hashtypes;

import android.support.annotation.NonNull;

import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.base.BaseItemsBottomSheet;
import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.base.adapter.BaseBottomSheetItemsAdapter;
import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.hashtypes.adapter.HashesBottomSheetItemsAdapter;

public class GenerateToBottomSheet extends BaseItemsBottomSheet {

    private OnHashTypeSelectListener onHashTypeSelectListener;

    @Override
    public BaseBottomSheetItemsAdapter getItemsAdapter() {
        return new HashesBottomSheetItemsAdapter(getListItems(), this, onHashTypeSelectListener);
    }

    public void setOnHashTypeSelectListener(@NonNull OnHashTypeSelectListener onHashTypeSelectListener) {
        this.onHashTypeSelectListener = onHashTypeSelectListener;
    }

}
