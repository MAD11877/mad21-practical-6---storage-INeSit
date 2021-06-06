package sg.edu.np.practical4;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> userList = new ArrayList<>();
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User u1 = new User("Name 162666887", "Description 838837177", 1, true);
        dbHandler.addUser(u1);

        User u2 = new User("Name 188447711","Description 18838134",2,false);
        dbHandler.addUser(u2);

        User u3 = new User("Name 677329392","Description 59698848",3,false);
        dbHandler.addUser(u3);

        User u4 = new User("Name 959282888","Description 145772994",4,true);
        dbHandler.addUser(u4);

        User u5 = new User("Name 472742667","Description 245675773",5,false);
        dbHandler.addUser(u5);

        User u6 = new User("Name 834888883","Description 143424564",6,false);
        dbHandler.addUser(u6);

        User u7 = new User("Name 005487472","Description 424556576",7,false);
        dbHandler.addUser(u7);

        User u8 = new User("Name 677452435","Description 132244456",8,true);
        dbHandler.addUser(u8);

        User u9 = new User("Name 858747752","Description 434356756",9,false);
        dbHandler.addUser(u9);

        User u10 = new User("Name 77137137","Description 773773993",10,true);
        dbHandler.addUser(u10);

        User u11 = new User("Name 55656523", "Description 245456562", 11, true);
        dbHandler.addUser(u11);

        User u12 = new User("Name 246667676","Description 56567676",12,false);
        dbHandler.addUser(u12);

        User u13 = new User("Name 45466292","Description 45635676",13,false);
        dbHandler.addUser(u13);

        User u14 = new User("Name 456678798","Description 23455565",14,true);
        dbHandler.addUser(u14);

        User u15 = new User("Name 12343567","Description 12233232",15,false);
        dbHandler.addUser(u15);

        User u16 = new User("Name 38288283","Description 994723772",16,false);
        dbHandler.addUser(u16);

        User u17 = new User("Name 48858992","Description 323242442",17,false);
        dbHandler.addUser(u17);

        User u18 = new User("Name 96050388","Description 132324456",18,true);
        dbHandler.addUser(u18);

        User u19 = new User("Name 58488999","Description 44455888",19,false);
        dbHandler.addUser(u19);

        User u20 = new User("Name 758488923","Description 424242323",20,true);
        dbHandler.addUser(u20);







        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Adaptor mAdaptor = new Adaptor(userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdaptor);

    }

}