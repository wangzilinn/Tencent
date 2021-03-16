

class Scratch {
    public static void main(String[] args) {
        String a = "1234567890.456";
        String b = "0";
        String c = "0.00";
        String d = "7890.456";
        String e = "9999999999.999";//整数长为10位
        System.out.println(arabic2Chinese(e));
    }

    public static String arabic2Chinese(String money) {
        //异常值判断:
        if (money == null) {
            return null;
        }
        String integerPart;
        String decimalPart = null;
        if (money.contains(".")) {//分离小数
            integerPart = money.substring(0, money.indexOf("."));
            decimalPart = money.substring(money.indexOf(".") + 1);
            if (decimalPart.length() > 3) {
                return "小数位数超过限制";
            }
        } else {
            integerPart = money;
        }
        if (integerPart.length() > 10) {
            return "整数位数超过限制";
        }
        // 获得字符串中的两个数
        String originalStr =  integerToChinese(integerPart)+decimalToChinese(decimalPart);

        String finalStr = originalStr;
        // 修饰一下:
        // 出现0元时:
        if (finalStr.length() > 2) {
            finalStr = originalStr.replace("零元", "元");
        }
        return finalStr;
    }

    private static String integerToChinese(String integerPart) {
        long integer = Long.parseLong(integerPart);
        int length = integerPart.length();
        int[] integerArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            integerArray[i] = (int) (integer % 10);
            integer /= 10;
        }
        StringBuilder chineseInteger = new StringBuilder("");
        final String[] chineseNumber = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        final String[] integerUnit = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾"};
        for (int i = 0; i < length; i++) {
            chineseInteger.append(chineseNumber[integerArray[i]]).append(integerUnit[length - i - 1]);
        }
        return chineseInteger.toString();
    }

    private static String decimalToChinese(String decimalPart) {
        if (decimalPart == null) {
            return "";
        }
        int decimal = Integer.parseInt(decimalPart);
        int length = decimalPart.length();
        StringBuilder chineseDecimal = new StringBuilder("");
        int[] decimalArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            decimalArray[i] = decimal % 10;
            decimal /= 10;
        }
        final String[] chineseNumber = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        final String[] decimalUnit = {"角", "分", "厘"};
        for (int i = 0; i < length; i++) {
            chineseDecimal.append(decimalArray[i] == 0 ? "" : (chineseNumber[decimalArray[i]] + decimalUnit[i]));
        }
        return chineseDecimal.toString();
    }
}
