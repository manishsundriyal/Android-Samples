package com.example.harsh.dialogfragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        Dialog dialog=builder.create();


        return dialog;
    }

}
