package sg.edu.np.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent receivedData = getIntent();

        User u = (User) receivedData.getParcelableExtra("User");

        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button2);

        if(u.getFollowed() == false){
            button.setText("Follow");
        }
        else{
            button.setText("Unfollow");
        }


        button1.setText("Message");
        TextView Name = findViewById(R.id.textView2);
        Name.setText(u.getName());

        TextView Desc = findViewById(R.id.textView3);
        Desc.setText(u.getDescription());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (u.getFollowed() == Boolean.FALSE) {
                    button.setText("UnFollow");
                    u.setFollowed(Boolean.TRUE);
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                    dbHandler.updateUser(u);

                }
                else{
                    button.setText("Follow");
                    u.setFollowed(Boolean.FALSE);
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                    dbHandler.updateUser(u);
                }

            }
        });


    }


}