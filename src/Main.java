import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    final int listSize = 10;
    public static PApplet app;
    private ArrayList<Wrapper> list;
    private int low;
    private int high;
    private int mid;
    private int target;
    private int status;

    public Main (){
        super();
        app = this;
    }
    public static void main(String[] args){
        PApplet.main("Main");
    }
    public void setup(){
        list = new ArrayList<Wrapper>();
        int h = 80;
        int w = 80;
        for (int i = 0; i<listSize;  i++) {
            int x = i*w;
            Wrapper num = new Wrapper (x + 50 ,h + 100,w,h,i, (int)(Math.random()*10));
            list.add(num);
        }
        low = 0;
        high = listSize-1;
    }

    public void settings(){size(900,600);}
    public void draw(){
        background(255, 226, 214);
        for (Wrapper w: list) {
            w.display();
        }
        fill(0,0,0);
        if (status == 0){
            text("NOT FOUND YET", (float)(width/2.25), height/10);
        } else if (status == 1){
            text("FOUND AT INDEX " + list.get(mid).getIndex(), (float)(width/2.25), height/10);
        } else {
            text("DOESN'T EXIST", (float)(width/2.25), height/10);
        }
        text("INSTRUCTIONS: \n 1. Press the 's' key to sort the numbers." +
                "\n 2. Type the number to be searched. " +
                "\n 3. Press that key to iterate through the search. The number being compared will be highlighted. " +
                "\n 4. Press the ENTER key to start over with a new set of numbers.", width/4, height/2);
    }

    public void keyPressed() {
        if (key == ENTER){
            target = 0;
            setup();
        } else if (key == 's'){
            selectionSort();
        } else {
            String text = "";
            text+=key;
            target = Integer.valueOf(text);
            binarySearch();
        }
    }

    public int binarySearch(){
        if (low<=high){
            mid = (low+high)/2;
            (list.get(mid)).hasBeenSearched();
            if(target<(list.get(mid)).getValue()){
                high = mid-1;
                status = 0;
            } else if (target>(list.get(mid)).getValue()) {
                low = mid+1;
                status = 0;
            } else {
                status = 1;
                return mid;
            }
        } else {
            status = -1;
        }
        return -1;
    }

    public void selectionSort(){
        for (int i = 0; i<list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getValue() < list.get(minIndex).getValue())
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = list.get(minIndex).getValue();
                (list.get(minIndex)).setValue(list.get(i).getValue());
                (list.get(i)).setValue(temp);
            }
        }
    }


//    public int binarySearchRecursive(int low, int high, int key){
//        if (low>high) {
//            return -1;
//        } else {
//            int mid = (low + high) / 2;
//            if (key < list.get(mid)) {
//                return binarySearchRecursive(low, mid - 1, key);
//            } else if (key > list.get(mid)) {
//                return binarySearchRecursive(mid + 1, high, key);
//            } else {
//                return mid;
//            }
//        }
//    }

//    public int binarySearchIterative(int low, int high, int key){
//        while (low<=high){
//            int mid = (low+high)/2;
//            if(key<list.get(mid)){
//                high = mid-1;
//            } else if (key>list.get(mid)) {
//                low = mid+1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

}