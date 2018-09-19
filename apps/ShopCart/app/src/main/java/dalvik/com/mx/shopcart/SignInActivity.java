package dalvik.com.mx.shopcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignInActivity extends AppCompatActivity {

    private TextView mTextView;


    DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRootChild = mDatabaseReference.child("texto");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mTextView = findViewById( R.id.txtMsg );

        init();
    }

    private void init() {

        Button btnSignIn = findViewById(R.id.btnLogin );

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SignInActivity.this, HomeActivity.class );
                startActivity( intent );
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();

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
