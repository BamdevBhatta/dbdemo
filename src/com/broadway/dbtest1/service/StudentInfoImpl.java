package com.broadway.dbtest1.service;

import java.util.*;

import com.broadway.dbtest1.model.Data;

public class StudentInfoImpl implements StudentInfo {

	static List<Data> list = new ArrayList<>();

	@Override
	public void add(Data t) {
		
		list.add(t);

	}

	@Override
	public List<Data> showAll() {
		return list;
	}

}
