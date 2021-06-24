package leetcode.Segment_Tree.range_update;

class RangeModule {
    SegmentNode root;
    int max = (int) Math.pow(10,9);
    public RangeModule() {
        root = new SegmentNode(0,max,false);
    }

    public void addRange(int left, int right) {
        update(root,left,right,true);
    }

    private boolean update(SegmentNode node,int l,int r,boolean state){
        if(l<=node.l && r>=node.r){
            node.state = state;
            node.left = null;
            node.right = null;
            return node.state;
        }
        if(l>=node.r || r<=node.l) return node.state;
        int mid = node.l + (node.r - node.l) / 2;
        if(node.left==null){
            node.left = new SegmentNode(node.l,mid,node.state);
            node.right = new SegmentNode(mid,node.r,node.state);
        }
        boolean left = update(node.left, l, r,state);
        boolean right = update(node.right, l, r,state);
        node.state = left && right;
        return node.state;
    }

    public boolean queryRange(int left, int right) {
        return query(root,left,right);
    }


    private boolean query(SegmentNode node,int l,int r){
        if(l>=node.r || r<=node.l) return true;
        if((l<=node.l && r>=node.r) || (node.left==null)) return node.state;
        int mid = node.l + (node.r - node.l) / 2;
        if(r<=mid){
            return query(node.left,l,r);
        }else if(l>=mid){
            return query(node.right,l,r);
        }else{
            return query(node.left,l,r) && query(node.right,l,r);
        }
    }

    public void removeRange(int left, int right) {
        update(root,left,right,false);
    }
}


class SegmentNode {
    public int l, r;
    public boolean state;
    public SegmentNode left, right;

    public SegmentNode(int l, int r, boolean state) {
        this.l = l;
        this.r = r;
        this.state = state;
        this.left = null;
        this.right = null;
    }
}