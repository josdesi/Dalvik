package dalvik.com.mx.shopcart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
