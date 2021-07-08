package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {

        return table.add(t);
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        Ensemble x = new Ensemble();
        x.table = this.table;
        e.removeAll(x);
        x.table.addAll(e);

        return x;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble x = new Ensemble();
        x.table = this.table;
        x.retainAll(e);

        return x;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble x = new Ensemble();
        x.table = this.table;
        x.table.removeAll(e.table);

        return x;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble x = new Ensemble();
        x.table = this.table;
        
        Ensemble intersection = new Ensemble();
        intersection.table = this.table;
        
        x.union(e);
        intersection.inter(e);
        x.diff(intersection);
        
        return x;
    }

}
