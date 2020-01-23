package com.example.hcicoolexample;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> implements Filterable{
    Context context;
    ArrayList<MyDoes> myDoes;
    ArrayList<MyDoes> originalDoes;
    boolean compactView;

    Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            ArrayList<MyDoes> tempList=new ArrayList<MyDoes>();
            //constraint is the result from text you want to filter against.
            //objects is your data set you will filter from
            if(constraint != null && myDoes!=null && constraint.length() > 0) {
                int length=originalDoes.size();
                int i=0;
                constraint = constraint.toString().toLowerCase();
                while(i<length){
                    MyDoes item=originalDoes.get(i);
                    //do whatever you wanna do here
                    //adding result set output array
                    if(item.getCompany().toLowerCase().contains(constraint) || item.getTags().toLowerCase().contains(constraint) || item.getLocation().toLowerCase().contains(constraint) || item.getPosition().toLowerCase().contains(constraint)) {
                        tempList.add(item);
                    }

                    i++;
                }
                //following two lines is very important
                //as publish result can only take FilterResults objects
                filterResults.values = tempList;
                filterResults.count = tempList.size();
                return filterResults;
            }
            else {
                filterResults.values = originalDoes;
                filterResults.count = originalDoes.size();
                return filterResults;
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence contraint, FilterResults results) {
            myDoes = (ArrayList<MyDoes>) results.values;
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    public DoesAdapter(Context c, ArrayList<MyDoes> p, boolean compact){
        context = c;
        myDoes = p;
        originalDoes = myDoes;
        compactView = compact;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        if(compactView) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does , viewGroup, false));
        }
        else {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_doesexpanded , viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i){
        myViewHolder.titledoes.setText(myDoes.get(i).getPosition());
        myViewHolder.descdoes.setText(myDoes.get(i).getCompany());
        myViewHolder.datedoes.setText(myDoes.get(i).getStatus());

        if(!compactView) {
            myViewHolder.tagsdoes.setText(myDoes.get(i).getTags());
            myViewHolder.locationdoes.setText(myDoes.get(i).getLocation());
            myViewHolder.dateRem.setText(myDoes.get(i).getDate());
        }

        final String getItemType = myDoes.get(i).getItemType();
        final String getPosition = myDoes.get(i).getPosition();
        final String getCompany = myDoes.get(i).getCompany();
        final String getLocation = myDoes.get(i).getLocation();
        final String getDate = myDoes.get(i).getDate();
        final String getStatus = myDoes.get(i).getStatus();
        final String getTags = myDoes.get(i).getTags();
        final String getNotes = myDoes.get(i).getNotes();
        final int pos = i;

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent aa = new Intent(context, EditTaskDesk.class);
                aa.putExtra("itemType", getItemType);
                aa.putExtra("position", getPosition);
                aa.putExtra("company", getCompany);
                aa.putExtra("location", getLocation);
                aa.putExtra("date", getDate);
                aa.putExtra("status", getStatus);
                aa.putExtra("tags", getTags);
                aa.putExtra("notes", getNotes);
                aa.putExtra("Position", pos);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount(){
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titledoes;
        TextView descdoes;
        TextView datedoes;
        TextView dateRem;
        TextView locationdoes;
        TextView tagsdoes;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            //this is based on the "item_does.xml" file.
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
            dateRem = (TextView) itemView.findViewById(R.id.dateRem);
            locationdoes = (TextView) itemView.findViewById(R.id.locationdoes);
            tagsdoes = (TextView) itemView.findViewById(R.id.tagsDoes);
        }
    }
}
