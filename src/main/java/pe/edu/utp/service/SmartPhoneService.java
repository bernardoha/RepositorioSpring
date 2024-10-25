package pe.edu.utp.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.SmartPhone;
import pe.edu.utp.repository.SmartPhoneRepository;

@Service
public class SmartPhoneService {

    @Autowired
    private SmartPhoneRepository documentRepository;

    public SmartPhone save(SmartPhone smartPhone) {
        return documentRepository.save(smartPhone);
    }

    public List<SmartPhone> findAll() {
        return documentRepository.findAll();
    }

    public void createExcel(List<SmartPhone> smartPhones) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("smartPhones");

        for (int i = 0; i < smartPhones.size(); i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(smartPhones.get(i).getMarca());
            row.createCell(1).setCellValue(smartPhones.get(i).getModelo());
            row.createCell(2).setCellValue(smartPhones.get(i).getDescripcion());
        }

        try (FileOutputStream fileOut = new FileOutputStream("smartPhones.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public void createWordDocument(SmartPhone smartPhone) throws IOException {
        // Lógica para crear un documento de Word usando Apache POI
    }
}