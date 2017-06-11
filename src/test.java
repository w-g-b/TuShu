import com.gb.object.Line;
import com.gb.object.SpecificShop;
import com.gb.object.Station;
import com.gb.util.Query;

public class test {
    public static void main(String[] args) {
        Query query = new Query();

//        Line line = new Line("4号线");
//        System.out.printf("0x%08x\n", line.getId());
//        Station station = new Station("淘金", 0x01000000, true);
//        System.out.printf("0x%08x\n", station.getId());
//        ShopType shopType = new ShopType("便利店", 0x01010000);
//        System.out.printf("0x%08x\n", shopType.getId());
//        System.out.println(line.getName());
//		System.out.printf("0x%08x",0x0100);
//		System.out.println(Query2.isIdExist(0x01000000));
//		System.out.println(Query2.isIdExist(0x02000000));
//		System.out.println(Query2.isIdExist(0x03000000));
//        SpecificShop shop = new SpecificShop("柏高", 0x01010100, 110, 5, 5, "好");
//        System.out.printf("0x%08x\n", shop.getId());
//        System.out.println(Query2.getInfoById(0x01010100));
//        System.out.println(Query3.getInfosByName("王府井"));
//        System.out.println(Query3.getInfoById(0x01010202));
        System.out.println(new SpecificShop(new Query().getInfoById(0x01010101)).toShow());
        System.out.println(new Station(new Query().getInfoById(0x01010000)).toShow());
        System.out.println(new Line(new Query().getInfoById(0x01000000)).toShow());
    }
}


