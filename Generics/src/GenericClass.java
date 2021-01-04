public class GenericClass<K, V> {

    K key;
    V value;

    public GenericClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public void setValue(final V value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}


