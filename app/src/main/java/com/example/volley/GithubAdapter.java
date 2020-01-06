package com.example.volley;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {

    private Context context;
    private User[] data;

    public GithubAdapter(Context mContext, User[] mdata) {
        context = mContext;
        data = mdata;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.items, parent, false );
        return new GithubViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        final User user = data[position];
        holder.textView.setText( user.getLogin() );
        Glide.with( context ).load( user.getAvatarUrl() ).into( holder.imageView );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( context, user.getLogin() + " was clicked", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent( context, Main2Activity.class );
                intent.putExtra( "s1", user.getLogin() );
                intent.putExtra( "s2", user.getAvatarUrl() );
                context.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public GithubViewHolder(@NonNull View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.imageUser );
            textView = itemView.findViewById( R.id.textUser );
        }
    }
}