public class Main {
    public static void main(String[] args) {
        int n = 5; // You can change this value to any positive integer
        int i = 1;
        int sum = 0;
        
        // Calculate the sum of cubes using a while loop
        while (i <= n) {
            int cube = i * i * i;
            sum += cube;
            System.out.print(cube);
            
            if (i < n) {
                System.out.print(" + ");
            }
            
            i++;
        }
        
        // Print the total sum
        System.out.println(" = " + sum);
    }
}
