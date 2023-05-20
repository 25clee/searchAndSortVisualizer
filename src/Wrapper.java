public class Wrapper {

    private int x;
    private int y;
    private int w;
    private int h;
    private int index;
    private int value;
    public boolean hasBeenCompared;

    public Wrapper(int x, int y, int w, int h, int index, int value){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.index = index;
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public int getIndex(){return index;};
    public void setValue(int value2){value = value2;}

    public void display(){
        if(hasBeenCompared) {
            Main.app.fill(0, 209, 194);
            Main.app.rect(x, h, w, h);
            Main.app.fill(0,0,0);
            Main.app.textSize(15);
            Main.app.text(getValue(),x+w/2,h+h/2);
        } else {
            Main.app.fill(255, 255, 255);
            Main.app.rect(x, h, w, h);
            Main.app.fill(0,0,0);
            Main.app.textSize(15);
            Main.app.text(getValue(),x+w/2,h+h/2);
        }
    }

    public void hasBeenSearched(){
        hasBeenCompared = !hasBeenCompared;
    }
}
