package org.thcic.xapx.draw.service;

import java.awt.Font;

import org.jfree.chart.StandardChartTheme;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {

	public StandardChartTheme getCNTheme() {
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.BOLD, 16));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.BOLD, 16));
		return standardChartTheme;
	}

}
