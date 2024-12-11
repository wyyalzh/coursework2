ArrayList<Integer> cardCompare(String card1, String card2) {
    ArrayList<Integer> result = new ArrayList<>(); // 创建结果的 ArrayList

    // 获取花色优先级
    int suit1 = getSuitPriority(card1.charAt(card1.length() - 1));
    int suit2 = getSuitPriority(card2.charAt(card2.length() - 1));
    
    // 首先比较花色
    if (suit1 < suit2) {
        result.add(-1);  // card1 小于 card2
    } else if (suit1 > suit2) {
        result.add(1);   // card1 大于 card2
    } else {
        // 花色相同的情况下比较数值
        int rank1 = getCardRank(card1);
        int rank2 = getCardRank(card2);
        
        if (rank1 < rank2) {
            result.add(-1);  // card1 小于 card2
        } else if (rank1 > rank2) {
            result.add(1);   // card1 大于 card2
        } else {
            result.add(0);   // card1 等于 card2
        }
    }
    
    return result; // 返回结果
}
int getCardRank(String card) {
    String numberPart = card.substring(0, card.length() - 1);
    return Integer.parseInt(numberPart);  // 返回数值
}
int getSuitPriority(char suit) {
    switch (suit) {
        case 'H': return 0; // Hearts
        case 'C': return 1; // Clubs
        case 'D': return 2; // Diamonds
        case 'S': return 3; // Spades
        default: throw new IllegalArgumentException("无效花色: " + suit);
    }
}
ArrayList<String> bubbleSort(ArrayList<String> array) {
    ArrayList<String> sortedList = new ArrayList<>(array);
    
    // Bubble Sort 算法实现
    int n = sortedList.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // 比较两个卡片，使用 cardCompare 方法
            if (cardCompare(sortedList.get(j), sortedList.get(j + 1)).get(0) > 0) {
                // 交换
                String temp = sortedList.get(j);
                sortedList.set(j, sortedList.get(j + 1));
                sortedList.set(j + 1, temp);
            }
        }
    }
    
    return sortedList;
}
 var list = new ArrayList<String>(List.of("4H", "3S", "7S", "8C", "2D", "3H"));
 bubbleSort(list);