package com.example.booknotesapplication;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.booknotesapplication.Books_List;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class firebase {
    private FirebaseAuth mAuth;
    private Context ctx;

    public firebase(Context ctx) {
        mAuth = FirebaseAuth.getInstance();
        this.ctx = ctx;
    }
    public void Signup(String email, String password){

        mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(ctx, "Account Created", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void Login(String email,String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent i = new Intent(ctx, Books_List.class);
                ctx.startActivity(i);
            }
        });
    }
    public void CheckSession(){
        if(mAuth.getCurrentUser() != null){
            Intent i = new Intent(ctx, Books_List.class);
            ctx.startActivity(i);
        }
    }
}

