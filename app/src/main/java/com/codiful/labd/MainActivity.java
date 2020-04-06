package com.codiful.labd;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<ItemList> itemLists;
    private GroupAdapter mAdapter;

    private ProgressBar prgSched;
    private     List<ItemGroup> itemGroups ;
    private FirebaseDatabase database;
    private  DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemGroups = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_sun);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //getData
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("MyData");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                prgSched.setVisibility(View.GONE);
                for (DataSnapshot results : dataSnapshot.getChildren()) {
                    ItemGroup itemGroup = new ItemGroup();
                    itemGroup.setHeaderTitle(results.child("headerTitle").getValue(true).toString());
                    GenericTypeIndicator<ArrayList<ItemList>> items = new GenericTypeIndicator<ArrayList<ItemList>>() {
                    };
                    itemGroup.setListItem(results.child("listItem").getValue(items));
                    itemGroups.add(itemGroup);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("ERROR",databaseError.getMessage().toString());
            }

        });

        mAdapter = new GroupAdapter (MainActivity.this, itemGroups);

        recyclerView.setAdapter(mAdapter);

        prgSched = (ProgressBar) findViewById(R.id.prg);
        prgSched.setVisibility(View.VISIBLE);


    }

    private  void getData()
    {

    }

    class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {
        private Context context;
        private List<ItemGroup> list;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title;
            public RecyclerView recyclerView;

            public MyViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.group_title);
                recyclerView = view.findViewById(R.id.group_recyle);
            }
        }


        public GroupAdapter(Context context, List<ItemGroup> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.group_card, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.title.setText(list.get(position).getHeaderTitle());

            List<ItemList> itemLists = list.get(position).getListItem();
            ItemAdapter adpater = new ItemAdapter(context,itemLists);

            holder. recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
            holder.recyclerView.setNestedScrollingEnabled(false);
            holder.recyclerView.setAdapter(adpater);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
        private Context context;
        private List<ItemList> itemList_array;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView name, title;
            public ImageView thumbnail;

            public MyViewHolder(View view) {
                super(view);
                name = view.findViewById(R.id.item_movie_title);
                thumbnail = view.findViewById(R.id.item_movie_img);
            }
        }



        public ItemAdapter(Context context, List<ItemList> itemList_array) {
            this.context = context;
            this.itemList_array = itemList_array;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_item, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            final ItemList item = itemList_array.get(position);
            holder.name.setText(item.getName());

            RequestOptions options = new RequestOptions()
                    .placeholder(android.R.drawable.progress_horizontal)
                    .error(android.R.drawable.presence_offline)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);

            Glide.with(context)
                    .load(item.getImage())
                    .apply(options)
                    .into(holder.thumbnail);

        }

        @Override
        public int getItemCount() {
            return itemList_array.size();
        }
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
