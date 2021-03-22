package ChapterSortingAndSearching;

public class RankNode {
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;
    public  RankNode(int d){
        data = d;
    }
    public void insert(int d){
        if(d <= data){
            if(left != null){
                left.insert(d);
            }else {
                left = new RankNode(d);
            }
            System.out.println("Data: " + d +"Left_SIZE: "+ left_size);
            left_size++;
        }else {
            if(right != null){
                right.insert(d);
            }else {
                right = new RankNode(d);
            }
        }
    }

    public int getRank(int d){
        if(d == data){
            return left_size;
        }else if(d < data){
            if(left == null){
                return -1;
            }else {
                return left.getRank(d);
            }
        }else {
            int right_rank = right == null ? -1 : right.getRank(d);
            if(right_rank == -1){
                return -1;
            }else {
                return left_size + 1 + right_rank;
            }
        }
    }

    RankNode root = null;

    void track(int number){
        if(root == null){
            root = new RankNode(number);
        }else {
            root.insert(number);
        }
    }

    int getRankOfNumber(int number){
        return root.getRank(number);
    }

    public static void main(String args[])
    {
        RankNode rankNode = new RankNode(20);
        //rankNode.insert(20);
        rankNode.insert(15);
        rankNode.insert(25);
        rankNode.insert(10);
        rankNode.insert(5);
        rankNode.insert(13);
        rankNode.insert(23);
        rankNode.insert(24);

        System.out.println("Rank: " + rankNode.getRank(20));
    }
}
