package dalvik.com.mx.shopcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "SignIn";
    private TextView mTextView;
    private TextView txtEmail;
    private TextView txtPasswd;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRootChild = mDatabaseReference.child("texto");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mTextView = findViewById( R.id.txtMsg );
        txtEmail = findViewById( R.id.txtEmail ) ;
        txtPasswd = findViewById( R.id.txtPasswd );
        mAuth = FirebaseAuth.getInstance();


        mAuthStateListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if( firebaseAuth.getCurrentUser()!= null ) {
                    Intent intent = new Intent( SignInActivity.this, HomeActivity.class );
                    startActivity( intent );
                }
            }
        };




        init();
    }

    private void init() {

        Button btnSignIn = findViewById(R.id.btnLogin );

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email = txtEmail.getText().toString();
        String passwd = txtPasswd.getText().toString();

        // Validations
        if( email.equals("") || passwd.equals("") ) return;

        mAuth.signInWithEmailAndPassword( email, passwd )
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if( task.isSuccessful() ){
                        Log.d(TAG,"signInWithEmailAndPassword: success");
                        FirebaseUser user = mAuth.getCurrentUser();
                    }
                    else {
                        Log.d(TAG,"signInWithEmailAndPassword: failed");
                        Toast.makeText( SignInActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    @Override
    protected void onStart() {

        super.onStart();

        mAuth.addAuthStateListener( mAuthStateListener );

        mRootChild.child("nodo").setValue( "New Text " );

        Map<String, Object> datos = new HashMap<>();
        datos.put("nombre","Robert");
        datos.put("apellido","Mendez");
        datos.put("telefono","5538780976");
        datos.put("direccion","nte 11");
        datos.put("email","robert@hotmail.com");

        mDatabaseReference.child("usuario").setValue( datos );

        mRootChild.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                mTextView.setText( text );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
