public class LeetCode925 {

    public boolean isLongPressedName(String name, String typed) {
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < name.length() && ptr2 < typed.length()) {
            if (name.charAt(ptr1) == typed.charAt(ptr2)) {
                ptr1++;
                ptr2++;
                int count1 = 1, count2 = 1;
                while (ptr1 < name.length() && name.charAt(ptr1) == name.charAt(ptr1 - 1)) {
                    ptr1++;
                    count1++;
                }
                while (ptr2 < typed.length() && typed.charAt(ptr2) == typed.charAt(ptr2 - 1)) {
                    ptr2++;
                    count2++;
                }
                if (count1 > count2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return ptr1 == name.length() && ptr2 == typed.length();
    }

//    public boolean isLongPressedName(String name, String typed) {
//        int ptr1 = 0, ptr2 = 0;
//        while (ptr2 < typed.length()) {
//            if (ptr1 < name.length() && name.charAt(ptr1) == typed.charAt(ptr2)) {
//                ptr1++;
//                ptr2++;
//            } else if (ptr2 > 0 && typed.charAt(ptr2) == typed.charAt(ptr2 - 1)) {
//                ptr2++;
//            } else {
//                return false;
//            }
//        }
//        return ptr1 == name.length();
//    }
}
