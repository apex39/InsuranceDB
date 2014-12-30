package com.example.mateusz.insurancedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mateusz on 18.08.14.
 */
public class ListsAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> mainObjects;
    List<String> additionalObjects;
    int size;

    public ListsAdapter(Context context, List<String> mainObjects, List<String> additionalObjects) {
       super(context, android.R.layout.simple_list_item_2);
       this.mainObjects = mainObjects;
       this.additionalObjects = additionalObjects;
       this.context = context;
      this.mainObjects.add("xxx");
        this.additionalObjects.add("xxx");
   }

    static class ViewHolder{
        TextView mainText;
        TextView additionalText;
    }

    @Override
    public int getCount() {
            return mainObjects.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            holder.mainText = (TextView) convertView.findViewById(android.R.id.text1);
            holder.additionalText = (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mainText.setText(mainObjects.get(position));
        holder.additionalText.setText(additionalObjects.get(position));

        return convertView;
    }
}
