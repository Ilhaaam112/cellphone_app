package com.example.call_phone;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextPhone);
        Button buttonCall = findViewById(R.id.buttonCall);

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhone.getText().toString().trim();

                if (!phoneNumber.isEmpty()) {
                    // Menggunakan implicit intent untuk melakukan panggilan telepon
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(callIntent);

                    // Tampilkan pesan
                    Toast.makeText(MainActivity.this, "Memanggil " + phoneNumber, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Masukkan nomor telepon terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}