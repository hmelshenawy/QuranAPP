package com.haitham.mytest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.haitham.mytest.MainActivity;
import com.haitham.mytest.QuranPage2;
import com.haitham.mytest.R;
import com.haitham.mytest.models.Surah;
import java.util.List;

public class QuranIndex_Adapter extends RecyclerView.Adapter<QuranIndex_Adapter.QuranIndex_ViewHolder> {

    Context context;
    List<Surah> surahList;

    public QuranIndex_Adapter(Context context, List<Surah> surahList) {

        this.context = context;
        this.surahList = surahList;
    }

    @NonNull
    @Override
    public QuranIndex_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.quran_index_item, parent, false);

        QuranIndex_ViewHolder holder = new QuranIndex_ViewHolder(view);
        return  holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final QuranIndex_ViewHolder holder, final int position) {

        holder.tv_index.setText(surahList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(context, QuranPage2.class);
                intent.putExtra("position", surahList.get(position).getNumber() - 1);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return surahList.size();
    }



    class QuranIndex_ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_index;

        public QuranIndex_ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_index = itemView.findViewById(R.id.tv_index);
        }
    }
}
