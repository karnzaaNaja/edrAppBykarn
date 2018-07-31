package com.example.msi_gl62.edr.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.msi_gl62.edr.R;
import com.example.msi_gl62.edr.model.ModelTimeTableDashboard;
import java.util.ArrayList;

public class AdapterTableDashboard extends ArrayAdapter<ModelTimeTableDashboard> implements View.OnClickListener{

    private ArrayList<ModelTimeTableDashboard> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtSubject;
    }

    public  AdapterTableDashboard(ArrayList<ModelTimeTableDashboard> data, Context context) {
        super(context, R.layout.item_grouplist, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        ModelTimeTableDashboard dataModel=(ModelTimeTableDashboard) object;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelTimeTableDashboard dataModel = getItem(position);
        AdapterTableDashboard .ViewHolder viewHolder;
        final View result;
        if (convertView == null) {

            viewHolder = new AdapterTableDashboard .ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_table_dashboard, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtSubject=(TextView) convertView.findViewById(R.id.subject);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AdapterTableDashboard .ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtType.setText(dataModel.getGroup_name());
        viewHolder.txtSubject.setText(dataModel.getSubject_name());

        return convertView;
    }}
