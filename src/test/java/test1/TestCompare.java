package test1;/**
 * Created by yk on 2018/07/20
 */

import org.junit.Test;

import java.util.*;

/**
 * @Author kai
 * @Description 获取两个100万数据集的交集
 * @Create 2018-07-20 8:47
 **/
public class TestCompare {

    @Test
    public void getSameElements(){
        //获取两个10万数据量的集合
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("1111111111111");
        list1.add("22222222222222");
        list1.add("3333333333333333");
        list1.add("44444444444444444");
        list1.add("5555555555555555");
        list1.add("666666666666666666");
        list1.add("7777777777777777");
        list1.add("888888888888888888");
        list1.add("9999999999999999");
        list2.add("1111111111111");
        list2.add("22222222222222");
        list2.add("3333333333333333");
        list2.add("44444444444444444");
        list2.add("5555555555555555");
        list2.add("666666666666666666");
        list2.add("7777777777777777");
        list2.add("888888888888888888");
        list2.add("9999999999999999");
        for (int i = 0; i < 1000000; i++) {
            UUID uuid1 = UUID.randomUUID();
            list1.add(uuid1.toString());
            UUID uuid2 = UUID.randomUUID();
            list2.add(uuid2.toString());
        }
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        //计算耗时
        long before = System.currentTimeMillis();
        getSameElementByAddAllAndRemoveAll(list1, list2);
        System.out.println("总耗时 ："+ (System.currentTimeMillis() - before));
    }

    /**
     * @Title: getSameElementBySetAdd
     * @Description: 使用Set的add根据是否包含该元素，返回true/false进行判断
     *      耗时：600~700ms间
     * @author kai
     * @date 2018/7/20 9:26
     * @param [list1, list2]
     * @return void
     */
    public void getSameElementBySetAdd(List<String> list1, List<String> list2){
        Set<String> set = new HashSet<>(list1);
        //获取相同元素
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            if (!set.add(list2.get(i))) {
                //未添加成功则是重复
                result.add(list2.get(i));
            }
        }
        System.out.println(result);
    }

    /**
     * @Title: getSameElementByAddAllAndRemoveAll
     * @Description: 使用addAll，removeAll以及set的特性获取交集，但如果list1或list2本身含重复元素，只会得到一个
     *      1200~2500ms
     * @author kai
     * @date 2018/7/20 9:29
     * @param [list1, list2]
     * @return void
     */
    public void getSameElementByAddAllAndRemoveAll(List<String> list1, List<String> list2){
        //转化为set
        Set<String> set1 = new HashSet<>(list1);
        HashSet<String> cloneSet1 = (HashSet<String>) ((HashSet<String>) set1).clone();
        Set<String> set2 = new HashSet<>(list2);
        set1.addAll(set2);
        set1.removeAll(set2);
        cloneSet1.removeAll(set1);
        System.out.println(cloneSet1);
    }

    public void getSameElement(List<String> list1, List<String> list2){
    }
}
