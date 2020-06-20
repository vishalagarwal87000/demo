package com.example.demo.xlparse;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Ticket;

@Component
@Configuration
public class XLParser {

	public List<Ticket> readExcel(MultipartFile multipartFile) {

		List<Ticket> listTickets = new ArrayList<Ticket>();
		try {
			InputStream excelFile = multipartFile.getInputStream();
			Workbook workbook = new XSSFWorkbook(excelFile);

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();

				Ticket ticket = new Ticket();
				int cellIndex = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					if (cellIndex == 0) {
						ticket.setId((int) currentCell.getNumericCellValue());
					} else if (cellIndex == 1) {
						ticket.setAmount(currentCell.getNumericCellValue());
					} else if (cellIndex == 2) {
						ticket.setCategory(currentCell.getStringCellValue());
					}

					cellIndex++;
				}

				listTickets.add(ticket);
			}
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTickets;
	}

}
