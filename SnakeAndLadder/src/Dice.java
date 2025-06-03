public class Dice {
    int count;
    public Dice(int count){
        this.count = count;
    }
    public int getSum(){
        int sum = 0;
        for(int i=0;i<count;i++){
            sum+= (int) (Math.floor(Math.random() * 6) + 1);
        }
        return sum;
    }
}
