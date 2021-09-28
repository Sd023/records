package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.records.R;

public class CustomAdapter  extends BaseAdapter {

    Context context;
    String [] itemName;
    int[] images;
    LayoutInflater layoutInflater;
    public CustomAdapter(Context context, String[] itemName, int[] images) {
        this.context = context;
        this.itemName = itemName;
        this.images = images;
    }

    @Override
    public int getCount() {
        return itemName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(layoutInflater == null)
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            view = layoutInflater.inflate(R.layout.grid_items,null);
        }
        ImageView imageView = view.findViewById(R.id.item_image);
        TextView textView = view.findViewById(R.id.image_name);
        imageView.setImageResource(images[i]);
        textView.setText(itemName[i]);

        return view;
    }
}
