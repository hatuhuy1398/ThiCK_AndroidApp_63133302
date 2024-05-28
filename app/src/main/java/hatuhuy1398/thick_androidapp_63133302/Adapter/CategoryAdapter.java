package hatuhuy1398.thick_androidapp_63133302.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import hatuhuy1398.thick_androidapp_63133302.Domain.CategoryDomain;
import hatuhuy1398.thick_androidapp_63133302.databinding.ViewholderCategoryBinding;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {
    private ArrayList<CategoryDomain> items;
    private Context context;
    public CategoryAdapter(ArrayList<CategoryDomain> items) {
        this.items = items;
    }
    public class Viewholder extends RecyclerView.ViewHolder {
       ViewholderCategoryBinding binding;
        public Viewholder(@NonNull ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderCategoryBinding binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
    holder.binding.title.setText(items.get(position).getTitle());
    Glide.with(context).load(items.get(position).getPicUrl()).into(holder.binding.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
