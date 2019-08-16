package com.example.cricbuzzz.Controler;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cricbuzzz.R;

import java.util.List;


public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MyViewHolder> {

    public List<MatchRow> MatchRowsList;
    ImageView RowImage;
    private onMatchListener onMatchListener;
    TextView MatchDate, TeamMatch;

    private static final String TAG = "MatchAdapter";

    AppCompatActivity activity;

    public MatchAdapter(AppCompatActivity activity_main, List<MatchRow> MatchRowsList, onMatchListener onMatchListener) {
        this.MatchRowsList = MatchRowsList;
        this.onMatchListener = onMatchListener;
        this.activity = activity_main;
        Log.e(TAG, "MatchAdapter: " + MatchRowsList.size());

    }

    public MatchAdapter(Context context, List<MatchRow> MatchRowList, Activity Activity) {
    }

    ;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.matchrow, viewGroup, false);

        return new MyViewHolder(itemView, onMatchListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MatchRow mMatchRow = MatchRowsList.get(i);
        //myViewHolder.RowImage.setImageResource(R.drawable.logo);
        //icon.setImageResource(context.getResources().getIdentifier(animal.getAnimalName().toLowerCase(),"drawable",context.getPackageName()));
        myViewHolder.MatchDate.setText(mMatchRow.matchDate);
        myViewHolder.TeamMatch.setText(mMatchRow.leagueMatch);
    }

    @Override
    public int getItemCount() {
        return MatchRowsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView RowImage;
        TextView MatchDate, TeamMatch;
        onMatchListener onMatchListener;

        public MyViewHolder(View view, onMatchListener onMatchListener) {
            super(view);
            this.onMatchListener = onMatchListener;
            RowImage = view.findViewById(R.id.imageView);
            MatchDate = view.findViewById(R.id.txtMatchDate);
            TeamMatch = view.findViewById(R.id.txtTeamMatch);

            // Click Listener Attached to Holder Class
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            onMatchListener.onNoteClick(getAdapterPosition());

        }
    }

    public interface onMatchListener {
        void onNoteClick(int position);
    }
}