package org.alia4j.util;

// TODO copied from JDK
public class PairHashMap<K, L, V> {
    
    /**
     * The default initial capacity. <strong>Must</strong> be a power of two.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    /**
     * The maximum capacity, used if a higher value is implicitly specified by either of the constructors with arguments.
     * <strong>Must</strong> be a power of two <= 2<sup>30</sup>.
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    
    /**
     * The load factor used when none specified in constructor.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    /**
     * The table, resized as necessary. Length MUST Always be a power of two.
     */
    private Entry<K, L, V>[] table;
    
    /**
     * The number of key-value mappings contained in this map.
     */
    private int size;
    
    /**
     * The next size value at which to resize (capacity * load factor).
     */
    private int threshold;
    
    /**
     * The load factor for the hash table.
     * 
     * @serial
     */
    private final float loadFactor;
    
    /**
     * Constructs an empty <tt>PairHashMap</tt> with the specified initial capacity and load factor.
     * 
     * @param initialCapacity the initial capacity
     * @param loadFactor the load factor
     * @throws IllegalArgumentException if the initial capacity is negative or the load factor is non-positive
     */
    @SuppressWarnings("unchecked")
    public PairHashMap(int initialCapacity, final float loadFactor) throws IllegalArgumentException {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        
        if (initialCapacity > PairHashMap.MAXIMUM_CAPACITY)
            initialCapacity = PairHashMap.MAXIMUM_CAPACITY;
        
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        
        // Find a power of 2 >= initialCapacity
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity *= 2;
        
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
        this.table = new PairHashMap.Entry[capacity];
    }
    
    /**
     * Constructs an empty <code>PairHashMap</code> with the specified initial capacity and the default load factor (0.75).
     * 
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public PairHashMap(final int initialCapacity) throws IllegalArgumentException {
        this(initialCapacity, PairHashMap.DEFAULT_LOAD_FACTOR);
    }
    
    /**
     * Constructs an empty <tt>PairHashMap</tt> with the default initial capacity (16) and the default load factor (0.75).
     */
    @SuppressWarnings("unchecked")
    public PairHashMap() {
        this.loadFactor = PairHashMap.DEFAULT_LOAD_FACTOR;
        this.threshold = (int) (PairHashMap.DEFAULT_INITIAL_CAPACITY * PairHashMap.DEFAULT_LOAD_FACTOR);
        this.table = new PairHashMap.Entry[PairHashMap.DEFAULT_INITIAL_CAPACITY];
    }
    
    /**
     * Applies a supplemental hash function to a given hashCode, which defends against poor quality hash functions. This is
     * critical because PairHashMap uses power-of-two length hash tables, that otherwise encounter collisions for hashCodes
     * that do not differ in lower bits. Note: Null keys always map to hash 0, thus index 0.
     */
    private static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    
    /**
     * Returns index for hash code h.
     */
    private static int indexFor(final int h, final int length) {
        return h & (length - 1);
    }
    
    /**
     * Returns the number of key-value mappings in this map.
     * 
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     * 
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Returns the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the key.
     * <p>
     * More formally, if this map contains a mapping from a key {@code k} to a value {@code v} such that {@code (key==null ?
     * k==null : key.equals(k))}, then this method returns {@code v}; otherwise it returns {@code null}. (There can be at
     * most one such mapping.)
     * <p>
     * A return value of {@code null} does not <i>necessarily</i> indicate that the map contains no mapping for the key; it's
     * also possible that the map explicitly maps the key to {@code null}. The {@link #containsKey containsKey} operation may
     * be used to distinguish these two cases.
     * 
     * @see #put(Object, Object)
     */
    public V get(final K primary, final L secondary) {
        final int hash = PairHashMap.hash(primary.hashCode() + secondary.hashCode());
        for (Entry<K, L, V> e = this.table[PairHashMap.indexFor(hash, this.table.length)]; e != null; e = e.next) {
            final K k;
            final L l;
            if (e.hash == hash && ((k = e.getPrimary()) == primary || primary.equals(k))
                            && ((l = e.getSecondary()) == secondary || secondary.equals(l)))
                return e.getValue();
        }
        return null;
    }
    
    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified key.
     * 
     * @param key The key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified key.
     */
    public boolean containsKeys(final K primary, final L secondary) {
        return this.getEntry(primary, secondary) != null;
    }
    
    /**
     * Returns the entry associated with the specified key in the HashMap. Returns null if the HashMap contains no mapping
     * for the key.
     */
    private final Entry<K, L, V> getEntry(final K primary, final L secondary) {
        final int hash = PairHashMap.hash(primary.hashCode() + secondary.hashCode());
        for (Entry<K, L, V> e = this.table[PairHashMap.indexFor(hash, this.table.length)]; e != null; e = e.next) {
            final K k;
            final L l;
            if (e.hash == hash && ((k = e.getPrimary()) == primary || primary.equals(k))
                            && ((l = e.getSecondary()) == secondary || secondary.equals(l)))
                return e;
        }
        return null;
    }
    
    /**
     * Associates the specified value with the specified key in this map. If the map previously contained a mapping for the
     * key, the old value is replaced.
     * 
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for <tt>key</tt>. (A
     *         <tt>null</tt> return can also indicate that the map previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    public V put(final K primary, final L secondary, final V value) {
        final int hash = PairHashMap.hash(primary.hashCode() + secondary.hashCode());
        final int i = PairHashMap.indexFor(hash, this.table.length);
        for (Entry<K, L, V> e = this.table[i]; e != null; e = e.next) {
            final K k;
            final L l;
            if (e.hash == hash && ((k = e.getPrimary()) == primary || primary.equals(k))
                            && ((l = e.getSecondary()) == secondary || secondary.equals(l))) {
                final V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        
        this.addEntry(hash, primary, secondary, value, i);
        return null;
    }
    
    /**
     * Rehashes the contents of this map into a new array with a larger capacity. This method is called automatically when
     * the number of keys in this map reaches its threshold. If current capacity is MAXIMUM_CAPACITY, this method does not
     * resize the map, but sets threshold to Integer.MAX_VALUE. This has the effect of preventing future calls.
     * 
     * @param newCapacity the new capacity, MUST be a power of two; must be greater than current capacity unless current
     *            capacity is MAXIMUM_CAPACITY (in which case value is irrelevant).
     */
    private @SuppressWarnings("unchecked")
    void resize(final int newCapacity) {
        final Entry<K, L, V>[] oldTable = this.table;
        final int oldCapacity = oldTable.length;
        if (oldCapacity == PairHashMap.MAXIMUM_CAPACITY) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        
        final Entry<K, L, V>[] newTable = new Entry[newCapacity];
        this.transfer(newTable);
        this.table = newTable;
        this.threshold = (int) (newCapacity * this.loadFactor);
    }
    
    /**
     * Transfers all entries from current table to newTable.
     */
    private @SuppressWarnings("unchecked")
    void transfer(final Entry[] newTable) {
        final Entry<K, L, V>[] src = this.table;
        final int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry<K, L, V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    final Entry<K, L, V> next = e.next;
                    final int i = PairHashMap.indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    
    /**
     * Removes all of the mappings from this map. The map will be empty after this call returns.
     */
    public void clear() {
        final Entry<K, L, V>[] tab = this.table;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        this.size = 0;
    }
    
    private static class Entry<K, L, V> {
        
        private final int hash;
        
        private final K primary;
        
        private final L secondary;
        
        private V value;
        
        private Entry<K, L, V> next;
        
        private Entry(final int hash, final K primary, final L secondary, final V value, final Entry<K, L, V> next) {
            this.hash = hash;
            this.primary = primary;
            this.secondary = secondary;
            this.value = value;
            this.next = next;
        }
        
        public final K getPrimary() {
            return this.primary;
        }
        
        public final L getSecondary() {
            return this.secondary;
        }
        
        public final V getValue() {
            return this.value;
        }
        
        @Override
        public int hashCode() {
            int hashCode = 0;
            
            hashCode += (this.getPrimary() == null) ? 0 : this.getPrimary().hashCode();
            hashCode += (this.getSecondary() == null) ? 0 : this.getSecondary().hashCode();
            hashCode += (this.getValue() == null) ? 0 : this.value.hashCode();
            
            return hashCode;
        }
        
        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(final Object other) {
            if (this == other)
                return true;
            if (other == null)
                return false;
            if (this.getClass() != other.getClass())
                return false;
            
            final Entry<K, L, V> that = (Entry<K, L, V>) other;
            
            final K thisPrimary = this.getPrimary(), thatPrimary = that.getPrimary();
            if (thisPrimary != thatPrimary && !(thisPrimary != null && thisPrimary.equals(that.getPrimary())))
                return false;
            
            final L thisSecondary = this.getSecondary(), thatSecondary = that.getSecondary();
            if (thisSecondary != thatSecondary && !(thisSecondary != null && thisSecondary.equals(that.getSecondary())))
                return false;
            
            final V thisValue = this.getValue(), thatValue = that.getValue();
            if (thisValue != thatValue && !(thisValue != null && thisValue.equals(that.getValue())))
                return false;
            
            return true;
        }
        
        @Override
        public final String toString() {
            return "(" + this.getPrimary() + "," + this.getSecondary() + ")=" + this.getValue();
        }
    }
    
    /**
     * Adds a new entry with the specified key, value and hash code to the specified bucket. It is the responsibility of this
     * method to resize the table if appropriate. Subclass overrides this to alter the behavior of put method.
     */
    private void addEntry(final int hash, final K primary, final L secondary, final V value, final int bucketIndex) {
        final Entry<K, L, V> e = this.table[bucketIndex];
        this.table[bucketIndex] = new Entry<K, L, V>(hash, primary, secondary, value, e);
        if (this.size++ >= this.threshold)
            this.resize(2 * this.table.length);
    }
}
