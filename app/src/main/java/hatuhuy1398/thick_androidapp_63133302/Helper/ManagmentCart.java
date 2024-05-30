package hatuhuy1398.thick_androidapp_63133302.Helper;
import android.content.Context;
import android.widget.Toast;

import hatuhuy1398.thick_androidapp_63133302.Domain.ItemsDomain;

import java.util.ArrayList;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertItem(ItemsDomain item) {
        ArrayList<ItemsDomain> listitems = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int y = 0; y < listitems.size(); y++) {
            if (listitems.get(y).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = y;
                break;
            }
        }
        if (existAlready) {
            listitems.get(n).setNumberinCart(item.getNumberinCart());
        } else {
            listitems.add(item);
        }
        tinyDB.putListObject("CartList", listitems);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ItemsDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void minusItem(ArrayList<ItemsDomain> listitems, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listitems.get(position).getNumberinCart() == 1) {
            listitems.remove(position);
        } else {
            listitems.get(position).setNumberinCart(listitems.get(position).getNumberinCart() - 1);
        }
        tinyDB.putListObject("CartList", listitems);
        changeNumberItemsListener.changed();
    }

    public void plusItem(ArrayList<ItemsDomain> listitems, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listitems.get(position).setNumberinCart(listitems.get(position).getNumberinCart() + 1);
        tinyDB.putListObject("CartList", listitems);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<ItemsDomain> listitems2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listitems2.size(); i++) {
            fee = fee + listitems2.get(i).getPrice() * listitems2.get(i).getNumberinCart();
        }
        return fee;
    }
}
