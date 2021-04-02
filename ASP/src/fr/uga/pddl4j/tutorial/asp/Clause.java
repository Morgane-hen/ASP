package fr.uga.pddl4j.tutorial.asp;

import java.util.ArrayList;
import fr.uga.pddl4j.util.BitVector;
import fr.uga.pddl4j.util.BitExp;


public class Clause {
    ArrayList<Integer> list; 
    int action = -1;
    
    public Clause(BitVector preCondPOS, BitVector preCondNEG, BitVector effectPOS, BitVector effectNEG,  int indexAction, int nbOp){
        action = indexAction;

        list = new ArrayList<Integer>();
        int i = 0;

        for(int index = 0; index <preCondPOS.cardinality();index++){
            i = preCondPOS.nextSetBit(i);
            list.add(nbOp +1+ i);
            i++;
        }
        
        i = 0;
        for(int index = 0; index <preCondNEG.cardinality();index++){
            i = preCondNEG.nextSetBit(i);
            list.add((nbOp +1+ i)  * -1);
            i++;
        }
        
        i = 0;
        for(int index = 0; index <effectPOS.cardinality();index++){
            i = effectPOS.nextSetBit(i);
            list.add(nbOp +1+ i);
            i++;
        }

        i = 0;
        for(int index = 0; index <effectNEG.cardinality();index++){
            i = effectNEG.nextSetBit(i);
            list.add((nbOp +1+ i) * -1);
            i++;
        }
    }

    public Clause(BitExp state, int nbOp){
        list = new ArrayList<Integer>();
        BitVector bPos = state.getPositive();
        int i = 0;
        for(int index = 0; index <bPos.cardinality();index++){
            i = bPos.nextSetBit(i);
            list.add(nbOp+1+i);
            i++;
        }

        BitVector bNeg = state.getNegative();
        System.out.println("------------> " +bNeg.toString());
        System.out.println("------------> " +bPos.toString());

        i = 0;
        for(int index = 0; index <bNeg.cardinality();index++){
            i = bNeg.nextSetBit(i);
            list.add((nbOp + 1+i) * -1);
            i++;
        }
    }

    public String toString(){
        String res = "" ;
        
        if(action != -1){
            for (Integer p : list) {
                res+= "(-"+action+" ∨ ";
                res += p+ " ) ∧ ";
            }
            res = res.substring(0,res.length()-2);
        }else{
            res += "(";
            for (Integer p : list) {
                res += p+ " ∧ ";
            }
            res = res.substring(0,res.length()-2);
            res += ")";
        }
        
        return res;
    }
}
