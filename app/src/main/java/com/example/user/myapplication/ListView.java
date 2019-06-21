package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    MyAdapter mAdapter=null;
    RecyclerView mRecyclerView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

// OBJECT CALLING

        mAdapter = new MyAdapter(constant.STUDENTaRRA);
        mRecyclerView.setAdapter(mAdapter);
    }



    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private ArrayList<student> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public  class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView tv_id;
            public TextView tv_name;
            public TextView tv_age;
            public TextView tv_address;
            public LinearLayout studentlist;


            public MyViewHolder(View v) {
                super(v);
                tv_id = (TextView) v.findViewById(R.id.tv_id);
                tv_name = (TextView) v.findViewById(R.id.tv_name);
                tv_age = (TextView) v.findViewById(R.id.tv_age);
                tv_address = (TextView) v.findViewById(R.id.tv_address);
                studentlist = (LinearLayout) v.findViewById(R.id.studentlist);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter( ArrayList<student> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            /*TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.studentlistelemence, parent, false);*/
            LayoutInflater inflate = LayoutInflater.from(parent.getContext());
            View v =inflate.inflate(R.layout.studentlistelemence, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            //System.out.println(" icame "+ mDataset.get(position).getName());
            holder.tv_id.setText(mDataset.get(position).getId());
            holder.tv_name.setText(mDataset.get(position).getName());
            holder.tv_age.setText(""+mDataset.get(position).getAge());
            holder.tv_address.setText(mDataset.get(position).getAddress());
            holder.studentlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ListView.this, VideoStreeming.class);
                    i.putExtra(constant.ID,mDataset.get(position).getId());
                    i.putExtra(constant.NAME,mDataset.get(position).getName());
                    i.putExtra(constant.AGE,mDataset.get(position).getAge());
                    i.putExtra(constant.ADDRESS,mDataset.get(position).getAddress());
                    i.putExtra(constant.VIDEO,mDataset.get(position).getVideo());
                    startActivity(i);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }


    }

}
