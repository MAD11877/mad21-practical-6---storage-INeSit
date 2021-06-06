package sg.edu.np.practical4;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder  {
    TextView txt;
    TextView txt2;
    ImageView img;

    ImageView img2;
    TextView txt3;
    TextView txt4;

    //Binds the data to the TextView on the recycler_view_item.xl file
    public ViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.textView);
        txt2 = itemView.findViewById(R.id.textView2);
        img = itemView.findViewById(R.id.imageView);

        img2 = itemView.findViewById(R.id.imageView5);
        txt3 = itemView.findViewById(R.id.textView6);
        txt4 = itemView.findViewById(R.id.textView7);



    }
}





