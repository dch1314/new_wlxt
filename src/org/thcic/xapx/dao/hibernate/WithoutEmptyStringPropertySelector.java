package org.thcic.xapx.dao.hibernate;

import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

public class WithoutEmptyStringPropertySelector implements PropertySelector{
	
	private static final long serialVersionUID = -3020575451375652015L;

	public boolean include(Object object, String arg1, Type arg2) {
		// TODO Auto-generated method stub

		
		  return object!=null && !(object instanceof String && ( (String) object ).length() == 0);
		  //(!(object instanceof String) || ( (String) object ).length() == 0			      );
	}

}
