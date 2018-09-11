import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class CashExchange {

    private int[] Notes;
    private int NumNotes;
    private int ReqSum;
    private HashSet<ArrayList>[] Results;

    CashExchange(int[] tmp, int sum){
        Notes = tmp;
        Arrays.sort(Notes);
        NumNotes = Notes.length;
        ReqSum = sum;
        Results = new HashSet[ReqSum + 1];
    }

    public void PrintRes(){
        for(int k = 0; k <= ReqSum; ++k) {

            if (Results[k] == null)
                continue;
            System.out.println("There are " + Results[k].size() + " combos for sum = " + k);
            Iterator<ArrayList> iterator = Results[k].iterator();
            while (iterator.hasNext()) {
                ArrayList<Integer> ArL = iterator.next();
                /*System.out.println("IN HASH ");
                for (int i = 0; i < ArL.size(); ++i){
                    System.out.print(ArL.get(i) + " ");
                }*/
                //System.out.println("\nACtual ");
                for (int i = 0; i < ArL.size(); ++i)
                    for (int j = 0; j < ArL.get(i); ++j)
                        System.out.print(Notes[i] + " ");
                System.out.println();
            }
        }
    }

    public void CalcResults(){
        ArrayList<Integer> Pattern = new ArrayList<>();
        for (int i = 0; i < NumNotes; ++i)
            Pattern.add(0);
        //System.out.println("LOOOOL   " + NumNotes);
        for (int i = 0; i < NumNotes; ++i){
            if (Notes[i] < ReqSum) {
                int k = Notes[i];
                //Results[k] = new HashSet<>();
                //int[] tmp = new int[NumNotes];
                //tmp[i] = 1;
                Results[k] = new HashSet<>();
                ArrayList<Integer> X = new ArrayList<>(Pattern);
                //X.addAll(Pattern);
                X.set(i, 1);
                Results[k].add(X);
                //Results[k].add(tmp.clone());
                //System.out.println("HEY");
            }
        }

        if (Notes[NumNotes - 1] + Notes[0] > ReqSum){
            //System.out.println("OOPS");
            return;
        }

        for (int CurSum = Notes[0] + Notes[0]; CurSum <= ReqSum; ++CurSum) {
            for (int j = 0; j < NumNotes; ++j) {
                if (CurSum - Notes[j] >= 0) {
                    if (Results[CurSum - Notes[j]] != null) {
                        //System.out.println("OOOOOOPPPP");
                        if (Results[CurSum] == null)
                            Results[CurSum] = new HashSet<>();
                        Iterator<ArrayList> iterator = Results[CurSum - Notes[j]].iterator();
                        while (iterator.hasNext()) {
                            ArrayList<Integer> ArL = new ArrayList<Integer>(iterator.next());
                            //++arr[j];
                            ArL.set(j, ArL.get(j) + 1);
                            Results[CurSum].add(ArL);
                            //System.out.println("ADDED ");
                            //for (int i = 0; i < arr.length; ++i)
                            //    System.out.print(arr[i] + " ");
                            //System.out.println();
                        }
                    }
                } else
                    break;
            }
        }
    }
}

