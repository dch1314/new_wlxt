package org.thcic.xapx.draw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thcic.xapx.draw.service.DrawDataService;
import org.thcic.xapx.draw.service.ThemeService;

@Controller
@RequestMapping(value = "/demo/draw")
public class ChartController {

	@Autowired
	DrawDataService drawDataService;
	@Autowired
	ThemeService themeService;

	@RequestMapping(value = "/pie", method = RequestMethod.GET)
	public ModelAndView drawPie(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("image/jpeg");
		ChartFactory.setChartTheme(themeService.getCNTheme());
		PieDataset dataset = drawDataService.getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("饼图", dataset, true, true, false);
		try {
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 0.9f, chart, 800, 600, null);
		} catch (IOException e) {
		}
		return null;
	}

	@RequestMapping(value = "/line", method = RequestMethod.GET)
	public ModelAndView drawLine(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("image/jpeg");
		ChartFactory.setChartTheme(themeService.getCNTheme());
		CategoryDataset dataset = drawDataService.getLineDataset();
		JFreeChart chart = ChartFactory.createLineChart("折线图", "月份", "工作量",
				dataset,  PlotOrientation.VERTICAL, true, true, false);
		try {
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 0.9f, chart, 800, 600, null);
		} catch (IOException e) {
		}
		return null;
	}

}
