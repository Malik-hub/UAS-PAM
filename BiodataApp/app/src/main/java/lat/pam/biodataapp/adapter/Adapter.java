package lat.pam.biodataapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lat.pam.biodataapp.R;
import lat.pam.biodataapp.model.Data;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;

    public Adapter(Activity activity, List<Data> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater != null){
            view = inflater.inflate(R.layout.lists_biodata,null);
        }
        if (view != null){
            TextView name = view.findViewById(R.id.text_name);
            TextView email = view.findViewById(R.id.text_email);
            Data data =lists.get(i);
            name.setText(data.getName());
            email.setText(data.getEmail());
        }
        return view;
    }
}
