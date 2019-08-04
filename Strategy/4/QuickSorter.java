public class QuickSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(Comparable[] data, int pre, int post) {
        if (pre >= post)
            return;

        int idx = partition(data, pre, post);
        sort(data, pre, idx - 1);
        sort(data, idx + 1, post);
    }

    private int partition(Comparable[] data, int pre, int post) {
        int saved_pre = pre;

        while (pre < post) {
            while (pre < post && data[pre].compareTo(data[saved_pre]) < 0)
                pre++;

            while (pre < post && data[post].compareTo(data[saved_pre]) > 0)
                post--;

            swap(data, pre, post);
        }

        swap(data, saved_pre, pre);
        return pre;
    }

    private void swap(Comparable[] data, int i, int j) {
        Comparable temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}