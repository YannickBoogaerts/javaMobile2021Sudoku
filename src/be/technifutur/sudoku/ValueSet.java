package be.technifutur.sudoku;

public class ValueSet {
    private int data = 0;

    private int toMask(int val){
        return 1 << (val-1);
    }

    public boolean add(int val) {
//        boolean result = false;
//        if( ! contains(val)) {
//            int mask = toMask(val);
//            data = data | mask;
//            result = true;
//        }
//        return result;

        int anc = data;
        data |= toMask(val);
        return anc != data;
    }

    public boolean remove(int val) {
//        boolean result = false;
//        if( contains(val)){
//            int mask = toMask(val);
//            data = data ^ mask;
//            result = true;
//        }
//        return result;
        int anc = data;
        data &= ~toMask(val);
        return anc != data;
    }

    public int size() {
//        int cpt = 0;
//        for(int i = 1; i < 33 ; i++){
//           if(contains(i)){
//               cpt++;
//           }
//        }
//        return cpt;
        return Integer.bitCount(data);
    }

    public boolean contains(int val) {
        int mask = toMask(val);
        return (data & mask) == mask;
        // return data & toMask(val) != 0;
    }

    public ValueSet common(ValueSet set) {
        ValueSet result = new ValueSet();
        result.data = set.data & data;
        return result;
    }

    public ValueSet add(ValueSet set) {
        ValueSet result = new ValueSet();
        result.data = set.data | data;
        return result;
    }

    @Override
    public String toString() {
        return "ValueSet{" +
                "data=" + Integer.toBinaryString(data) +
                '}';
    }
}
