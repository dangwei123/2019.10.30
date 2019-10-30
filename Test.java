
import java.util.Arrays;

/**
 * ClassName:ArrayList
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/10/30 17:29
 * @Author:DangWei
 */
public class ArrayList {
    public int[] elem;
    public int usedSize;
    public final int LENGTH=10;
    public ArrayList(){
        this.elem=new int[LENGTH];
        this.usedSize=0;
    }
  // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(this.usedSize==elem.length){
            this.elem= Arrays.copyOf(elem,2*elem.length);
        }
        if(pos<0||pos>usedSize){
            System.out.println("不合法");
            return ;
        }
        int tmp=usedSize;
        while(tmp!=pos){
            this.elem[tmp]=elem[tmp-1];
            tmp--;
        }
        this.elem[pos]=data;
        this.usedSize++;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for(int i=0;i<usedSize;i++){
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>=usedSize){
            return -1;
        }
        return elem[pos];
    }
    //删除第一次出现的关键字key
     public void remove(int toRemove) {
         int i=0;
         for(i=0;i<usedSize;i++){
            if(elem[i]==toRemove){
                break;
            }
        }
        if(i!=usedSize){
             while(i!=usedSize-1){
                 elem[i]=elem[i+1];
                 i++;
             }
             this.usedSize--;
        }

    }
    // 清空顺序表
     public void clear(){
        this.usedSize=0;
     }
    // 判定是否包含某个元素
   public boolean contains(int toFind) {
        for(int i=0;i<usedSize;i++){
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 获取顺序表长度
   public int size() {
        return usedSize;
    }
    // 打印顺序表
    public void display() {
        for(int i=0;i<usedSize;i++){
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
}


class Main2{
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        arrayList.add(0,5);
        arrayList.add(0,4);
        arrayList.add(0,3);
        arrayList.add(0,3);
        arrayList.add(0,3);
        arrayList.add(0,2);
        arrayList.add(0,1);
        arrayList.display();
        System.out.println(arrayList.size());
        System.out.println(arrayList.getPos(4));
        System.out.println(arrayList.search(3));
        arrayList.remove(3);
        arrayList.display();
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains(4));
    }
}
