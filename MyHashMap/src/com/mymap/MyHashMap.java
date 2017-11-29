package com.mymap;

public class MyHashMap implements MyMap {

	private static final int HASH_RANGE = 100;
	private static final int INITIAL_BUCKET_SIZE = 4;
	private Pair[][] table;

	public MyHashMap() {
		table = new Pair[HASH_RANGE][];
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
			int size = 0;
			for (Pair _pair : pairs) {
				if (newPair.equals(_pair)) {
					_value = _pair.getValue();
					pairs[size] = newPair;
					return _value;
				}
				size++;
			}
			if (size >= pairs.length) {
				pairs = grow(pairs);
			}
			pairs[size] = newPair;
		} else {
			pairs = new Pair[INITIAL_BUCKET_SIZE];
			pairs[0] = newPair;
			table[hashCode] = pairs;
		}
		return null;
	}

	private Pair[] grow(Pair[] pairs) {
		Pair[] _pairs = new Pair[pairs.length * 3 / 2 + 1];
		for (int i = 0; i < pairs.length; i++) {
			_pairs[i] = pairs[i];
		}
		return null;
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
	public String toString() {
		StringBuilder str = new StringBuilder("[ ");
		for (Pair[] _pairs : table) {
			if (_pairs != null) {
				for (Pair _pair : _pairs) {
					if (_pair != null) {
						str.append("{" + _pair.getKey() + "=" + _pair.getValue() + "} ");
					}
				}
			}
		}
		str.append("]");
		return str.toString();
	}
}
