import java.util.Arrays;
public class MergeMassive {
    void main(String[] args) {

        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};

        int n1 = a1.length;
        int n2 = a2.length;

        int[] result = new int[n1 + n2];

        int i=0; int j = 0; int k = 0;

        while (i<n1 && j<n2){
            if(a1[i]<=a2[j]){
                result[k++]=a1[i++];
            } else {
                result[k++]=a2[j++];
            }
        }

while (i<n1){
    result[k++] = a1[i++];
}
while (j<n2){
    result[k++]=a2[j++];
}
        System.out.println(Arrays.toString(result));
    }

}
