package com.example.dialogforalert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = getBuilder();
        myAlertBuilder.setNegativeButton("Cancel", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // L'utilisateur a annulé la boîte de dialogue.
                        Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        // Créer et afficher l'AlertDialog.
        myAlertBuilder.show();
    }

    private AlertDialog.@NonNull Builder getBuilder() {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:");
        // Ajouter les boutons de dialogue.
        myAlertBuilder.setPositiveButton("OK", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // L'utilisateur a cliqué sur le bouton OK.
                        Toast.makeText(getApplicationContext(), "Pressed OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        return myAlertBuilder;
    }
}