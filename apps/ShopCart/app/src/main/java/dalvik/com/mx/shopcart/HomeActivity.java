package dalvik.com.mx.shopcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }



    private void init() {

        Button btnLogOut = findViewById(R.id.btnLogOut );

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

                Log.d(TAG,"SignOut");
                Toast.makeText( HomeActivity.this, "SignOut", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( HomeActivity.this, SignInActivity.class );
                startActivity( intent );
            }
        });
    }
}
