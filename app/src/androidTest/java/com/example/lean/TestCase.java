package com.example.lean;

import android.test.InstrumentationTestCase;

import com.example.lean.utils.TestUtil;

/**
 * Created by Administrator on 2015/10/8.
 */
public class TestCase extends InstrumentationTestCase {

    public void testAdd(){
        int result = TestUtil.addition(1,3);
        assertEquals(3,result);
    }

    public void testSQLite(){

    }

}
