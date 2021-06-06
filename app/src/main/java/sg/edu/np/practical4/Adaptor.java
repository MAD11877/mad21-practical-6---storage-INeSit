package sg.edu.np.practical4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<ViewHolder> {
    //Bare minimum to get the RecyclerView to work
    ArrayList<User> data;
    Activity mActivity;
    Context mContext;
    public Adaptor(ArrayList<User> input) {

        data = input;
    }
    //Creates ViewHolder

    //To identify that ViewHolder is created on Main Activity Page

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if(viewType == 0){
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        }
        return new ViewHolder(item);


    }

    //Bind Data to ViewHolder created on Main Activity Page
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user_items = data.get(position);
        if(holder.getItemViewType() == 0){
            holder.txt.setText("Name: " + user_items.getName() + " ID: " + user_items.getId());
            holder.txt2.setText("Description: " + user_items.getDescription() + " Followed: " + user_items.getFollowed());
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("Profile");
                    builder.setMessage(user_items.getName()).setCancelable(false);
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            v.getContext().startActivity(new Intent(v.getContext(), MainActivity2.class).putExtra("User",user_items));
                            //mActivity.startActivity(intent);
                            //intent.putExtra("User", user_items);

                        }

                    });
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });

        }
        else{
            holder.txt3.setText(user_items.getName());
            holder.txt4.setText(user_items.getDescription());
            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("Profile");
                    builder.setMessage(user_items.getName()).setCancelable(false);
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            v.getContext().startActivity(new Intent(v.getContext(), MainActivity2.class).putExtra("User",user_items));
                            //Intent intent = new Intent(mActivity, MainActivity2.class);
                            //mActivity.startActivity(intent);
                            //intent.putExtra("User", user_items);


                        }

                    });
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });

        }
    }



    public int getItemCount() {

        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        User u = data.get(position);
        String name = u.getName();
        char lastNum = name.charAt(name.length()-1);
        if(lastNum != '7'){
            return 0;
        }
        else{
            return 2;
        }

    }

    public void profileAlert(int position){
        User user_items = data.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Profile");
        builder.setMessage(user_items.getName()).setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(mActivity, MainActivity2.class);
                mActivity.startActivity(intent);
                //intent.putExtra("User", user_items);


            }

        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

