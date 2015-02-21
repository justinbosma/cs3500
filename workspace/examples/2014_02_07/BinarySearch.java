/**
 * 
 * @author cs3500sp14 on 2/7/2014
 *
 */
public class BinarySearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final int MAX = 10;
        int[] dataArray = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            dataArray[i] = i * 2;
        }

        for (int i = 0; i < MAX; i++) {
            System.out.println("Find " + (i * 2) + " (Should be " + i
                    + "): "
                    + binarySearch(dataArray, 0, (MAX - 1), (i * 2)));
        }

        for (int i = 0; i <= MAX; i++) {
            System.out.println("Find " + (i * 2 - 1) + " (Should be -1): "
                    + binarySearch(dataArray, 0, (MAX - 1), (i * 2 - 1)));
        }

    }

    /**
     * PRE: 0 <= min <= max <= data.length
     * 
     * @param data
     *            sorted array of ints
     * @param min
     *            min index to search
     * @param max
     *            max index to search
     * @param target
     *            value searching for in data
     * @return index of target in data, or -1 if target is not in data
     */
    public static int binarySearch(int[] data, int min, int max, int target) {
        if (0 <= min && min <= max && max <= data.length) {
            int mid = (min + max + 1) / 2;
            if (data[mid] == target) {
                return mid;
            }
            if (data[mid] > target) {
                return binarySearch(data, min, mid - 1, target);
            }
            else {
                return binarySearch(data, mid + 1, max, target);
            }
        }
        return -1;
    }

}
