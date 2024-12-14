package com.JSON.ReadValues;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetails {
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private ArrayList<Data> data;
	private Support support;
}
