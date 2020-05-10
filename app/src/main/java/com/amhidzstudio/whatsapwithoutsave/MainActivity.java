package com.amhidzstudio.whatsapwithoutsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button kirim;
    EditText pesan,nomer;
    String no,isipesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        send();
    }

    private void send() {
        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              listening();
              sendMessage();
            }
        });
    }

    private void sendMessage() {
        if (no.isEmpty()) {
            Toast.makeText(MainActivity.this,"Number is empty",Toast.LENGTH_SHORT).show();
        }else {
            intentfunc();
        }

    }

    private void intentfunc() {
        try {
            texttfieldempty();

//            String mobile = "0892131293";
//            String msg = "message";

            String mobile = "+"+no;
            String msg = isipesan;

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + mobile + "&text=" + msg)));
        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Sorry, Whatsapp not found.",Toast.LENGTH_SHORT).show();
        }
    }

    private void texttfieldempty() {
        if (isipesan.isEmpty()) {
            isipesan="";
        }
    }

    private void listening() {
         no = String.valueOf(nomer.getText());
         isipesan = String.valueOf(pesan.getText());
    }

    private void init() {
        kirim=findViewById(R.id.btn_send);
        nomer=findViewById(R.id.editText);
        pesan=findViewById(R.id.editText2);
    }
}
