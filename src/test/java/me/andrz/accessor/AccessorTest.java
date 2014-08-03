package me.andrz.accessor;

import me.andrz.accessor.Accessor;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccessorTest {

    TestObject a;
    TestObject b;

    @Before
    public void setUp() {
        a = new TestObject();
        b = new TestObject();
        a.setChild(b);
    }

    @Test
    public void test() {
        Object value = Accessor.DEFAULT.get(a, "child.child.child");
        assertEquals(null, value);
    }

    @Test
    public void test2() {
        Accessor accessor = new Accessor();
        accessor.setting(Accessor.Setting.AUTO_SAFE_NAVIGATION, false);
        Object value = accessor.get(a, "child?.child?.child");
        assertEquals(null, value);
    }

    @Test
    public void test3() {
        Accessor accessor = new Accessor();
        accessor.setting(Accessor.Setting.AUTO_SAFE_NAVIGATION);
        Object value = accessor.get(a, "child.child.child");
        assertEquals(null, value);
    }

    private static class TestObject {
        private TestObject child;

        public TestObject getChild() {
            return child;
        }

        public void setChild(TestObject child) {
            this.child = child;
        }

        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }
    }
}
