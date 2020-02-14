package com.taiger.zombies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class ZombieCluster {

	static int zombieCluster(String[] zombiesConnectedNess) {

		HashMap<Integer, List<Integer>> zombieInterConnectedNess = new HashMap<>();
		if (zombiesConnectedNess.length == 0)
			return 0;

		for (int i = 0; i < zombiesConnectedNess.length; i++) {

			String zombieConnectedNessString = zombiesConnectedNess[i];
			for (int j = 0; j < zombiesConnectedNess.length; j++) {
				char d = zombieConnectedNessString.charAt(j);
				if (d == '1' && zombiesConnectedNess[j].charAt(i) == '1') {
					List<Integer> list = zombieInterConnectedNess.getOrDefault(i, new ArrayList<Integer>());
					list.add(j);
					zombieInterConnectedNess.put(i, list);
				}
			}
		}

		Map connectedGroups = new HashMap<Integer, TreeSet<Integer>>();
		int zombieGroupsCount = 0;
		for (Map.Entry<Integer, List<Integer>> entry : zombieInterConnectedNess.entrySet()) {

			int key = entry.getKey();
			List<Integer> val = entry.getValue();
			if (key == 0) {
				connectedGroups.put(zombieGroupsCount, new TreeSet(val));
			} else {
				Boolean zombiePresent = false;
				for (int i : val) {
					Iterator<Integer> ite = connectedGroups.keySet().iterator();
					while (ite.hasNext()) {
						int index = ite.next();
						TreeSet<Integer> connectedGroupString = (TreeSet) connectedGroups.get(index);
						if (connectedGroupString.contains(i)) {
							connectedGroupString.addAll(val);
							zombiePresent = true;
						}

					}

				}
				if (!zombiePresent) {
					connectedGroups.put(++zombieGroupsCount, new TreeSet(val));
				}
			}

		}
		return ++zombieGroupsCount;
	}

	public static void main(String[] args) {
		String[] res = { "1001", "0100", "0010", "1001" };

		int zombieClustersCount = zombieCluster(res);

		System.out.println(zombieClustersCount);

	}
}
