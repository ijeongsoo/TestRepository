package com.mycompany.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


/**
 * Created by ijeongsu on 2017. 7. 4..
 */

public class CustomDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view =inflater.inflate(R.layout.fragment_custom_dialog, null);
        Button btnLogin =(Button) view.findViewById(R.id.btnLogin);
        Button btnCancel =(Button) view.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("로그인")
                .setView(view)
                .create();

        return dialog;
    }


}
