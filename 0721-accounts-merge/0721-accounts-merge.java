import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        Map<String, String> parent =
                new HashMap<>();

        Map<String, String> owner =
                new HashMap<>();

        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                parent.putIfAbsent(email, email);

                owner.put(email, name);

                union(parent,
                        account.get(1),
                        email);
            }
        }

        Map<String, TreeSet<String>> unions =
                new HashMap<>();

        for (String email : parent.keySet()) {

            String root = find(parent, email);

            unions.putIfAbsent(root,
                    new TreeSet<>());

            unions.get(root).add(email);
        }

        List<List<String>> result =
                new ArrayList<>();

        for (String root : unions.keySet()) {

            List<String> list =
                    new ArrayList<>();

            list.add(owner.get(root));

            list.addAll(unions.get(root));

            result.add(list);
        }

        return result;
    }

    private String find(
            Map<String, String> parent,
            String s) {

        if (!parent.get(s).equals(s)) {

            parent.put(s,
                    find(parent, parent.get(s)));
        }

        return parent.get(s);
    }

    private void union(
            Map<String, String> parent,
            String a,
            String b) {

        String pa = find(parent, a);
        String pb = find(parent, b);

        if (!pa.equals(pb)) {
            parent.put(pa, pb);
        }
    }
}