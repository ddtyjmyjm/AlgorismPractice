// USE LinkedHashMap

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution3 {

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {

        LinkedHashMap<Integer, Integer> pool = new LRUPool<>(k);

        List<Integer> results = new ArrayList<>();
        for (int[] op : operators) {
            if (op[0] == 1) {
                pool.put(op[1], op[2]);
            } else if (op[0] == 2) {
                if(pool.get(op[1])==null)
                    results.add(-1);
                else
                    results.add(pool.get(op[1]));
            }
        }

        // create a primative int array
        int[] array = new int[results.size()];
        for (int i=0; i< results.size();i++) array[i] = results.get(i);
        return array;
    }

    class LRUPool<K,V> extends LinkedHashMap<K,V>{
        private final int threshold;

        public LRUPool(int threshold){
            super(16,0.75F,true);
            this.threshold = threshold;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest){
            return this.size() > threshold;
        }
    }
}