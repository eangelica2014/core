package com.dotmarketing.db;

import com.dotcms.repackage.junit.framework.Assert;
import com.dotcms.repackage.org.junit.After;
import com.dotcms.repackage.org.junit.Before;
import com.dotcms.repackage.org.junit.BeforeClass;
import com.dotcms.repackage.org.junit.Test;
import com.dotmarketing.db.DbConnectionFactory;
import com.dotmarketing.db.HibernateUtil;

public class DbConnectionFactoryUtilTest {
    

    
    @BeforeClass
    public static void init() throws Exception {

    }
    
    @After
    @Before
    public void prep() throws Exception {
        HibernateUtil.closeSession();
    }
    
    /**
     * This test is for the inTransaction method
     * of the DBConnectionFacotry - and returns if we are in a session or not
     */
    @Test
    public void testInTransaction() throws Exception {
    	
    	
    	
    	
        Assert.assertFalse(DbConnectionFactory.inTransaction() );

    	HibernateUtil.startTransaction();
        Assert.assertTrue( DbConnectionFactory.inTransaction());
    	HibernateUtil.commitTransaction();
        Assert.assertFalse(DbConnectionFactory.inTransaction() );

    	DbConnectionFactory.getConnection();

        Assert.assertFalse(DbConnectionFactory.inTransaction() );
        HibernateUtil.closeSession();
    }
}
