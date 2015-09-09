package learn;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Workbook;
import jxl.common.Logger;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class createExcel {

	public static void main(String[] arg) {

		createExcel ce = new createExcel();
		ce.create();

	}

	private String[] title;
	private int index = 0;

	private static WritableWorkbook book = null;
	private static WritableSheet sheet = null;

	private static Logger logger = Logger.getLogger(createExcel.class);
	private String testRoot = Thread.currentThread().getContextClassLoader().getResource(".").getPath()
			.replace("target/classes/", "src/test/resources/data/");

	public void create() {

		title = new String[] { "测试名称", "流量消耗", "CPU占用", "内存占用" };

		try {
			book = Workbook.createWorkbook(new File(testRoot + "android.xls"));
			sheet = addTitle();
			addCellTitle();
		} catch (IOException e) {
			logger.debug("CreateWorkbook failed !");
			e.printStackTrace();
		}

	}

	private WritableSheet addTitle() {

		sheet = book.createSheet(getDate(), 0);
		sheet.getSettings().setDefaultColumnWidth(25);

		try {
			for (int i = 0; i < 4; i++) {
				sheet.addCell(new Label(i, 0, title[i]));
			}
		} catch (Exception e) {
		}
		index++;
		return sheet;
	}

	private void addCellTitle() {

		try {

			String[] resource = getResource();
			for (int i = 0; i < 4; i++) {
				sheet.addCell(new Label(i, index, resource[i]));
			}
			book.write();
			book.close();
		} catch (Exception e) {

		}
		index++;
	}

	private String[] getResource() {

		String[] resource = new String[] { "主页资源消耗", "20K", "20%", "20M" };

		return resource;
	}

	private String getDate() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-hh-mm");
		return dateFormat.format(date);
	}

}
