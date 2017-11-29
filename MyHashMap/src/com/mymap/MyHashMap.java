package com.mymap;

public class MyHashMap implements MyMap {

	private static final int HASH_RANGE = 100;
	private static final int INITIAL_BUCKET_SIZE = 4;
	private int size = 0;
	private Pair[][] table;

	public MyHashMap() {
		table = new Pair[HASH_RANGE][];
	}

	public int getSize() {
		return size;
	}

	@Override
	public Object put(Object key, Object value) {
		Object _value = null;
		int hashCode = 0;

		if (key != null) {
			hashCode = key.hashCode() % HASH_RANGE;
		}

		Pair newPair = new Pair(key, value);

		Pair[] pairs = table[hashCode];

		if (pairs != null) {
			int count = 0;
			int firstVacent = -1;

			for (Pair _pair : pairs) {

				if (newPair.equals(_pair)) {
					_value = _pair.getValue();
					table[hashCode][count] = newPair;
					return _value;
				}
				if (_pair == null && firstVacent == -1) {
					firstVacent = count;
				}
				count++;
			}
			if (firstVacent == -1) {
				table[hashCode] = grow(pairs);
				firstVacent = count;
			}
			table[hashCode][firstVacent] = newPair;
			size++;
		} else {
			pairs = new Pair[INITIAL_BUCKET_SIZE];
			pairs[0] = newPair;
			table[hashCode] = pairs;
			size++;
		}
		return null;
	}

	private Pair[] grow(Pair[] pairs) {
		Pair[] _pairs = new Pair[pairs.length * 3 / 2 + 1];
		for (int i = 0; i < pairs.length; i++) {
			_pairs[i] = pairs[i];
		}
		return _pairs;
	}

	@Override
	public Object get(Object key) {
		int hashCode = 0;

		if (key != null) {
			hashCode = key.hashCode() % HASH_RANGE;
		}

		Pair newPair = new Pair(key, null);

		Pair[] pairs = table[hashCode];

		if (pairs != null) {
			for (Pair _pair : pairs) {
				if (newPair.equals(_pair)) {
					return _pair.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public boolean remove(Object key) {
		int hashCode = 0;

		if (key != null) {
			hashCode = key.hashCode() % HASH_RANGE;
		}

		Pair newPair = new Pair(key, null);

		Pair[] pairs = table[hashCode];

		if (pairs != null) {
			int count = 0;
			for (Pair _pair : pairs) {
				if (newPair.equals(_pair)) {
					pairs[count] = null;
					size--;
					return true;
				}
				count++;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (Pair[] _pairs : table) {
			if (_pairs != null) {
				for (Pair _pair : _pairs) {
					if (_pair != null) {
						str.append(_pair + ", ");
					}
				}
			}
		}
		str.setLength(str.length()-2);
		str.append("]");
		return str.toString();
	}
}
