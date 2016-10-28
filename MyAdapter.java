package com.example.banner.recyclerradio;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Banner on 10/22/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<RadioModel> list;

    HashMap<Integer,Integer> SelectedAnswerList = new HashMap<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cd_radio,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RadioModel radioModel=list.get(position);

        MyViewHolder myViewHolder=(MyViewHolder)holder;

        myViewHolder.rbtGroup.clearCheck();

        myViewHolder.rbt1.setText(radioModel.getSelect1());
        myViewHolder.rbt2.setText(radioModel.getSelect2());
        myViewHolder.rbt3.setText(radioModel.getSeclect3());
        myViewHolder.rbt4.setText(radioModel.getSelect4());

        if(SelectedAnswerList.containsKey(position)){
            Log.i("find selected position ",""+position);
            myViewHolder.rbtGroup.check(SelectedAnswerList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public MyAdapter(List<RadioModel> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        RadioButton rbt1,rbt2,rbt3,rbt4;
        RadioGroup rbtGroup;
        public MyViewHolder(View itemView) {
            super(itemView);
            rbtGroup = (RadioGroup) itemView.findViewById(R.id.rbtgroup);
            rbt1=(RadioButton)itemView.findViewById(R.id.rbt_select1);
            rbt2=(RadioButton)itemView.findViewById(R.id.rbt_select2);
            rbt3=(RadioButton)itemView.findViewById(R.id.rbt_select3);
            rbt4=(RadioButton)itemView.findViewById(R.id.rbt_select4);

            View.OnClickListener l=new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //rbtGroup.clearCheck();
                    SelectedAnswerList.put(getAdapterPosition(), view.getId());
                    Log.i("get Click Key - " + getAdapterPosition(),""+view.getId());
                }
            };

            rbt1.setOnClickListener(l);
            rbt2.setOnClickListener(l);
            rbt3.setOnClickListener(l);
            rbt4.setOnClickListener(l);

        }
    }
}
