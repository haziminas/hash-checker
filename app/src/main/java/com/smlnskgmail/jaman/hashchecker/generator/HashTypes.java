package com.smlnskgmail.jaman.hashchecker.generator;

import android.content.Context;
import android.support.annotation.NonNull;

import com.smlnskgmail.jaman.hashchecker.R;
import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.base.ListItemMarker;

public enum HashTypes implements ListItemMarker {

    MD5(R.string.hash_type_md5),
    SHA_1(R.string.hash_type_sha1),
    SHA_224(R.string.hash_type_sha224),
    SHA_256(R.string.hash_type_sha256),
    SHA_384(R.string.hash_type_sha384),
    SHA_512(R.string.hash_type_sha512);

    private int hashTypeNameResId;

    HashTypes(int hashTypeNameResId) {
        this.hashTypeNameResId = hashTypeNameResId;
    }

    @NonNull
    public String getTypeAsString(@NonNull Context context) {
        return context.getString(hashTypeNameResId);
    }

    @NonNull
    public static HashTypes parseHashTypeFromString(@NonNull Context context, @NonNull String data) {
        if (context.getString(SHA_1.hashTypeNameResId).equals(data)) {
            return SHA_1;
        } else if (context.getString(SHA_224.hashTypeNameResId).equals(data)) {
            return SHA_224;
        } else if (context.getString(SHA_256.hashTypeNameResId).equals(data)) {
            return SHA_256;
        } else if (context.getString(SHA_384.hashTypeNameResId).equals(data)) {
            return SHA_384;
        } else if (context.getString(SHA_512.hashTypeNameResId).equals(data)) {
           return SHA_512;
        }
        return MD5;
    }

    @Override
    public int getTitleTextResId() {
        return hashTypeNameResId;
    }

    @Override
    public int getPrimaryIconResId() {
        return -1;
    }

    @Override
    public int getAdditionalIconResId() {
        return R.drawable.ic_done;
    }

}
