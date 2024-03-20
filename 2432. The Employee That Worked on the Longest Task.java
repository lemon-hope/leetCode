// Easy //
//1. Calculate the duration time for each task
//2. Store the duartion of the task + the employe in hash table
//3. We get the employe at the maximum index of the hash table
//4. handle particular cases
import java.util.*;
class Solution {
    
    Hashtable<Integer,Integer> hashTable = new Hashtable<Integer,Integer>();
    int idEmploye = -1;
    public int hardestWorker(int n, int[][] logs) {
        //build the hashtable [leaveTime->id]
        for(int i = 0; i < logs.length; i++){
            System.out.println(logs.length);
            if (i == 0)
                hashTable.put(getTime(0,logs[i][1]),logs[i][0]);
            else
                hashTable.put(getTime(logs[i-1][1],logs[i][1]),logs[i][0]);
        }
        
        //get  and sort the set of all task time
        ArrayList<Integer> keysValues = new ArrayList(hashTable.keySet());
        Collections.sort(keysValues);
        System.out.println(hashTable);
        int time1 = keysValues.get(0);
        int time2 = keysValues.get(1);
        if (time1 == time2){
            idEmploye =  specialCaseHandler(hashTable.get(time1),hashTable.get(time2));
        }
        else
            idEmploye = hashTable.get(time1);
        return idEmploye;

    }
    //get the total time for a task
    public int getTime(int start,int end){
        return (end - start);
    }
    //special case handler
    int specialCaseHandler(int i, int j){
        return ((i < j)? i:j);
    }
     

}

/** RESULTS *
 * 
 * 
 * 
 * 
 * /