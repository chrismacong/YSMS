package com.cwkj.ysms.util;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;

public class BigDecimalMySQLDialect extends MySQLDialect {

	public BigDecimalMySQLDialect() {
		super();
		registerHibernateType(Types.DECIMAL,

		Hibernate.BIG_DECIMAL.getName());

		registerHibernateType(-1, Hibernate.STRING.getName());
	}

}
