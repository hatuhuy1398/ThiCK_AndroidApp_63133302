package hatuhuy1398.thick_androidapp_63133302.Adapter;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import android.content.Context;
import hatuhuy1398.thick_androidapp_63133302.Domain.ItemsDomain;
import hatuhuy1398.thick_androidapp_63133302.databinding.ViewholderPopListBinding;
import android.view.LayoutInflater;
import android.graphics.Paint;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import android.content.Intent;
import hatuhuy1398.thick_androidapp_63133302.Activity.DetailActivity;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder>{
    ArrayList<ItemsDomain> items;
    Context context;
    public PopularAdapter(ArrayList<ItemsDomain> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderPopListBinding binding = ViewholderPopListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
    holder.binding.title.setText(items.get(position).getTitle());
    holder.binding.reviewTxt.setText(items.get(position).getReview());
        holder.binding.priceTxt.setText("$"+items.get(position).getPrice());
        holder.binding.oldPriceTxt.setText("$"+items.get(position).getOldPrice());
        holder.binding.oldPriceTxt.setPaintFlags(holder.binding.oldPriceTxt.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.binding.ratingBar.setRating((float) items.get(position).getRating());
        holder.binding.ratingTxt.setText("("+items.get(position).getRating()+")");
    RequestOptions requestOptions = new RequestOptions().centerCrop();
    requestOptions = requestOptions.transform(new CenterCrop());
    Glide.with(context)
            .load(items.get(position).getPicUrl().get(0))
            .apply(requestOptions)
            .into(holder.binding.pic);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderPopListBinding binding;
        public Viewholder(@NonNull ViewholderPopListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
