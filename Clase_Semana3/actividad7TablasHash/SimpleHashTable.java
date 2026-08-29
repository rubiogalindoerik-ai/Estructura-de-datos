public class SimpleHashTable<K, V> {
    public HashNode<K, V> [] buckets;
    public int capacity;
    public int size;

    @SuppressWarnings("unchecked")
    public SimpleHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = (HashNode<K, V>[]) new HashNode[capacity];
        this.size = 0;
    }

    /*
    FUNCION DISPERCION(Hash function)
    Convierte la llave en un indice valido dentro del tamaño del arreglo
    */

    public int getBucketIndex(K key) {
        /*Funcion nativa de java para generar codigo con hash*/
        int hashCode = key.hashCode();
        /*Operacion modulo para ajustar al rango del arreglo*/
        return Math.abs(hashCode) % capacity;
    }

    /* INSERTAR
    Agrega o actualiza un valor asociado a una llave (push, enqueue)
    */

    public void put(K key, V value) {
        int BucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets[BucketIndex];
        //Buscar la llave si ya existe para actualizar su valor
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        // Si la llave no existe insertamos un nuevo nodo
        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        buckets[BucketIndex] = newNode;
    }

    // Buscar un valor a traves de su llave
    public V getV(K key) {
        // Aqui guardamos la posicion de la llave [0,1,2,3,4]
        int bucketIndex = getBucketIndex(key);
        // Guardamos el nodo de la posicion de la llave
        HashNode<K, V> actual = buckets[bucketIndex];
        // Recorrer la lista con un while
        while (actual != null) {
            if (actual.key.equals(key)) {
                return actual.value;
            }
            actual = actual.next;
        }
        System.out.println("Elemento no encontrado");
        return null;
    }

    // Mostrar
    public void showTable() {
        for(int i = 0; i < capacity; i++){
            System.out.print("Registro " + i + ": ");
            HashNode<K, V> current = buckets[i];
            if (current == null) {
                System.out.println("Vacio");
            } else {
                System.out.print(" -> ");
                while (current != null) {
                    System.out.print("[ " + current.key + " : " + current.value + " ] -> ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
}
