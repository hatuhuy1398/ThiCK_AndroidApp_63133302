package hatuhuy1398.thick_androidapp_63133302.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import java.util.ArrayList;
import hatuhuy1398.thick_androidapp_63133302.Domain.SliderItems;

import hatuhuy1398.thick_androidapp_63133302.Adapter.SliderAdapter;
import hatuhuy1398.thick_androidapp_63133302.Domain.ItemsDomain;
import hatuhuy1398.thick_androidapp_63133302.Helper.ManagmentCart;
import hatuhuy1398.thick_androidapp_63133302.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private ItemsDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityDetailBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
       managmentCart = new ManagmentCart(this);

       getBundles();
       banners();



    }
    private void banners(){
        ArrayList<SliderItems> sliderItems = new ArrayList<>();
        for (int i = 0; i < object.getPicUrl().size(); i++) {
            sliderItems.add(new SliderItems(object.getPicUrl().get(i)));
        }
        binding.viewpagerSlider.setAdapter(new SliderAdapter(sliderItems, binding.viewpagerSlider));
        binding.viewpagerSlider.setClipToPadding(false);
        binding.viewpagerSlider.setClipChildren(false);
        binding.viewpagerSlider.setOffscreenPageLimit(3);
        binding.viewpagerSlider.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
    private void getBundles(){
    object = (ItemsDomain) getIntent().getSerializableExtra("object");
    binding.titleTxt.setText(object.getTitle());
    binding.ratingTxt.setText("("+object.getRating()+")");
    binding.priceTxt.setText("$"+object.getPrice());
    binding.ratingBar.setRating((float) object.getRating());
    binding.addTocartBtn.setOnClickListener(v->{
        object.setNumberinCart(numberOrder);
        managmentCart.insertItem(object);
    });
    binding.backBtn.setOnClickListener(v->{
        finish();
    });
    }
}
