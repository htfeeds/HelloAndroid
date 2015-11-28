package com.htf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.htf.hello.R;
import com.htf.utils.Lab;

import java.util.List;

/**
 * Created by htf52 on 19-Nov-15.
 */
public class LabAdapter extends ArrayAdapter<Lab> {
    private Context context;
    private List<Lab> labs;

    public LabAdapter(Context context, int resource, List<Lab> objects) {
        super(context, resource, objects);
        this.context = context;
        this.labs = objects;
    }

    public LabAdapter(Context context, int resource, int textViewResourceId, List<Lab> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.labs = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.lab_list_item, parent, false);

        TextView tvIndex = (TextView) rowView.findViewById(R.id.txvIndex);
        TextView tvTitle = (TextView) rowView.findViewById(R.id.txvLabTitle);
        TextView tvDescription = (TextView) rowView.findViewById(R.id.txvLabDescription);
        TextView tvDifficulty = (TextView) rowView.findViewById(R.id.txvDifficulty);

        tvIndex.setText(position + 1 + ".");
        tvTitle.setText(labs.get(position).getName());
        tvDescription.setText(labs.get(position).getDescription());
        tvDifficulty.setText(labs.get(position).getDifficulty());

        return rowView;
    }
}
