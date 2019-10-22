package javaBasics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2019/9/26
 * Time: 17:00
 */
public class JDK8LambdaForList {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person("xinghf-1",1,1);
        Person person2 = new Person("xinghf-2",2,2);
        Person person3 = new Person("xinghf-3",3,3);
        Person person4 = new Person("xinghf-4",4,4);
        Person person5 = new Person("xinghf-5",5,5);
        Person person6 = new Person("xinghf-6",6,6);
        Person person101 = new Person("xinghf-101",101,101);
        Person person102 = person101;
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person101);
        personList.add(person102);

        //1 Lambjda forEach()遍历
        personList.forEach(item->{
            item.setName(item.getName()+ "-xixi");
        });
        System.out.println("修改名字后输出--" + personList+"\n\n\n\n");


        // 2 stream() 流操作
        //2.1 去重distinct() ,collect(Collectors.toList()) 封装成集合;
        //只能过滤整体对象,不能实现在对象的某个值进行判定去重; 类似:new ArrayList(new HashSet(books))
        List<Person> distinctList = personList.stream().distinct().collect(Collectors.toList());
        System.out.println("去重输出--" + distinctList.toString()+"\n\n\n\n");



        //2.2对对象中的某个属性值去重;
        //根据size属性,把size属性一样的人去重
        List<Person> unique = personList.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Person::getSize))),ArrayList::new ));
        System.out.println("根据size属性去除size属性重复的Person" + unique.toString()+"\n\n\n\n");


        //2.3 排序;
        List<Person> sortedList = personList.stream().sorted(((o1, o2) -> o1.getAge()-o2.getAge())).collect(Collectors.toList());
        //age 从大到小排序输出(两种方式)
        List<Person> sortedList2 = personList.stream().sorted(((o1, o2) -> o2.getAge()-o1.getAge())).collect(Collectors.toList());
        System.out.println("根据age从小到大排序后输出--"+ sortedList);
        System.out.println("根据age从大到小排序后输出--"+ sortedList2);
        //集合比较简单的写方式;
        personList.sort((o1,o2)->{return o2.getAge()-o1.getAge();});
        System.out.println("集合从大到小数输入--" + personList+"\n\n\n\n");

        //2.4 map 提取全部对象的某一属性,并放到map中;
         List<String> nameMapList = personList.stream().map(item->item.getName()).collect(Collectors.toList());
         List<String> nameMapList2 = personList.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("使用item->item.getName方式"+ nameMapList);
        System.out.println("使用Person::getName方式"+nameMapList2+"\n\n\n\n");



        //2.5统计
            //使用sum() max() min() average()
        double sum = personList.stream().mapToDouble(item->item.getAge()).sum();
        System.out.println("年龄一共--" + sum +"\n\n\n\n");



        //2.6分组 groupingBy 属性 Collectors.groupingBy(属性)
        Map<Integer,List<Person>> map = personList.stream().collect(Collectors.groupingBy(item->item.getAge()));
        //有两个年龄等于101的
        System.out.println("按照年龄分组后的结果--" + map +"\n\n\n\n");


        //2.7 多重分组  Collectors.groupingBy(属性,Collectors.groupingBy(属性))
        Map<String,Map<Integer,List<Person>>> map2GroupBy = personList.stream().collect(Collectors.groupingBy(item->item.getName(),Collectors.groupingBy(item->item.getAge())));
        Map<String,Map<Integer,List<Person>>> map2GroupByOtherWay = personList.stream().collect(Collectors.groupingBy(Person::getName,Collectors.groupingBy(Person::getAge)));
        System.out.println("根据两个字段分组--" + map2GroupBy +"\n\n\n\n");

        //2.8 分组并计算综合;
            //Collectors.summarizingLong()
        Map<String,Map<Integer,LongSummaryStatistics>> map3 = personList.stream().collect(Collectors.groupingBy(Person::getName,Collectors.groupingBy(Person::getAge,Collectors.summarizingLong(Person::getSize))));
        System.out.println(" 分组并计算综合 ---" + map3+ "\n\n\n\n");


        //2.9 筛选
        List<Person> newPersonList = personList.stream().filter(ls->ls.getName().equals("xinghf-1-xixi")).collect(Collectors.toList());
        System.out.println("筛选出姓名为xinghf-1-xixi的---" + newPersonList + "\n\n\n\n");
    }
}
