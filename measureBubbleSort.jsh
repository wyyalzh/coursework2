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
ArrayList<String> mergeSort(ArrayList<String> array) {  
    // 如果数组长度小于或等于1，直接返回  
    if (array.size() <= 1) {  
        return array;  
    }  

    // 找到中间索引  
    int mid = array.size() / 2;  

    // 拆分为左右两个子数组  
    ArrayList<String> left = new ArrayList<>(array.subList(0, mid));  
    ArrayList<String> right = new ArrayList<>(array.subList(mid, array.size()));  

    // 递归调用 mergeSort 对左右子数组排序  
    left = mergeSort(left);  
    right = mergeSort(right);  

    // 合并左右子数组  
    return merge(left, right);  
}
private ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right) {  
    ArrayList<String> merged = new ArrayList<>();  
    int i = 0, j = 0;  

    // 合并两个已排序的数组  
    while (i < left.size() && j < right.size()) {  
        if (cardCompare(left.get(i), right.get(j)).get(0) <= 0) {  
            merged.add(left.get(i));  
            i++;  
        } else {  
            merged.add(right.get(j));  
            j++;  
        }  
    }  

    // 添加剩余元素  
    while (i < left.size()) {  
        merged.add(left.get(i));  
        i++;  
    }  
    while (j < right.size()) {  
        merged.add(right.get(j));  
        j++;  
    }  

    return merged;  
}
long measureBubbleSort(String filename) throws IOException {  
    // 读取文件内容到 ArrayList  
    ArrayList<String> cardList = new ArrayList<>();  
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {  
        String line;  
        while ((line = br.readLine()) != null) {  
            cardList.add(line.trim()); // 添加每一行到列表中  
        }  
    }  

    // 记录开始时间  
    long startTime = System.currentTimeMillis();  

    // 执行 bubbleSort  
    bubbleSort(cardList);  

    // 记录结束时间  
    long endTime = System.currentTimeMillis();  

    // 返回执行时间（毫秒）  
    return endTime - startTime;  
}
measureBubbleSort("sort10.txt");