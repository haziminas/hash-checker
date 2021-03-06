package com.smlnskgmail.jaman.hashchecker.generator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

public class HashGenerator extends AsyncTask<Void, Void, Void> {

    @SuppressLint("StaticFieldLeak") private Context context;
    private HashCalculator.OnHashGeneratorCompleteListener onCompleteListener;
    private Uri fileUri;
    private String textValue, result;
    private HashTypes hashTypes;

    private boolean isText;

    private HashGenerator(@NonNull HashTypes hashTypes, @NonNull Context context,
                          @NonNull HashCalculator.OnHashGeneratorCompleteListener onCompleteListener,
                          boolean isText) {
        this.hashTypes = hashTypes;
        this.context = context;
        this.onCompleteListener = onCompleteListener;
        this.isText = isText;
    }

    public HashGenerator(@NonNull HashTypes hashTypes, @NonNull Context context, @NonNull Uri fileUri,
                         @NonNull HashCalculator.OnHashGeneratorCompleteListener onCompleteListener,
                         boolean isText) {
        this(hashTypes, context, onCompleteListener, isText);
        this.fileUri = fileUri;
    }

    public HashGenerator(@NonNull HashTypes hashTypes, @NonNull Context context, @NonNull String textValue,
                         @NonNull HashCalculator.OnHashGeneratorCompleteListener onCompleteListener,
                         boolean isText) {
        this(hashTypes, context, onCompleteListener, isText);
        this.textValue = textValue;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        HashTypes hashType = HashTypes.MD5;
        switch (hashTypes) {
            case SHA_1:
                hashType = HashTypes.SHA_1;
                break;
            case SHA_224:
                hashType = HashTypes.SHA_224;
                break;
            case SHA_256:
                hashType = HashTypes.SHA_256;
                break;
            case SHA_384:
                hashType = HashTypes.SHA_384;
                break;
            case SHA_512:
                hashType = HashTypes.SHA_512;
                break;
        }
        String hashTypeAsString = hashType.getTypeAsString(context);
        if (isText) {
            result = new HashCalculator(hashTypeAsString).generateFromString(textValue);
        } else {
            result = new HashCalculator(hashTypeAsString).generateFromFile(context, fileUri);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        onCompleteListener.onHashGeneratorComplete(result);
    }

}
