package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@see https://leetcode.com/problems/time-based-key-value-store/description/}
 *
 * @author SweetSupremum
 */
public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeBasedKeyValueStore().new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);
    }

    class TimeMap {

        Map<String, List<ValueTime>> keyTimeStampsMap;

        public TimeMap() {
            keyTimeStampsMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<ValueTime> valueTimes = keyTimeStampsMap.get(key);
            if (valueTimes != null) {
                valueTimes.add(new ValueTime(value, timestamp));
            } else {
                List<ValueTime> newValueTime = new ArrayList<>();
                newValueTime.add(new ValueTime(value, timestamp));
                keyTimeStampsMap.put(key, newValueTime);
            }
        }

        public String get(String key, int timestamp) {
            List<ValueTime> valueTimes = keyTimeStampsMap.get(key);
            if (valueTimes == null) return "";
            if (!valueTimes.isEmpty() && timestamp < valueTimes.get(0).time) {
                return "";
            }
            int left = 0;
            int right = valueTimes.size();
            while (left + 1 < right) {
                int middle = left + (right - left) / 2;
                ValueTime valueTime = valueTimes.get(middle);
                if (timestamp >= valueTime.time) {
                    left = middle;
                } else {
                    right = middle;
                }
            }
            return valueTimes.get(left).value;
        }
    }

    class ValueTime {
        int time;
        String value;

        public ValueTime(String value, int time) {
            this.value = value;
            this.time = time;
        }

    }
}
