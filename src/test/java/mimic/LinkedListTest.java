package mimic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

//    @Test
//    void should_remove_first_null_element_when_remove_null() {
//        List<String> list = new LinkedList<>();
//        list.add(null);
//        list.add(null);
//        list.remove(null);
//        assertEquals(1,list.size());
//    }
//
//    @Test
//    void should_remove_first_same_element_when_remove() {
//        List<String> list = new LinkedList<>();
//        list.add("hello world");
//        list.add("aaa");
//        list.add("bbb");
//        list.add("hello world");
//
//        list.remove("hello world");
//
//        assertEquals(3,list.size());
//    }
//
//    @Test
//    void remove_not_exist_element() {
//        List<String> list = new LinkedList<>();
//        list.add("aaa");
//        list.add("bbb");
//        list.add("ccc");
//
//        assertEquals(false,list.remove("ddd"));
//    }
//
//    @Test
//    void remove_exist_element() {
//        List<String> list = new LinkedList<>();
//        list.add("aaa");
//
//        assertEquals(true,list.remove("aaa"));
//    }
//
//    @Test
//    void remove_exist_e() {
//        List<String> list = new LinkedList<>();
//        list.add(null);
//
//        assertEquals(true,list.remove(null));
//    }

    @Test
    void test01() {
        List<String> list = new LinkedList<>();

        assertEquals(false,list.remove(null));
    }

    @Test
    void test02() {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("hello");
        list.add(null);
        list.add("www");

        assertEquals(true,list.remove(null));
    }

    @Test
    void test03() {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("hello");
        list.add("www");

        assertEquals(false,list.remove(null));
    }

    @Test
    void test04() {
        List<String> list = new LinkedList<>();

        assertEquals(false,list.remove("hello"));
    }

    @Test
    void test05() {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("hello");
        list.add("www");
        list.add("hello");

        assertEquals(true,list.remove("hello"));
    }

    @Test
    void test06() {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("hello");
        list.add("www");

        assertEquals(false,list.remove("ddd"));
    }

}
