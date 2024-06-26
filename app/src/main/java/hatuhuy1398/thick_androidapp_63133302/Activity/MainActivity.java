package hatuhuy1398.thick_androidapp_63133302.Activity;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;
import com.google.firebase.database.DatabaseReference;
import hatuhuy1398.thick_androidapp_63133302.Domain.CategoryDomain;
import java.util.ArrayList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import hatuhuy1398.thick_androidapp_63133302.Adapter.SliderAdapter;
import hatuhuy1398.thick_androidapp_63133302.Domain.ItemsDomain;
import hatuhuy1398.thick_androidapp_63133302.Domain.SliderItems;
import hatuhuy1398.thick_androidapp_63133302.databinding.ActivityMainBinding;
import hatuhuy1398.thick_androidapp_63133302.Adapter.CategoryAdapter;
import hatuhuy1398.thick_androidapp_63133302.Adapter.PopularAdapter;



public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initBanner();
        initCategory();
        initPopular();

    }

    private void initPopular() {
        DatabaseReference myRef = database.getReference("Items");
        binding.progressBarPopular.setVisibility(View.VISIBLE);
        ArrayList<ItemsDomain> items = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        items.add(issue.getValue(ItemsDomain.class));
                    }
                    if (!items.isEmpty()){
                    binding.recyclerViewPopular.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                    binding.recyclerViewPopular.setAdapter(new PopularAdapter(items));
                }
                    binding.progressBarPopular.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initBanner(){
        DatabaseReference myRef = database.getReference("Banner");
        binding.progressBarBanner.setVisibility(View.VISIBLE);
        ArrayList<SliderItems> items = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    for(DataSnapshot issue : snapshot.getChildren()){

                        items.add(issue.getValue(SliderItems.class));
                    }
                    banners(items);
                    binding.progressBarBanner.setVisibility(View.GONE);
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void banners(ArrayList<SliderItems> items) {
        binding.viewpaperSlider.setAdapter(new SliderAdapter(items, binding.viewpaperSlider));
        binding.viewpaperSlider.setClipToPadding(false);
        binding.viewpaperSlider.setClipChildren(false);
        binding.viewpaperSlider.setOffscreenPageLimit(3);
        binding.viewpaperSlider.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        binding.viewpaperSlider.setPageTransformer(compositePageTransformer);
    }
    private void initCategory(){
        DatabaseReference myRef = database.getReference("Category");
        binding.progressBarOffical.setVisibility(View.VISIBLE);
        ArrayList<CategoryDomain> items = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        items.add(issue.getValue(CategoryDomain.class));
                    }
                    if (!items.isEmpty()){
                    binding.recyclerViewOffical.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.HORIZONTAL, false));
                    binding.recyclerViewOffical.setAdapter(new CategoryAdapter(items));
                }
                    binding.progressBarOffical.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}