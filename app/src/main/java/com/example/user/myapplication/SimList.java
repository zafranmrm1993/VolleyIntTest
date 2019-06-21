package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SimList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_list);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private ArrayList<student> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public  class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView txt_view_id;
            public TextView txt_view_iccid;
            public TextView txt_view_expiredate;
            public TextView txt_view_sp;
            public LinearLayout simlistview;

            public MyViewHolder(View v) {
                super(v);
                txt_view_id = (TextView) v.findViewById(R.id.txt_view_id);
                txt_view_iccid = (TextView) v.findViewById(R.id.txt_view_iccid);
                txt_view_expiredate = (TextView) v.findViewById(R.id.txt_view_expiredate);
                txt_view_sp = (TextView) v.findViewById(R.id.txt_view_sp);
                simlistview = (LinearLayout) v.findViewById(R.id.simlistview);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter( ArrayList<student> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
            // create a new view
            /*TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.studentlistelemence, parent, false);*/
            LayoutInflater inflate = LayoutInflater.from(parent.getContext());
            View v =inflate.inflate(R.layout.studentlistelemence, parent, false);
            MyAdapter.MyViewHolder vh = new MyAdapter.MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            //System.out.println(" icame "+ mDataset.get(position).getName());
            holder.txt_view_id.setText(mDataset.get(position).getId());
            holder.txt_view_iccid.setText(mDataset.get(position).getName());
            holder.txt_view_expiredate.setText(""+mDataset.get(position).getAge());
            holder.txt_view_sp.setText(mDataset.get(position).getAddress());
            holder.simlistview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }


    }
}
