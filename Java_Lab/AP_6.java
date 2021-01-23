class Box{
    private float length, breadth, depth;
    public Box(float l, float b, float d){
        length = l; breadth = b; depth = d;
    }
    public float getVolume(){
        return length*breadth*depth;
    }
}

class AP_6{
    public static void main(String[] args){
        Box b1 = new Box(10.1f,8.2f,6.3f);
        Box b2 = new Box(5,5,5);
        System.out.printf("Volume of Box 1: %f\nVolume of Box 2: %f\n", b1.getVolume(), b2.getVolume());
    }
}