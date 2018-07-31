package com.example.msi_gl62.edr.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.msi_gl62.edr.R;
import com.example.msi_gl62.edr.model.ModelCustomer;
import java.util.ArrayList;

public class AdapterListViewCustomer extends ArrayAdapter<ModelCustomer> implements View.OnClickListener{
    private ArrayList<ModelCustomer> dataSet;
    private int lastPosition = -1;
    Context mContext;
    private static class ViewHolder { TextView txt_customer;}

    public AdapterListViewCustomer(ArrayList<ModelCustomer> data, Context context) {
        super(context, R.layout.item_customer, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        ModelCustomer dataModel=(ModelCustomer)object;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelCustomer dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_customer, parent, false);
            viewHolder.txt_customer = (TextView) convertView.findViewById(R.id.name_customer);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txt_customer.setText(dataModel.getSchool_name_thai());
        return convertView;
    }
}
