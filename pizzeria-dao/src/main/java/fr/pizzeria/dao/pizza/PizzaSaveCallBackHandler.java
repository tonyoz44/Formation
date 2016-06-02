/**
 * 
 */
package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * @author ETY
 *
 */
public class PizzaSaveCallBackHandler implements RowCallbackHandler {

	/* (non-Javadoc)
	 * @see javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[])
	 */


	@Override
	public void processRow(ResultSet result) throws SQLException {
		
		
		
	}
	

}
