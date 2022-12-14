package task09911;

import java.util.*;

public class Software {
    private int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (!versionHistoryMap.containsKey(rollbackVersion)) {
            return false;
        }

        Iterator<Integer> it = versionHistoryMap.keySet().iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i > rollbackVersion) {
                it.remove();
            }
        }

        currentVersion = rollbackVersion;

        return true;
    }
}
