//dificulty : medium
class Solution {
    public int getKth(int lo, int hi, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = lo; i <= hi; i++){
            map.put(i, getPower(i,0));
        }

        List<Integer> l = new ArrayList<>(map.keySet());
        l =  sortMapByValue(map);
        return l.get(k-1);
    }

    public int getPower(int x, int power){
        if (x == 1){
            return power;
        }else if(x%2 == 0){
            power++;
            return getPower(x/2, power);
        }else{
            power++;
            return getPower(x*3+1,power);
        }
       
    }
    /**
    Sort the given hashmap by value in ascending order 
     */
    public List<Integer> sortMapByValue(HashMap<Integer,Integer> unsortedMap) {
            HashMap<Integer, Integer> sortedMap = new HashMap<>();
            List<Integer> mapKeys = new ArrayList<>(unsortedMap.keySet());
            List<Integer> mapValues = new ArrayList<>(unsortedMap.values());
             List<Integer> rep = new ArrayList<>();
            Collections.sort(mapKeys);
            Collections.sort(mapValues);
            Iterator<Integer> valueIt = mapValues.iterator();
            
        
            while(valueIt.hasNext()){
                Integer val = valueIt.next();
                Iterator<Integer> keyIt = mapKeys.iterator();
                while(keyIt.hasNext()){
                    Integer key = keyIt.next();
                    if(unsortedMap.get(key) == val){
                        keyIt.remove();
                        rep.add(key);
                        sortedMap.put(key,val);
                        break;
                    }
                }
               
            }
          
        return rep ;
    }
    

}

/***************************RESULTS ********************************/
/**
 * Runtime
    163ms
    Beats16.30%of users with Java
  Memory
    44.81MB
    Beats23.20%of users with Jav
 */