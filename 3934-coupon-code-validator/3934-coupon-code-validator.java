class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ele = new ArrayList<>();
        List<String> gro = new ArrayList<>();
        List<String> pha = new ArrayList<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && code[i].matches("[A-Za-z0-9_]+")) {
                if (businessLine[i].equals("electronics")) {
                    ele.add(code[i]);
                } else if (businessLine[i].equals("grocery")) {
                    gro.add(code[i]);
                } else if (businessLine[i].equals("pharmacy")) {
                    pha.add(code[i]);
                } else if (businessLine[i].equals("restaurant")) {
                    res.add(code[i]);
                }
            }
        }

        Collections.sort(ele);
        Collections.sort(gro);
        Collections.sort(pha);
        Collections.sort(res);

        List<String> result = new ArrayList<>();
        result.addAll(ele);
        result.addAll(gro);
        result.addAll(pha);
        result.addAll(res);

        return result;
    }
}
