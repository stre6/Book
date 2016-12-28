package com.kaka.book;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by stre6 on 2016-12-28.
 */

public class Login extends AppCompatActivity {
    Button login, join;
    EditText id, pw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = (Button) findViewById(R.id.lgbtn);
        join = (Button) findViewById(R.id.sigbtn);
        id = (EditText) findViewById(R.id.login);
        pw = (EditText) findViewById(R.id.password);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, Join.class);
                startActivity(in);
            }
        });
    }

    public void login(View v) {
        String ida = id.getText().toString();
        String pa = pw.getText().toString();
        String name = null;
        String gra = null;
        String res = "";

        LC lc = new LC();
        lc.ch(ida, pa, name, gra);
        res = lc.getres();

        if (res.equals("SU")) {
            id.setText("");
            pw.setText("");
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Login.this, Yayak.class);
            startActivity(i);
        } else if (res.equals("fail")) {
            id.setText("");
            pw.setText("");
            Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(ida) || TextUtils.isEmpty(pa)) {
            Toast.makeText(this, "ID와 PW를 입력하세요", Toast.LENGTH_SHORT).show();
        }
    }
}
