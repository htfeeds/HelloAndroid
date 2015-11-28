package com.htf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.htf.hello.R;
import com.htf.utils.User;

import java.util.List;

/**
 * Created by htf52 on 28-Nov-15.
 */
public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> users;

    public UserAdapter(Context context, int resource, List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users = objects;
    }

    public UserAdapter(Context context, int resource, int textViewResourceId, List<User> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.users = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.user_list_item, parent, false);

        TextView txvUsername = (TextView) rowView.findViewById(R.id.txvUsername);
        TextView txvEmail = (TextView) rowView.findViewById(R.id.txvEmail);
        TextView txvName = (TextView) rowView.findViewById(R.id.txvName);

        txvUsername.setText(users.get(position).getUsername());
        txvEmail.setText(users.get(position).getEmail());
        txvName.setText("FullName: " + users.get(position).getFullname());

        return rowView;
    }
}
