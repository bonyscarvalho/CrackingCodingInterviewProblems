package ChapterRecursionAndDP;

import java.util.Stack;

public class TowerOfHanoi {
    static class Tower{
        private Stack<Integer> disks;
        private int index;
        public Tower(int i){
            disks = new Stack<>();
            index = i;
        }

        public int index(){
            return index;
        }

        public void add(int d){
            if((!disks.isEmpty()) && (disks.peek() <= d)){
                System.out.println("ERROR"+ d);
            }else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower tower){
            int top = disks.pop();
            tower.add(top);
        }

        public void moveDisksFromSrcToDest(int n, Tower dest, Tower buffer){
            if(n > 0){
                moveDisksFromSrcToDest(n-1, buffer, dest);
                moveTopTo(dest);
                buffer.moveDisksFromSrcToDest(n-1, dest, this);
            }
        }

        public void displayTower(){
            while (!disks.isEmpty()){
                System.out.println("Value: " + disks.pop());
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Tower [] towers = new Tower[n];
        for (int i = 0; i < 3; i++){
            towers[i] = new Tower(i);
        }

        for(int i = n; i > 0; i--){
            towers[0].add(i);
        }


        towers[0].moveDisksFromSrcToDest(n,towers[2], towers[1]);

        towers[2].displayTower();
    }
}
