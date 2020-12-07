package com.bibliotekUser.UnitTest;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterService {
    int temp=0;
    public void register(final RegisterView view, String email, String password,  String nama) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        final FirebaseUser[] firebaseUsers = new FirebaseUser[1];

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser tempUser = firebaseAuth.getCurrentUser();
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(nama)
                            .build();
                    tempUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            tempUser.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                temp = 1;
                                                view.startLoginActivity();
                                            }
                                        }
                                    });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
                } else {
                    temp = 0;

                }
            }
        });

    }

    public Boolean getValid (final RegisterView view, String email, String password, String nama){
        final Boolean[] bool = new Boolean[1];
        register(view,email,password,nama);
        if (temp == 1 ){
            bool[0] = true;
        } else {
            bool[0] = false;
        }
        return bool[0];
    }
}
