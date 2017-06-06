import com.gb.object.Line;

public class test {
    public static void main(String[] args) {
        Line line = new Line("4∫≈œﬂ");
        System.out.printf("0x%08x", line.getId());
        System.out.println(line.getName());
//		System.out.printf("0x%08x",0x0100);
//		System.out.println(Query.isIdExist(0x01000000));
//		System.out.println(Query.isIdExist(0x02000000));
//		System.out.println(Query.isIdExist(0x03000000));
    }
}
