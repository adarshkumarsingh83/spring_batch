package com.adarsh.spring.batch.adapter;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JaxbDateAdapter extends XmlAdapter<String, Date> {

    private final static Logger LOGGER = Logger.getLogger(JaxbDateAdapter.class);
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String marshal(Date date) throws Exception {
		return dateFormat.format(date);
	}

	@Override
	public Date unmarshal(String date) throws Exception {
		return dateFormat.parse(date);
	}

}