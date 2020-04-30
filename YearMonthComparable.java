package com.mindtree.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class YearMonthComparable {

	public static void main(String[] args) {
		MyCal m1 = new MyCal(2020, "January");
		MyCal m2 = new MyCal(2020, "December");
		MyCal m3 = new MyCal(2020, "February");
		MyCal m4 = new MyCal(2020, "April");
		MyCal m5 = new MyCal(2019, "February");
		Set<MyCal> cals = new TreeSet<MyCal>();
		cals.add(m1);
		cals.add(m2);
		cals.add(m3);
		cals.add(m4);
		cals.add(m5);
		for (MyCal myCal : cals) {

			System.out.println(myCal);

		}
	}

}

class MyCal implements Comparable<MyCal> {
	private int year;
	private String month;

	public MyCal(int year, String month) {
		super();
		this.year = year;
		this.month = month;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyCal other = (MyCal) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public int compareTo(MyCal o) {
		Date objectDate = new Date();
		Date thisDate = new Date();
		try {
			objectDate = new SimpleDateFormat("MMMM").parse("" + o.month);
			thisDate = new SimpleDateFormat("MMMM").parse("" + this.month);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (o.year != this.year) {
			return this.year-o.year;
		}else {
			return thisDate.compareTo(objectDate);
		}
	}

	@Override
	public String toString() {
		return "MyCal [year=" + year + ", month=" + month + "]";
	}

}
