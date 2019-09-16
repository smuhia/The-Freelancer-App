package com.muhia.thefreelancer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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

public class SignupActivity extends AppCompatActivity {
    EditText mail,pass;
    ImageButton btnSign,tvsign;
    FirebaseAuth mFirebaseauth;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseauth= FirebaseAuth.getInstance();
        mail=findViewById(R.id.edtemail);
        pass= findViewById(R.id.edtpass);
        btnSign=findViewById(R.id.btnsign);
        tvsign=findViewById(R.id.txtsignup);
        dialog= new ProgressDialog(this);
        dialog.setTitle("Creating Account");
        dialog.setMessage("Please wait ..");



        btnSign.setOnClickListener(new View.OnClickListener() {
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

                }else if (password.length() < 6){

                    pass.setError("password must be 6 characters or more ");
                    pass.requestFocus();
                }
                else {
                    mFirebaseauth.createUserWithEmailAndPassword(email,password)

                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.show();
                            if (!task.isSuccessful()){
                                Toast.makeText(SignupActivity.this, "Sign Up Failed Password must be 6 characters or more", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                            else {
                                Intent intlog = new Intent(SignupActivity.this, Home_Activity.class);
                                startActivity(intlog);
                                finish();
                            }

                        }
                    });

                }


            }
        });

        tvsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this,LogInActivity.class);
                startActivity(i);

            }
        });


    }
}
