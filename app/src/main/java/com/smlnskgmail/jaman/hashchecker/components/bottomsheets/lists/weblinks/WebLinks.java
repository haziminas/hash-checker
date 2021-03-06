package com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.weblinks;

import com.smlnskgmail.jaman.hashchecker.R;
import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.base.ListItemMarker;

public enum WebLinks implements ListItemMarker {

    SOURCE_CODE(R.string.title_web_link_github, R.drawable.ic_github, R.string.web_link_source_code),
    MY_APPS(R.string.title_web_link_google_play, R.drawable.ic_google_play, R.string.web_link_my_apps);

    private int titleResId, iconResId, linkResId;

    WebLinks(int titleResId, int iconResId, int linkResId) {
        this.titleResId = titleResId;
        this.iconResId = iconResId;
        this.linkResId = linkResId;
    }

    public int getLinkResId() {
        return linkResId;
    }

    @Override
    public int getTitleTextResId() {
        return titleResId;
    }

    @Override
    public int getPrimaryIconResId() {
        return iconResId;
    }

    @Override
    public int getAdditionalIconResId() {
        return -1;
    }

}

