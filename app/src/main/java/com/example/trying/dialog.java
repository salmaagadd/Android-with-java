package com.example.trying;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Info about DR Ahmed Mohamed")
                .setMessage("He graduated from the Faculty of Dentistry at Ain Shams University with distinction" +
                        " with honors, worked as a faculty member at Ain Shams University in the Department" +
                        " of Fixed Prosthodontics and Cosmetic Dentistry, and he is a member of the" +
                        " International Society for Scientific Research in Dentistry and an accredited member" +
                        " of the German Association of Dental Implants\n")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
        return builder.create();
    }
}
