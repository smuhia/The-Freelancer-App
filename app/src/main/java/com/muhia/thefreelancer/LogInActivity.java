package com.muhia.thefreelancer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    EditText mail,pass;
    ImageButton btnlog,tvlog;
    FirebaseAuth mFirebaseauth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseauth= FirebaseAuth.getInstance();
        mail=findViewById(R.id.edtemail);
        pass= findViewById(R.id.edtpass);
        btnlog=findViewById(R.id.btnsign);
        tvlog=findViewById(R.id.txtsignup);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Logging in");
        dialog.setMessage("Please wait ...");

        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser= mFirebaseauth.getCurrentUser();



            }
        };
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mail.getText().toString();
                String password = pass.getText().toString();

                //check if submitting empty fields

                if (email.isEmpty()){
                    mail.setError("Please Enter Email");
                    mail.requestFocus();
                }
                else if (password.isEmpty()){
                    pass.setError("Please Enter Password ");
                    pass.requestFocus();

                }
                else {
                    mFirebaseauth.signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.show();
                            if (!task.isSuccessful()){
                                Toast.makeText(LogInActivity.this, "Log In Error  , Please Log In Again", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                            else {
                                Intent inthome= new Intent(LogInActivity.this, Home_Activity.class);
                                startActivity(inthome);
                                finish();
                            }

                        }
                    });

                }


            }

            });
        tvlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intsign = new Intent(LogInActivity.this,SignupActivity.class);
                startActivity(intsign);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseauth.addAuthStateListener(mAuthListener);
    }
}
