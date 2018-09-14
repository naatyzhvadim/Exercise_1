import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class CashExchange {

    private int[] notes;
    private int num_notes;
    private int req_sum;
    private HashSet<ArrayList>[] results;

    CashExchange(int[] tmp, int sum){
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length; ++i){
            if (tmp[i] > 0)
                break;
        }
        notes = tmp;
        num_notes = notes.length;
        req_sum = sum;
        results = new HashSet[req_sum + 1];
    }

    CashExchange(){
        req_sum = 0;
    }

    public void PrintRes() {
        //for(int k = 0; k <= ReqSum; ++k) {
        int k = req_sum;
        Iterator<ArrayList> iterator = results[k].iterator();
        while (iterator.hasNext()) {
            ArrayList<Integer> ArL = iterator.next();
            for (int i = 0; i < ArL.size(); ++i)
                for (int j = 0; j < ArL.get(i); ++j)
                    System.out.print(notes[i] + " ");
            System.out.println();
        }
        //}
    }

    public void CalcResults(){
        ArrayList<Integer> pattern = new ArrayList<>();
        for (int i = 0; i < num_notes; ++i)
            pattern.add(0);
        for (int i = 0; i < num_notes; ++i){
            if (notes[i] < req_sum) {
                int k = notes[i];
                results[k] = new HashSet<>();
                ArrayList<Integer> cur_list = new ArrayList<>(pattern);
                cur_list.set(i, 1);
                results[k].add(cur_list);
            }
        }

        if (notes[num_notes - 1] + notes[0] > req_sum){
            return;
        }

        for (int cur_sum = notes[0] + notes[0]; cur_sum <= req_sum; ++cur_sum) {
            if (cur_sum % 1000 == 0)
                System.out.println(cur_sum);
            for (int j = 0; j < num_notes; ++j) {
                if (cur_sum - notes[j] >= 0) {
                    if (results[cur_sum - notes[j]] != null) {
                        if (results[cur_sum] == null)
                            results[cur_sum] = new HashSet<>();
                        Iterator<ArrayList> iterator = results[cur_sum - notes[j]].iterator();
                        while (iterator.hasNext()) {
                            ArrayList<Integer> ArL = new ArrayList<Integer>(iterator.next());
                            ArL.set(j, ArL.get(j) + 1);
                            results[cur_sum].add(ArL);
                        }
                        if (j == num_notes - 1){
                            results[cur_sum - notes[j]] = null;
                        }
                    }
                } else
                    break;
            }
        }
    }


}