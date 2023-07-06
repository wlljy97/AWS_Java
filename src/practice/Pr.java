package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Pr {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        // 값 추가(put)
        map.put("이름", "김준일");
        map.put("연락처", "01099881916");
        map.put("주소", "부산 동래구 사직동");
        map.put("a", "");
        map.put("b", "");
        map.put("c", "");
        map.put("d", "");
        map.put("e", "");

        System.out.println(map);

        // 값 조회
        String name = map.get("이름");
        System.out.println(name);
        String email = map.getOrDefault("이메일", "메일 정보가 없습니다.");
        System.out.println(email);

        // 값 수정
        System.out.println(map);

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            map.replace(key, "", null);
        }

        System.out.println(map);

        // 값 삭제
        map.remove("연락처");
        System.out.println(map);

        // value들만 리스트로 가져오기
        Iterator<String> iterator2 = map.values().iterator();
        while(iterator2.hasNext()) {
            String value = iterator2.next();
            System.out.println(value);
        }

        System.out.println(map.entrySet());
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator3 = entrySet.iterator();
        while(iterator3.hasNext()) {
            Map.Entry<String, String> entry = iterator3.next();
            
            System.out.println(entry);
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }

    }
}

