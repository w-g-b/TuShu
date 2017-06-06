import com.gb.object.Line;
import com.gb.object.ShopType;
import com.gb.object.SpecificShop;
import com.gb.object.Station;

public class test {
    public static void main(String[] args) {
        Line line = new Line("4号线");
        System.out.printf("0x%08x\n", line.getId());
        Station station = new Station("淘金", 0x01000000, true);
        System.out.printf("0x%08x\n",station.getId());
        ShopType shopType = new ShopType("便利店", 0x01010000);
        System.out.printf("0x%08x\n",shopType.getId());
//        System.out.println(line.getName());
//		System.out.printf("0x%08x",0x0100);
//		System.out.println(Query.isIdExist(0x01000000));
//		System.out.println(Query.isIdExist(0x02000000));
//		System.out.println(Query.isIdExist(0x03000000));
        SpecificShop shop = new SpecificShop("柏高", 0x01010100, 110, 5, 5, "好");
        System.out.printf("0x%08x\n", shop.getId());
    }
}
