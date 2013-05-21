package org.thcic.xapx.draw.service;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Service;

@Service
public class DrawDataService {

	public PieDataset getPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("可行性研究", new Double(10));
		dataset.setValue("立项", new Double(15));
		dataset.setValue("需求调研", new Double(10));
		dataset.setValue("需求分析", new Double(10));
		dataset.setValue("系统设计", new Double(35));
		dataset.setValue("系统研发", new Double(40));
		dataset.setValue("系统测试", new Double(20));
		dataset.setValue("系统集成", new Double(10));
		return dataset;
	}

	public CategoryDataset getLineDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String line1 = "系统开发";
		dataset.addValue(10f, line1, new Integer(1));
		dataset.addValue(9f, line1, new Integer(2));
		dataset.addValue(7f, line1, new Integer(3));
		dataset.addValue(8f, line1, new Integer(4));
		dataset.addValue(10f, line1, new Integer(5));
		dataset.addValue(9f, line1, new Integer(6));
		dataset.addValue(11f, line1, new Integer(7));
		String line2 = "软件测试";
		dataset.addValue(6f, line2, new Integer(1));
		dataset.addValue(5f, line2, new Integer(2));
		dataset.addValue(4f, line2, new Integer(3));
		dataset.addValue(5f, line2, new Integer(4));
		dataset.addValue(6f, line2, new Integer(5));
		dataset.addValue(5f, line2, new Integer(6));
		dataset.addValue(7f, line2, new Integer(7));
		return dataset;
	}
}
