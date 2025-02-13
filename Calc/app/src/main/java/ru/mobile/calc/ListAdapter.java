package ru.mobile.calc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private final String [] values;
    private final int [] images;

    public ListAdapter(Context context, String [] values, int [] images){
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_list_item, parent, false);
            viewHolder.catName = (TextView) convertView.findViewById(R.id.catDescT);
            viewHolder.catIcon = (ImageView) convertView.findViewById(R.id.catIconT);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.catName.setText(values[position]);
        viewHolder.catIcon.setImageResource(images[position]);

        return convertView;
    }

    private static class ViewHolder {

        TextView catName;
        ImageView catIcon;

    }

}
