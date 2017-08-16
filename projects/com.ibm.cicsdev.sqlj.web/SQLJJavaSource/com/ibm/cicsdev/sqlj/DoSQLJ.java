/*@lineinfo:filename=DoSQLJ*//*@lineinfo:user-code*//*@lineinfo:1^1*/package com.ibm.cicsdev.sqlj;

/* Licensed Materials - Property of IBM                               */
/*                                                                    */
/* SAMPLE                                                             */
/*                                                                    */
/* (c) Copyright IBM Corp. 2017 All Rights Reserved                   */
/*                                                                    */
/* US Government Users Restricted Rights - Use, duplication or        */
/* disclosure restricted by GSA ADP Schedule Contract with IBM Corp   */
/*                                                                    */

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DoSQLJ {

	/*@lineinfo:generated-code*//*@lineinfo:21^1*/

//  ************************************************************
//  SQLJ context declaration:
//  ************************************************************

public static class UserContext 
extends sqlj.runtime.ref.ConnectionContextImpl
implements sqlj.runtime.ConnectionContext
{
  private static java.util.Map m_typeMap = null;
  private static final sqlj.runtime.ref.ProfileGroup profiles = new sqlj.runtime.ref.ProfileGroup();
  private static UserContext defaultContext = null;
  public UserContext(java.sql.Connection conn) 
    throws java.sql.SQLException 
  {
    super(profiles, conn);
  }
  public UserContext(java.lang.String url, java.lang.String user, java.lang.String password, boolean autoCommit) 
    throws java.sql.SQLException 
  {
    super(profiles, url, user, password, autoCommit);
  }
  public UserContext(java.lang.String url, java.util.Properties info, boolean autoCommit) 
    throws java.sql.SQLException 
  {
    super(profiles, url, info, autoCommit);
  }
  public UserContext(java.lang.String url, boolean autoCommit) 
    throws java.sql.SQLException 
  {
    super(profiles, url, autoCommit);
  }
  public UserContext(sqlj.runtime.ConnectionContext other) 
    throws java.sql.SQLException 
  {
    super(profiles, other);
  }
  public static UserContext getDefaultContext() 
  {
    if (defaultContext == null)
    {
      java.sql.Connection conn = sqlj.runtime.RuntimeContext.getRuntime().getDefaultConnection();
      if (conn != null)
      {
        try 
        {
          defaultContext = new UserContext(conn);
        }
        catch (java.sql.SQLException e) 
        {
        }
      }
    }
    return defaultContext;
  }
  public static void setDefaultContext(UserContext ctx) 
  {
    defaultContext = ctx;
  }
  public static java.lang.Object getProfileKey(sqlj.runtime.profile.Loader loader, java.lang.String profileName) 
    throws java.sql.SQLException 
  {
    return profiles.getProfileKey(loader, profileName);
  }
  public static sqlj.runtime.profile.Profile getProfile(java.lang.Object profileKey) 
  {
    return profiles.getProfile(profileKey);
  }
  public java.util.Map getTypeMap() 
  {
    return m_typeMap;
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:21^38*/
	/*@lineinfo:generated-code*//*@lineinfo:22^1*/

//  ************************************************************
//  SQLJ iterator declaration:
//  ************************************************************

class Cursor1 
extends sqlj.runtime.ref.ResultSetIterImpl
implements sqlj.runtime.PositionedIterator
{
  public Cursor1(sqlj.runtime.profile.RTResultSet resultSet) 
    throws java.sql.SQLException 
  {
    super(resultSet, 1);
  }
  public Cursor1(sqlj.runtime.profile.RTResultSet resultSet, int fetchSize, int maxRows) 
    throws java.sql.SQLException 
  {
    super(resultSet, fetchSize, maxRows, 1);
  }
  public String getCol1() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(1);
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:22^30*/
	protected Cursor1 cursor1 = null;
	protected UserContext userContext;
	
	private DataSource dataSource;

	public DoSQLJ() throws Exception {
		
		// Use JNDI to find the dataSource
		Context initialContext = new InitialContext();
		dataSource = (DataSource) initialContext.lookup("jdbc/defaultCICSDataSource");		
	}
	
	public String getCurrentTimestamp() throws Exception {
	
		String currentTimeStamp = null;

		// Obtain a DataSource Connection
		Connection connection = dataSource.getConnection();
		
		userContext = new UserContext(connection);
		
		// Execute the SQL
		/*@lineinfo:generated-code*//*@lineinfo:45^2*/

//  ************************************************************
//  #sql [userContext] cursor1 = { SELECT CURRENT TIMESTAMP FROM SYSIBM.SYSDUMMY1 };
//  ************************************************************

{
  sqlj.runtime.ConnectionContext __sJT_connCtx = userContext;
  if (__sJT_connCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext __sJT_execCtx = __sJT_connCtx.getExecutionContext();
  if (__sJT_execCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_EXEC_CTX();
  synchronized (__sJT_execCtx) {
    sqlj.runtime.profile.RTStatement __sJT_stmt = __sJT_execCtx.registerStatement(__sJT_connCtx, DoSQLJ_SJProfileKeys.getKey(0), 0);
    try 
    {
      cursor1 = new Cursor1(__sJT_execCtx.executeQuery(), __sJT_execCtx.getFetchSize(), __sJT_execCtx.getMaxRows());
    }
    finally 
    {
      __sJT_execCtx.releaseStatement();
    }
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:45^78*/
		
		// Get the results
		if (!cursor1.next()) {
			throw new Exception("Error: SQL query did not return any results");
		}
		
		currentTimeStamp = cursor1.getResultSet().getString(1);

		// Commit
		connection.commit();

		// Close the connection
		connection.close();
		
		// Return the user
		return currentTimeStamp;
	}
}/*@lineinfo:generated-code*/class DoSQLJ_SJProfileKeys 
{
  private java.lang.Object[] keys;
  private final sqlj.runtime.profile.Loader loader = sqlj.runtime.RuntimeContext.getRuntime().getLoaderForClass(getClass());
  private static DoSQLJ_SJProfileKeys inst = null;
  public static java.lang.Object getKey(int keyNum) 
    throws java.sql.SQLException 
  {
    synchronized(com.ibm.cicsdev.sqlj.DoSQLJ_SJProfileKeys.class) {
      if (inst == null)
      {
        inst = new DoSQLJ_SJProfileKeys();
      }
    }
    return inst.keys[keyNum];
  }
  private DoSQLJ_SJProfileKeys() 
    throws java.sql.SQLException 
  {
    keys = new java.lang.Object[1];
    keys[0] = DoSQLJ.UserContext.getProfileKey(loader, "com.ibm.cicsdev.sqlj.DoSQLJ_SJProfile0");
  }
}
