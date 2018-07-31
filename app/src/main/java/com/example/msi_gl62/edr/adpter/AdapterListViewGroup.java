package com.example.msi_gl62.edr.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msi_gl62.edr.R;
import com.example.msi_gl62.edr.model.ModelAdviserGroupList;

import java.util.ArrayList;

public class AdapterListViewGroup extends ArrayAdapter<ModelAdviserGroupList> implements View.OnClickListener{

    private ArrayList<ModelAdviserGroupList> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
    }

    public  AdapterListViewGroup(ArrayList<ModelAdviserGroupList> data, Context context) {
        super(context, R.layout.item_grouplist, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        ModelAdviserGroupList dataModel=(ModelAdviserGroupList) object;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelAdviserGroupList dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_grouplist, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtType.setText(dataModel.getTeaching_level_name()+"/"+dataModel.getEntry_type()+"/"+dataModel.getStudy_group()+" "+dataModel.getEntry_type_name()+"/"+dataModel.getDescriptions());


        return convertView;
    }}
