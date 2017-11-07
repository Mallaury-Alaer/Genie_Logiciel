public class CoupleObj<K,V> implements Couple<K,V>{
    K key;
    V value;
    public CoupleObj(K key, V value){
	this.key = key;
	this.value = value;
    }
    public K premier(){
	return this.key;
    }
    public V second(){
	return this.value;
    }
    public void defPremier(K x){
        key = x;
    }
    public void defSecond(V y){
	value = y;
    }
    public boolean equals (Object o){
	return (key.equals(((CoupleObj) o).key) && (value.equals(((CoupleObj) o).value)));
    }
}
