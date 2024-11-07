package com.example.jobizz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    TextView textView, textViewError;
    private TextInputEditText tiet_reg_fname, tiet_reg_email, tiet_reg_passw1, tiet_reg_passw2;
    Button btnRegister;
    String name, email, password;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView = findViewById(R.id.tv_reg1);

        Spannable text1 = new SpannableString("Have an account? ");
        text1.setSpan(new ForegroundColorSpan(Color.DKGRAY),0, text1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(text1);

        Spannable text2 = new SpannableString("Log in");
        text2.setSpan(new ForegroundColorSpan(Color.GREEN), 0, text2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(text2);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), login.class));
                finish();
            }
        });

        tiet_reg_fname = findViewById(R.id.tiet_reg_fname);
        tiet_reg_email = findViewById(R.id.tiet_reg_email);
        tiet_reg_passw1 = findViewById(R.id.tiet_reg_passw1);
        tiet_reg_passw2 = findViewById(R.id.tiet_reg_passw2);
        btnRegister = findViewById(R.id.btn_reg);
        textViewError = findViewById(R.id.tv_reg_error);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewError.setVisibility(View.GONE);
                name = String.valueOf(tiet_reg_fname.getText());
                email = String.valueOf(tiet_reg_email.getText());
                password = String.valueOf(tiet_reg_passw1.getText());

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="https://localhost/192.168.100.5/jobizzphp/api_register.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //textView.setText("Response is: "+ response);
                                if(response.equals("berhasil")) {
                                    Toast.makeText(getApplicationContext(), "Register berhasi", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), login.class));
                                    finish();
                                } else {
                                    textViewError.setText(response);
                                    textViewError.setVisibility(View.VISIBLE);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //textView.setText("That didn't work!");
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("name", name);
                        paramV.put("email", email);
                        paramV.put("password", password);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });







    }
}