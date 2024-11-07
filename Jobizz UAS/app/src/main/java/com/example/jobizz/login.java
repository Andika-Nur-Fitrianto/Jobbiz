package com.example.jobizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    TextView textViewFgtPass, textViewRegister, textViewLoginError;
    TextInputEditText textEmail, textPass;
    Button btnLogin;
    String email, password, nama, apikey, id, jr;
    //, jr, tgl_lahir, ed, ex;
//    String cv1_tv_jobrole, cv1_tv_comp, cv1_tv_jobtype, cv1_tv_jobtime, cv1_tv_junior,
//            cv1_tv_location, cv1_tv_salary;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("Jobizz App.", MODE_PRIVATE);
        textViewFgtPass = findViewById(R.id.tv_fgt_pass);
        textViewFgtPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), lupa_pass.class));
                finish();
            }
        });

        textViewRegister = findViewById(R.id.tv_login_reg);
        textViewLoginError = findViewById(R.id.tv_login_error);

        Spannable text1 = new SpannableString("Haven't an account? ");
        text1.setSpan(new ForegroundColorSpan(Color.DKGRAY),0, text1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewRegister.setText(text1);

        Spannable text2 = new SpannableString("Register");
        text2.setSpan(new ForegroundColorSpan(Color.GREEN), 0, text2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewRegister.append(text2);

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), register.class));
                finish();
            }
        });

        textEmail = findViewById(R.id.tiet_login_email);
        textPass = findViewById(R.id.tiet_login_passw);
        btnLogin = findViewById(R.id.btn_login);

        if(sharedPreferences.getString("logged", "false").equals("true")){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textViewLoginError.setVisibility(View.VISIBLE);
                email = String.valueOf(textEmail.getText());
                password = String.valueOf(textPass.getText());

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.100.5/jobizzphp/api_login.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //textViewLoginError.setText("Response is: "+ response);
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String status = jsonObject.getString("status");
                                    String message = jsonObject.getString("message");
                                    //optional untuk tes
                                    //textViewLoginError.setText(response);
                                    //textViewLoginError.setVisibility(View.VISIBLE);
                                    //Log.v("jobizz", response);
                                    //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    //finish();

                                    if(status.equals("sukses")) {
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        //ambil data dari Json
                                        nama = jsonObject.getString("nama");
                                        email = jsonObject.getString("email");
                                        apikey = jsonObject.getString("apikey");
                                        id = jsonObject.getString("id");
                                        jr = jsonObject.getString("jr");

                                        editor.putString("logged", "true");
                                        editor.putString("nama", nama);
                                        editor.putString("email", email);
                                        editor.putString("apikey", apikey);
                                        editor.putString("id", id);
                                        editor.putString("jr", jr);
//                                        if(jr.equals("") || ed.equals("") || ex.equals("")) {
//                                        } else {
//                                            jr = jsonObject.getString("jr");
//                                            ed = jsonObject.getString("ed");
//                                            ex = jsonObject.getString("ex");
//                                            editor.putString("jr", jr);
//                                            editor.putString("ed", ed);
//                                            editor.putString("ex", ex);
//                                        }
                                        editor.apply();
//                                        //Toast.makeText(getApplicationContext(), "Login berhasi", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        finish();
                                    } else {
                                        textViewLoginError.setText(message);
                                        textViewLoginError.setVisibility(View.VISIBLE);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }  , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewLoginError.setText("That didn't work!");
                        textViewLoginError.setVisibility(View.VISIBLE);
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
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