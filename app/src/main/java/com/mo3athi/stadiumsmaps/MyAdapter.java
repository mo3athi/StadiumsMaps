package com.mo3athi.stadiumsmaps;

/**
 * Created by Mo3athi on 9/20/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {


  private ArrayList<StadiumModel> filteredList;
  private ArrayList<StadiumModel> stadiums;

  public MyAdapter(ArrayList<StadiumModel> stadiumModels) {
    stadiums = stadiumModels;
    filteredList = stadiumModels;
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.stadium_card, parent, false);

    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textViewName.setText(filteredList.get(position).getName());
    holder.fee.setText(filteredList.get(position).getFee());
    holder.hours.setText(filteredList.get(position).getHours());
  }

  @Override
  public int getItemCount() {
    return filteredList.size();
  }

  @Override
  public Filter getFilter() {

    return new Filter() {
      @Override
      protected FilterResults performFiltering(CharSequence charSequence) {

        String charString = charSequence.toString();

        if (charString.isEmpty()) {

          filteredList = stadiums;
        } else {

          ArrayList<StadiumModel> filtdList = new ArrayList<>();

          for (StadiumModel stdms : stadiums) {

            if (stdms.getName().toLowerCase().contains(charString)) {

              filtdList.add(stdms);
            }
          }

          filteredList = filtdList;
        }

        FilterResults filterResults = new FilterResults();
        filterResults.values = filteredList;
        return filterResults;
      }

      @Override
      protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        filteredList = (ArrayList<StadiumModel>) filterResults.values;
        notifyDataSetChanged();
      }
    };
  }

  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView textViewName, hours, fee;
    private Context context;

    ViewHolder(View itemView) {
      super(itemView);

      textViewName = itemView.findViewById(R.id.textViewName);
      hours = itemView.findViewById(R.id.tv_hours);
      fee = itemView.findViewById(R.id.tv_fee);
      context = itemView.getContext();
      itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
      int position = getAdapterPosition(); // gets item position
      if (position
          != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
        // We can access the data within the views
        Intent intent = new Intent(itemView.getContext(), MapsActivity.class);
        intent.putExtra("lat", filteredList.get(position).getLat());
        intent.putExtra("lng", filteredList.get(position).getLng());
        intent.putExtra("name", filteredList.get(position).getName());
        context.startActivity(intent);
      }
    }
  }
}