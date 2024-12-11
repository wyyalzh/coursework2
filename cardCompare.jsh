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
 cardCompare("4H", "4H");
 cardCompare("4H", "3S");
 cardCompare("4H", "7S");
 cardCompare("4H", "8C");
 cardCompare("4H", "2D");
 cardCompare("4H", "3S");
 cardCompare("4H", "3H");