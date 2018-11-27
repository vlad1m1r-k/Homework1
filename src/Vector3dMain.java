public class Vector3dMain {
    public static void main(String[] args) {
        Vector3d vector1 = new Vector3d(-1, 2, -3);
        Vector3d vector2 = new Vector3d(0, -4, 1);

        System.out.println(vector1.add(vector2));
        System.out.println(vector1.vectorMultiply(vector2));
        System.out.println(vector1.scalarMultiply(vector2));
    }
}

class Vector3d {
    private int x, y, z;

    public Vector3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Vector3d add(Vector3d otherVector){
        return new Vector3d(this.x + otherVector.x, this.y + otherVector.y, this.z + otherVector.z);
    }

    public Vector3d vectorMultiply(Vector3d otherVector){
        return new Vector3d((this.y * otherVector.z - this.z * otherVector.y), -(this.x * otherVector.z - this.z * otherVector.x), (this.x * otherVector.y - this.y * otherVector.x));
    }

    public int scalarMultiply(Vector3d otherVector){
        return this.x * otherVector.x + this.y * otherVector.y + this.z * otherVector.z;
    }

    @Override
    public String toString() {
        return "Vector3d{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}