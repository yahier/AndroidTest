package array;

public class ArrayCompose {
    public static void main(String[] args) {
        go();
    }

    static void go() {
        String[] a = {"1", "2"};
        String[] b = {"a", "b", "c", "d"};
        String[] c = {"x", "y", "z"};

        String[][] bigArray = new String[][]{a, b, c};
        int[] indexArray = {0, 0, 0};//初始化数组索引
        int[] sizeArray = {2, 4, 3};//计算的数组长度
        int arraySize = 3;//数组个数


        for (int i = 0; i < arraySize; i++) {
            //本轮数组的长度
            int length = sizeArray[i];
            int tempIndex = indexArray[i];
            while (tempIndex < length - 1) {
                println(bigArray, indexArray);
                tempIndex++;
                indexArray[i] = tempIndex;
            }


        }


//        int max = 6;//todo 6是怎么来的
//        for (int i = 0; i < max; i++) {
//            //反向遍历数组长度 和后面的先比较
//            for (int j = arraySize - 1; j >= 0; j--) {
//                if (i <= j) {
//                    //最低位赋值 便结束
//                    indexArray[indexArray.length - 1] = i;
//                    println(bigArray, indexArray);
//                    break;//停止本轮for
//                }
//
//                //假如在本轮中 此时 i=3
//
//
//            }
//
//        }
    }


    static void println(String[][] bigArray, int[] indexArray) {
        System.out.println("打印结果");
        for (int i = 0; i < bigArray.length; i++) {
            String[] thisArray = bigArray[i];
            int thisIndex = indexArray[i];
            System.out.print(thisArray[thisIndex]);
        }

    }


    static void printlnIndex(int[] bigArrayLength, int[] indexArray) {

        //要计算节点
        int[] nodeValues = new int[bigArrayLength.length];//[24,12,3]

        int multiple = 1;
        for (int i = bigArrayLength.length - 1; i >= 0; i--) {
            multiple = multiple * bigArrayLength[i];
            nodeValues[i] = multiple;
        }

        int times = 1;
        for (int index = 0; index < bigArrayLength.length; index++) {
            times *= bigArrayLength[index];
        }

        for (int i = 0; i < times; i++) {
            //将数组倒序
            for (int index = nodeValues.length - 1; index >= 0; index--) {
                //i的值说一定会比某一个value小的
                int value = nodeValues[index];
                if (i < value) {
                    indexArray[index] = i;
                    int left = i % value;//后一位

                    break;
                }


            }

        }


    }
}
